package member.center.com.pojo;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
@Builder  //链式编程注解 Entity.builder()... .build()
@ToString
@Document(collection="school")  //mogodb中表名school 映射实体School2(实体名称和mogodb中表名表名不一致时使用该注解)
public class School2 {
    private  String  id;
    private  String  name;
    private  Integer age;
    @Field("school_name")  //mogodb中字段时school_name 映射实体schoolName(驼峰) --- 实体和数据库中字段不一致时使用该注解
    private  String  schoolName;


    public static void main(String[] args) {
        School2 user = School2.builder().id("1").name("allen").age(100).build();
        System.out.println(user.getAge());
        System.out.println(user);

    }
}
