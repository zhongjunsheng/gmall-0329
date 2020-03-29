package member.center.com.pojo;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

@Data
@ToString
public class Student implements Serializable {
    private String _id;
    private String name;
    private Integer age;

    public Student(String _id, String name, Integer age) {
        this._id = _id;
        this.name = name;
        this.age = age;
    }
}