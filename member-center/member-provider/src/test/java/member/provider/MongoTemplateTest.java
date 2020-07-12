//package member.provider;
//
//import member.center.com.pojo.Student;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.data.domain.*;
//import org.springframework.data.mongodb.core.MongoTemplate;
//import org.springframework.data.mongodb.core.mapreduce.GroupBy;
//import org.springframework.data.mongodb.core.mapreduce.GroupByResults;
//import org.springframework.data.mongodb.core.query.Criteria;
//import org.springframework.data.mongodb.core.query.Query;
//import org.springframework.data.mongodb.core.query.Update;
//import org.springframework.data.querydsl.QuerydslUtils;
//import org.springframework.data.repository.support.PageableExecutionUtils;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import java.util.List;
//import java.util.regex.Pattern;
//
//@RunWith(SpringRunner.class)
//@SpringBootTest
//public class MongoTemplateTest {
//
//    /**
//     * 不用任何配置直接使用mongoTemplate
//     */
//    @Autowired
//    private MongoTemplate mongoTemplate;
//
//    @Test
//    public void insert(){
//        Student stu = new Student("5","pyh",18);
//        mongoTemplate.insert(stu);
//        Student stu2 = new Student("6","pyh",18);
//        mongoTemplate.insert(stu2);
//    }
//
//    /**
//     * insert和save方法均能用于新增操作，其区别在于，在使用insert时，如果主键存在，
//     * 那么就会报异常，而对于save方法，如果主键存在，就会更新已经存在的数据。
//     */
//    @Test
//    public void save(){
//        Student stu = new Student("7","pyh77",18);
//        mongoTemplate.save(stu);
//
//    }
//
//
//    @Test
//    public void update(){
//        //Criteria是条件栓选器
//        //构造查询条件--意思事跟新id="5" and name ="pyh77"的记录/文档
//        //Query query = Query.query(Criteria.where("id").is("7").and("name").is("pyh77"));
//        Query query = Query.query(Criteria.where("id").gte("1"));
//        Update update = Update.update("name", "张三丰66");
//        //1.跟新符合条件的第一条
//        //mongoTemplate.updateFirst(query, update, Student.class);
//        //2.存在就跟新 不存在就插入
//        //mongoTemplate.upsert(query, update, Student.class);
//        //3.范围跟新--跟新符合条件的所有数据
//        mongoTemplate.updateMulti(query, update, Student.class);
//    }
//
//    @Test
//    public void remove(){
////        Query query = Query.query(Criteria.where("id").is("7"));
////        mongoTemplate.remove(query, Student.class);
//        Query query = Query.query(Criteria.where("id").gte("5"));
//        mongoTemplate.remove(query, Student.class);
//
//    }
//
//    @Test
//    public void query(){
////
////        //1.查询所有
////        List<Student> all = mongoTemplate.findAll(Student.class);
////        System.out.println(all);
////
////        //2.根据主键查询
////        Student byId = mongoTemplate.findById("1", Student.class);
////        System.out.println(byId);
//
////        //多条件查询--最常用
////        Criteria criteria = Criteria.where("id").is("2").and("name").is("张三丰66");
//////        Query query = new Query(criteria);
////        List<Student> students = mongoTemplate.find(query, Student.class);
////        System.out.println(students);
////        System.out.println("====");
////        Criteria criteria2 = Criteria.where("id").gt("2");
////        Query query2 = new Query(criteria2);
////        //排序
////        query2.with(Sort.by(Sort.Order.desc("id")));
////        List<Student> students2 = mongoTemplate.find(query2, Student.class);
////        System.out.println(students2);
//
////        //模糊查询
////        //完全匹配--精确
////        Pattern pattern1 = Pattern.compile("^张三丰$", Pattern.CASE_INSENSITIVE);
////        //右匹配
////        Pattern pattern2 = Pattern.compile("^.*张三丰$", Pattern.CASE_INSENSITIVE);
////        //左匹配
////        Pattern pattern3 = Pattern.compile("^张三丰.*$", Pattern.CASE_INSENSITIVE);
////        //模糊匹配
////        Pattern pattern4 = Pattern.compile("^.*张三丰.*$", Pattern.CASE_INSENSITIVE);
////        Criteria criteria4 = Criteria.where("name").regex(pattern4);
////        Query query4 = new Query(criteria4);
////        List<Student> students1 = mongoTemplate.find(query4, Student.class);
////        System.out.println(students1);
//
//         //分组查询
//        Criteria criteria = Criteria.where("id").gte("1");
//        GroupBy groupBy = new GroupBy("name");
//        GroupByResults<Student> stucent = mongoTemplate.group(criteria, "student", groupBy, Student.class);
//        System.out.println(stucent.getCount());
//        System.out.println(stucent.getRawResults());
//
//    }
//
//
//
//    @Test
//    public  void page(){
//        Query query = Query.query(Criteria.where("id").gte("1"));
//        // 每页五个
//        //Pageable pageable = new PageRequest(pageIndex, pageSize); // get 5 profiles on a page
//        //mongo是从0开始的 第一页是0
//        //Pageable pageable = new PageRequest(0, 2); // get 5 profiles on a page
//        Pageable pageable = PageRequest.of(0, 2); // get 5 profiles on a page
//        query.with(pageable);
//        //多个字段排序
//        //query.with(Sort.by(Sort.Order.desc("id"),Sort.Order.desc("name")));
//        // 排序
//        query.with(Sort.by(Sort.Order.desc("id")));
//        List<Student> items = mongoTemplate.find(query, Student.class);
//        // System.out.println("stories:" + stories.size() + " count:" + count);
//        Page<Student> page = PageableExecutionUtils.getPage(items, pageable, () -> 0);
//        System.out.println(page.getTotalElements()); //总共数量
//        System.out.println(page.getTotalPages());  //页数
//        System.out.println(page.getContent());    //当前页数据
//
//    }
//
//
//
//
//}
