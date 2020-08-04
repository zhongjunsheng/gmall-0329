package member.provider.controller;


import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

@Document(indexName = "item",type = "product",shards = 3,replicas = 0)  //申明index(库)和type(表)
@Data
public class Item {
    @Id
    private Long id;
    @Field(type = FieldType.Text,analyzer = "ik_smart")  //分词搜索analyzer = "ik_max_word"--细粒度
    private String title;
    @Field(type = FieldType.Keyword)
    private String category;
    @Field(type =FieldType.Double)
    private Double price;
    @Field(type = FieldType.Keyword)   //Keyword表示精确搜索
    private String brand;
    @Field(type = FieldType.Keyword,index = false)
    private String images;

    public Item(){

    }
    public Item(Long id, String title, String category, Double price, String brand, String images) {
        this.id = id;
        this.title = title;
        this.category = category;
        this.price = price;
        this.brand = brand;
        this.images = images;
    }

}

