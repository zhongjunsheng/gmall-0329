package member.provider;

import member.center.com.api.ElasticSearchHighService;
import member.center.com.pojo.Item;
import member.provider.serviceimpl.ElasticSearchRespository;
import org.elasticsearch.index.query.MatchQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.query.TermQueryBuilder;
import org.elasticsearch.search.sort.SortBuilders;
import org.elasticsearch.search.sort.SortOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.LinkedList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ElasticSearchApplicationTests {
    private static final Logger log = LoggerFactory.getLogger(ElasticSearchApplicationTests.class);

    //@Autowired
    //主要用于创建索引和映射--7.x后弃用elasticsearchTemplate 改用ElasticsearchRestTemplate
    //private ElasticsearchTemplate elasticsearchTemplate;
    @Autowired
    private ElasticSearchRespository elasticSearchRespository;  //主要是CRUD操作

    @Autowired
    private ElasticSearchHighService elasticSearchHighService;  //高亮搜索


//    //创建索引
//    @Test
//    public void createIndex() {
//        elasticsearchTemplate.createIndex(Item.class); //索引
//        elasticsearchTemplate.putMapping(Item.class); // 映射
//    }


    //新增一条文档
    @Test
    public void addDoc() {
        Item item = new Item(1L, "小米手机2", "手机39", 6499.00, "小米", "http:xiaomi.com/phone.png2");
        elasticSearchRespository.save(item);
        log.info("插入数据:{}-----------成功",item.toString());
    }



    //批量新增文档
    @Test
    public void batchAddDoc() {
        List<Item> list = new LinkedList<>();
        Item item1 = new Item(1L, "苹果手机", "手机", 1999.00, "苹果", "http:xiaomi.com/apple1.png");
        Item item2 = new Item(2L, "华为手机", "手机", 2999.00, "华为", "http:xiaomi.com/apple2.png");
        Item item3 = new Item(3L, "华为pro", "手机", 3999.00, "oppo", "http:xiaomi.com/apple3.png");
        Item item4 = new Item(4L, "小米机", "手机", 4999.00, "小米", "http:xiaomi.com/apple4.png");
        Item item5 = new Item(5L, "为啥呢", "电子设备", 5999.00, "杂牌手机", "http:xiaomi.com/huawei5.png");
        list.add(item2);
        list.add(item3);
        list.add(item1);
        list.add(item4);
        list.add(item5);
        elasticSearchRespository.saveAll(list);
    }

    //跟新文档
    @Test
    public void updateDoc() {

        //主键一样时 再次save就是跟新
        Item item = new Item(5L, "为啥呢", "手机", 8688.00, "小米", "http:xiaomi.com/phone.png");
        elasticSearchRespository.save(item);

    }

    //删除文档 相当与记录
    @Test
    public void deleteDoc() {

        //主键一样时 再次save就是跟新
        Item item = new Item();
        item.setId(1L);
        //elasticSearchRespository.delete(item);
        elasticSearchRespository.deleteAll();
        //或者
        //itemRespository.deleteById(1L);

    }


    //搜索查询
    @Test
    public void search() {
        //查询所有文档
//        Iterable<Item> all = itemRespository.findAll();
//        all.forEach(item -> System.out.println(item.toString()));

        //根据主键id查询
//        Optional<Item> simple = itemRespository.findById(1L);
//        System.out.println(simple.get().toString());

        //所有商品--排序查询
        Iterable<Item> price = elasticSearchRespository.findAll(Sort.by("price").descending()); //根据价格排序倒序
        price.forEach(item -> System.out.println(item.toString()));

    }


    //自定义查询
    @Test
    public void searchByZDY() {

        //查询手机价格小于5000的数据
//       List<Item> all = itemRespository.findByTitleAndPriceLessThan("手机", 5000d);
//       all.forEach(item -> System.out.println(item.toString()));


        //根据title模糊查询--  相当于 like %xxx%
       //List<Item> all = elasticSearchRespository.findByTitle("华为手机");
       //all.forEach(item -> System.out.println(item.toString()));
        List<Item> all = elasticSearchRespository.findByCategory("手");
        all.forEach(item -> System.out.println(item.toString()));


        //价格区间查询
//        List<Item> all = itemRespository.findByPriceBetween(4900d, 6000d);
//        all.forEach(item -> System.out.println(item.toString()));

        //价格大于等于
        //List<Item> all = elasticSearchRespository.findByPriceGreaterThan(4900d);
        //all.forEach(item -> System.out.println(item.toString()));

    }


    //高级通用模糊查询
    @Test
    public void commontSearch() {

        //匹配对应field字段查询
        MatchQueryBuilder query = QueryBuilders.matchQuery("title", "小米");
        Iterable<Item> search = elasticSearchRespository.search(query);
        search.forEach(item -> System.out.println(item.toString()));
    }




    //高级通用精确查询
    @Test
    public void termSearch() {
        //匹配对应field字段查询
        //注意这里的搜索需要用加上.keyword, 比如说你想在字段category上精确搜索 那么就用category.keyword
        TermQueryBuilder query = QueryBuilders.termQuery("category.keyword", "手机");
        Iterable<Item> search = elasticSearchRespository.search(query);
        search.forEach(item -> System.out.println(item.toString()));
    }

    //*****
    //自定义通用查询 -- 最常用--分页
    @Test
    public void nativeSearch() {

        //自定义查询构建器
        NativeSearchQueryBuilder queryBuilder = new NativeSearchQueryBuilder();
        //定义基本查询条件--title包含手机的
        queryBuilder.withQuery(QueryBuilders.matchQuery("title", "手机")); //普通查询
        //添加分页查询条件 --需要的话
        queryBuilder.withPageable(PageRequest.of(1,2)); //查询第2页(页码重0开始的) 每页显示10条
        //执行分页查询

        //排序查询
        queryBuilder.withSort(SortBuilders.fieldSort("price").order(SortOrder.DESC)); //根据价格降序返回
        Page<Item> search = elasticSearchRespository.search(queryBuilder.build());
        System.out.println(search.getSize());
        System.out.println(search.getTotalPages());
        System.out.println(search.getTotalElements());
        System.out.println(search.getNumber());
        search.getContent().forEach(item -> System.out.println(item.toString()));
    }


    /**
     * 高亮搜索
     */
    @Test
    public  void  queryMatch(){
        List<Item> items = elasticSearchHighService.findByTitleAndHighlightAdnPageable("华为手机", 1, 10);
        System.out.println("=========="+ items.size());
        items.stream().forEach(System.out::println);
    }

    /**
     * 精确查询
     */
    @Test
    public  void  term(){
        List<Item> items = elasticSearchHighService.searchTerm("手机");
        items.stream().forEach(System.out::println);
    }


}
