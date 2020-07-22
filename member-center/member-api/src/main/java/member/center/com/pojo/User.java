package member.center.com.pojo;


import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.*;

public class User {
    private Long id;

    @NotBlank(message = "姓名不能为空")
    private String username;

    @Length(min=11,max = 12,message = "密码长度有误")
    @NotNull(message = "密码不能为空")
    private String pwd;

    private String address;
    private String flag;
    private String parentCode;

    @Length(min=11,max = 11,message = "手机号码长度有误")
    @Pattern(regexp = "^1([345678])\\d{9}$",message = "手机号码非法")
    @NotBlank(message = "手机号码不能为空")
    private String phone;

    @Email(message = "邮箱非法")
    private String email;

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

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
