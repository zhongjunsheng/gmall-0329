package member.center.com.pojo;


import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Data
public class User {

    private Long id;

    @NotBlank(message = "姓名不能为空")
    private String username;

    @Length(min=11,max = 12,message = "密码长度有误")
    @NotNull(message = "密码不能为空")
    private String pwd;

//    @Length(min=11,max = 11,message = "手机号码长度有误")
//    @Pattern(regexp = "^1([345678])\\d{9}$",message = "手机号码非法")
//    @NotBlank(message = "手机号码不能为空")
//    private String phone;
//
//    @Email(message = "邮箱非法")
//    private String email;

    private String address;
    private String flag;
    private String parentCode;

    private String  perms;








}
