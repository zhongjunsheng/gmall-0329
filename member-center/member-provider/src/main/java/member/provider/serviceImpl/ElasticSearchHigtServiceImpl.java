package member.provider.serviceImpl;

import member.provider.controller.Item;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightBuilder;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightField;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.data.elasticsearch.core.SearchResultMapper;
import org.springframework.data.elasticsearch.core.aggregation.AggregatedPage;
import org.springframework.data.elasticsearch.core.aggregation.impl.AggregatedPageImpl;
import org.springframework.data.elasticsearch.core.query.NativeSearchQuery;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class ElasticSearchHigtServiceImpl implements ElasticSearchHigtService {


    @Autowired
    private ElasticsearchRestTemplate elasticsearchRestTemplate;


    @Override
    public List<Item> findByTitleAndHighlightAdnPageable(String title, int page, int size) {

        HighlightBuilder.Field nameField = new HighlightBuilder
                .Field("*")
                .preTags("<span style='color:red'>")
                .postTags("</span>").requireFieldMatch(false);

        //多字段高亮查询，可同时在title和brand查询 对应实体类中的属性名
        NativeSearchQuery nativeSearchQuery = new NativeSearchQueryBuilder()
                .withQuery(QueryBuilders.multiMatchQuery(title, "title", "brand"))  //要高亮搜索的Filed
                .withPageable(PageRequest.of(page - 1, size))
                .withHighlightFields(nameField)
                .build();
        AggregatedPage<Item> items = elasticsearchRestTemplate.queryForPage(nativeSearchQuery, Item.class, searchResultMapper());

        return items.getContent();
    }


    private  SearchResultMapper searchResultMapper(){
        SearchResultMapper searchResultMapper = new SearchResultMapper() {
            @Override
            public <T> AggregatedPage<T> mapResults(SearchResponse response, Class<T> clazz, Pageable pageable) {
                SearchHits searchHits = response.getHits();
                SearchHit[] hits = searchHits.getHits();
                ArrayList<Item> products = new ArrayList<>();
                for (SearchHit hit : hits) {
                    Item item = new Item();
                    //原始map--存储数据的map  key是对应的映射类属性
                    Map<String, Object> sourceAsMap = hit.getSourceAsMap();
                    item.setId(Long.valueOf((Integer)sourceAsMap.get("id")));
                    item.setTitle(sourceAsMap.get("title").toString());
                    item.setPrice(Double.parseDouble(sourceAsMap.get("price").toString()));
                    item.setImages(sourceAsMap.get("images").toString());
                    item.setCategory(sourceAsMap.get("category").toString());
                    item.setBrand(sourceAsMap.get("brand").toString());
                    //高亮显示命中的document
                    Map<String, HighlightField> highlightFields = hit.getHighlightFields();
                    if (highlightFields.get("title") != null) {
                        String titleHighlight = highlightFields.get("title").getFragments()[0].toString();
                        item.setTitle(titleHighlight);
                    }
                    if (highlightFields.get("brand") != null) {
                        String brandHighlight = highlightFields.get("description").getFragments()[0].toString();
                        item.setBrand(brandHighlight);
                    }
                    products.add(item);
                }
                return new AggregatedPageImpl<>((List<T>) products);
            }

            @Override
            public <T> T mapSearchHit(SearchHit searchHit, Class<T> aClass) {
                return null;
            }
        };
        return searchResultMapper;
    }

}
