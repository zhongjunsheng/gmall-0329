package member.center.com.api;

import member.center.com.pojo.Item;

import java.util.List;

public interface ElasticSearchHighService {
    /**
     *
     * 高亮模糊搜索
     * match和term的区别:
     * match：模糊匹配，需要指定字段名在指定字段上进行搜索，并且会对输入的查询字符串进行分词，依据分词的结果进行查询。
     * term: 不分词查询，该查询与match查询的区别就是不会对查询字符串进行分词处理，但同样需要指定查询字段。比如检索“华为手机”，
     *       就不会分为“华为”和“手机”两个条件进行检索，而是直接检索“华为手机”
     * query_string：和match类似，但是match需要指定字段名，query_string不需要指定字段名，是在所有字段中搜索，范围更广泛
     * term查询高亮(title)
     * @param queryName
     * @param page
     * @param size
     * @return
     */
    List<Item> highSearchByQueryName(String queryName, int page, int size);





    /**
     * 精确查询  --- term查询
     */
    List<Item>  searchTerm(String keyWord);


    /**
     * 高亮match查询总数
     * @param queryName
     * @return
     */
    Integer findCountByName(String queryName);
}
