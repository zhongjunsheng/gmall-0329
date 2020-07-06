package member.center.com.pojo;

import java.io.Serializable;


public class Student implements Serializable {
    private String _id;
    private String name;
    private Integer age;

    public Student(String _id, String name, Integer age) {
        this._id = _id;
        this.name = name;
        this.age = age;
    }

    public String get_id() {
        return _id;
    }

    public Student set_id(String _id) {
        this._id = _id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Student setName(String name) {
        this.name = name;
        return this;
    }

    public Integer getAge() {
        return age;
    }

    public Student setAge(Integer age) {
        this.age = age;
        return this;
    }

    @Override
    public String toString() {
        return "Student{" +
                "_id='" + _id + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}