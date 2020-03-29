//package member.provider;
//
//import member.provider.controller.Item;
//import member.provider.serviceImpl.ElasticSearchRespository;
//import org.elasticsearch.index.query.MatchQueryBuilder;
//import org.elasticsearch.index.query.QueryBuilders;
//import org.elasticsearch.search.sort.SortBuilders;
//import org.elasticsearch.search.sort.SortOrder;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.PageRequest;
//import org.springframework.data.domain.Sort;
//import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
//import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import java.util.LinkedList;
//import java.util.List;
//
//@RunWith(SpringRunner.class)
//@SpringBootTest
//public class ElastriSearchApplicationTests {
//
//    @Autowired
//    private ElasticsearchTemplate elasticsearchTemplate;  //主要用于创建索引和映射
//    @Autowired
//    private ElasticSearchRespository elasticSearchRespository;  //主要是CRUD操作
//
//    //创建索引
//    @Test
//    public void createIndex() {
//        elasticsearchTemplate.createIndex(Item.class); //索引
//        elasticsearchTemplate.putMapping(Item.class); // 映射
//    }
//
//
//    //新增一条文档
//    @Test
//    public void addDoc() {
//
//        Item item = new Item(1L, "小米手机", "手机", 3499.00, "小米", "http:xiaomi.com/phone.png");
//        elasticSearchRespository.save(item);
//    }
//
//    //批量新增文档
//    @Test
//    public void batchAddDoc() {
//        List<Item> list = new LinkedList<>();
//        Item item2 = new Item(4L, "苹果手机10", "手机", 6999.00, "苹果", "http:xiaomi.com/apple2.png");
//        Item item3 = new Item(5L, "荣耀v10", "手机", 7999.00, "华为", "http:xiaomi.com/huawei2.png");
//        list.add(item2);
//        list.add(item3);
//        elasticSearchRespository.saveAll(list);
//    }
//
//    //跟新文档
//    @Test
//    public void updateDoc() {
//
//        //主键一样时 再次save就是跟新
//        Item item = new Item(1L, "小米手机7", "手机", 4688.00, "小米", "http:xiaomi.com/phone.png");
//        elasticSearchRespository.save(item);
//
//    }
//
//    //删除文档 相当与记录
//    @Test
//    public void deleteDoc() {
//
//        //主键一样时 再次save就是跟新
//        Item item = new Item();
//        item.setId(1L);
//        elasticSearchRespository.delete(item);
//        //或者
//        //itemRespository.deleteById(1L);
//
//    }
//
//
//    //搜索查询
//    @Test
//    public void search() {
//        //查询所有文档
////        Iterable<Item> all = itemRespository.findAll();
////        all.forEach(item -> System.out.println(item.toString()));
//
//        //根据主键id查询
////        Optional<Item> simple = itemRespository.findById(1L);
////        System.out.println(simple.get().toString());
//
//        //所有商品--排序查询
//        Iterable<Item> price = elasticSearchRespository.findAll(Sort.by("price").descending()); //根据价格排序倒序
//        price.forEach(item -> System.out.println(item.toString()));
//
//    }
//
//
//    //自定义查询
//    @Test
//    public void searchByZDY() {
//
//        //查询手机价格小于5000的数据
////       List<Item> all = itemRespository.findByTitleAndPriceLessThan("手机", 5000d);
////       all.forEach(item -> System.out.println(item.toString()));
//
//
//        //根据title模糊查询
////       List<Item> all = itemRespository.findByTitle("华为手机");
////       all.forEach(item -> System.out.println(item.toString()));
//
//
//        //价格区间查询
////        List<Item> all = itemRespository.findByPriceBetween(4900d, 6000d);
////        all.forEach(item -> System.out.println(item.toString()));
//
//        //价格大于等于
//        List<Item> all = elasticSearchRespository.findByPriceGreaterThan(4900d);
//        all.forEach(item -> System.out.println(item.toString()));
//
//    }
//
//
//    //高级通用查询
//    @Test
//    public void commontSearch() {
//
//        //匹配对应field字段查询
//        MatchQueryBuilder query = QueryBuilders.matchQuery("title", "手机");
//        Iterable<Item> search = elasticSearchRespository.search(query);
//        search.forEach(item -> System.out.println(item.toString()));
//
//    }
//
//    //*****
//    //自定义通用查询 -- 最常用--分页
//    @Test
//    public void nativeSearch() {
//
//        //自定义查询构建器
//        NativeSearchQueryBuilder queryBuilder = new NativeSearchQueryBuilder();
//        //定义基本查询条件--title包含手机的
//        queryBuilder.withQuery(QueryBuilders.matchQuery("title", "手机")); //普通查询
//        //添加分页查询条件 --需要的话
//        queryBuilder.withPageable(PageRequest.of(1,2)); //查询第2页(页码重0开始的) 每页显示10条
//        //执行分页查询
//
//        //排序查询
//        queryBuilder.withSort(SortBuilders.fieldSort("price").order(SortOrder.DESC)); //根据价格降序返回
//        Page<Item> search = elasticSearchRespository.search(queryBuilder.build());
//        System.out.println(search.getSize());
//        System.out.println(search.getTotalPages());
//        System.out.println(search.getTotalElements());
//        System.out.println(search.getNumber());
//        search.getContent().forEach(item -> System.out.println(item.toString()));
//    }
//
//
//    //聚合查询
//    @Test
//    public void juhSearch() {
//        NativeSearchQueryBuilder queryBuilder = new NativeSearchQueryBuilder();
//
//    }
//
//}
