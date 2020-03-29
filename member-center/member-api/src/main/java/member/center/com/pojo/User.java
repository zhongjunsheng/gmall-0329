package member.center.com.pojo;

import lombok.Data;

@Data
public class User {
    private Long id;
    private String username;
    private String pwd;
    private String address;
    private String flag;
    private String parentCode;

    public User(){}
    public User(Long id, String username, String pwd, String address, String flag, String parentCode) {
        this.id = id;
        this.username = username;
        this.pwd = pwd;
        this.address = address;
        this.flag = flag;
        this.parentCode = parentCode;
    }
}
