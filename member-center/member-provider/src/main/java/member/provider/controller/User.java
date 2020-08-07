package member.provider.controller;


import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

@Data
@Document(indexName = "item",type = "member",shards = 3,replicas = 0)  //申明index(库)和type(表)
public class User {
    @Id
    private Long id;
    @Field(type = FieldType.Text,analyzer = "ik_smart")  //分词搜索analyzer = "ik_max_word"--细粒度
    private String name;
    @Field(type = FieldType.Keyword)
    private Integer age;
    @Field(type = FieldType.Keyword,index = false)
    private String images;
    @Field(type = FieldType.Keyword)
    private String address;

    public User(){

    }

    public User(Long id, String name, Integer age, String images, String address) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.images = images;
        this.address = address;
    }
}

