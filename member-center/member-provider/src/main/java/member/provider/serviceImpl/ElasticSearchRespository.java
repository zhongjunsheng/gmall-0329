package member.provider.serviceImpl;

import member.provider.controller.Item;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;


/**
 * Es的最佳实践 jpa用法extends ElasticsearchRepository<Item,Long>即可
 */
public interface ElasticSearchRespository extends ElasticsearchRepository<Item,Long> {

    /**
     * 自定义查询方式 要符合spring-data的约定方式
     * 如 查询都是 findBy+ 关键词  --findByTitle
     * 关键词有 and , or ,not ,is,Between,Lessthan ....
     * 先写返回类型才会有提示
     */



    //根据title 模糊查询 title 是你文档里的字段
    List<Item> findByTitle(String title);

    //LessThanEqual 小于等于  LessThan 小于
    List<Item> findByTitleAndPriceLessThan(String title,Double d);
    //title和价格组合查询
    List<Item> findByTitleAndPrice();
    //价格范围 --Between
    List<Item> findByPriceBetween(Double d1,Double d2);
    //价格小于 -- LessThan
    List<Item> findByPriceLessThan(Double d);
    //价格大于 GreaterThan
     List<Item> findByPriceGreaterThan(Double d);
}
