package member.center.com.pojo;

public class Member {
    private Integer id;
    private String name;
    private Integer age;

    public Member(){}
    public Member(Integer id, String name, Integer age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public Integer getId() {
        return id;
    }

    public Member setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Member setName(String name) {
        this.name = name;
        return this;
    }

    public Integer getAge() {
        return age;
    }

    public Member setAge(Integer age) {
        this.age = age;
        return this;
    }
}

