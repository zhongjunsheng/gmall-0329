package member.center.com.api;//package member.provider.serviceimpl;
//
//import member.center.com.pojo.Student;
//import org.springframework.data.mongodb.repository.MongoRepository;
//
//import java.util.List;
//
///**
// * mangoDB-springdata用法
// */
//public interface MongoDbService extends MongoRepository<Student,String> {
//    //自定义crud方法
//    List<Student> findByName(String name);
//    List<Student> findByAgeLessThanEqual(int age);
//    List<Student> findByAgeBetween(int a,int b);
//    List<Student> findByNameLike(String name);
//
//
//}
