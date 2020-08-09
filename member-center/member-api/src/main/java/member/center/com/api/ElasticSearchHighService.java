package member.center.com.api;

import member.center.com.pojo.Item;

import java.util.List;

public interface ElasticSearchHighService {
    /**
     * match和term的区别:
     * match query搜索的时候，首先会解析查询字符串，进行分词，然后查询，而term query,输入的查询内容是什么，就会按照什么去查询，并不会解析查询内容，对它分词。
     * term查询高亮(title)
     * @param title
     * @param page
     * @param size
     * @return
     */
    List<Item> findByTitleAndHighlightAdnPageable(String title, int page, int size);

}
