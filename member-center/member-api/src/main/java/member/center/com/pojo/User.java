package member.center.com.pojo;


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

    public Long getId() {
        return id;
    }

    public User setId(Long id) {
        this.id = id;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public User setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getPwd() {
        return pwd;
    }

    public User setPwd(String pwd) {
        this.pwd = pwd;
        return this;
    }

    public String getAddress() {
        return address;
    }

    public User setAddress(String address) {
        this.address = address;
        return this;
    }

    public String getFlag() {
        return flag;
    }

    public User setFlag(String flag) {
        this.flag = flag;
        return this;
    }

    public String getParentCode() {
        return parentCode;
    }

    public User setParentCode(String parentCode) {
        this.parentCode = parentCode;
        return this;
    }
}
