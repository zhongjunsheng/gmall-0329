package member.provider.controller;


import member.provider.common.globalException.CustomException;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ShiroController {


    @RequestMapping("add")
    @RequiresPermissions(value = "user:add")    //权限操作是在登录的基础上
    public String add(){
        //获取用户信息
        Integer userId = (Integer) SecurityUtils.getSubject().getPrincipal();
        return  "gg" ;
    }


    @RequestMapping("update")
    @RequiresAuthentication   //标识该接口需要登录认证才可以访问
    public String   update(){
        return  "update";
    }


    @RequestMapping("toLogin")
    public String   toLogin() {
        return "toLogin";
    }


    @RequestMapping("shiro/login")
    public String login(String username,String password){


        //shiro认证
        Subject subject = SecurityUtils.getSubject();
        subject.logout();

        //token 封装  --- 注意生产时需MD5(password+salt)后放入UsernamePasswordToken里
        UsernamePasswordToken token = new UsernamePasswordToken(username,password);
        //开始认证
        try {
            subject.login(token);
        }catch (Exception e){

            throw new CustomException("用户名或者密码错误!");
        }
        return "login";
    }
}
