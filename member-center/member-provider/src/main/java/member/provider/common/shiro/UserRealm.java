package member.provider.common.shiro;

import member.center.com.api.UserService;
import member.center.com.pojo.User;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.Set;

public class UserRealm extends AuthorizingRealm {



    @Autowired
    private UserService userService;



    //授权逻辑--  各类权限注解加上后会触发该方法
    //这里的principalCollection 就是认证模块存进去的信息 一般是 用户整个信息 或者是Jwt的Token
    //后续在项目了只需要通过SecurityUtils.getSubject().getPrincipal()即可获取到用户相关信息
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        System.out.println("------------------ 授权-------------------");
        Subject subject = SecurityUtils.getSubject();
            //subject.getPrincipal()获取的就是在认证是存入的第一个 参数
        Integer  userId = (Integer)subject.getPrincipal();

        //填加用户权限 --- 查询用户的角色 --》 角色所有的权限
        User user = userService.getById(userId);
        Set<String> permissions = new HashSet<>();
        permissions.add(user.getPerms());
        info.setStringPermissions(permissions); //如果注解上的资源权限标识在这个集合里则放行 否则拦截
        return info;
    }


    //subject.login()调用会进入该方法逻辑
    //认证逻辑--这里的AuthenticationToken 就是subject.login(xxx)里的xxx参数
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {

        System.out.println("======login==========");
        System.out.println("subject.login被调用后进入的方法=============================");

        //模拟数据库存的密码
        String  username = "allen";
        String  password = "123";

        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        if(!token.getUsername().equals(username)){
            //用户名不存在
            return  null;
        }

        //真实生产中返回JwtToken和用户密码 ---
        //String jwtToken = authService.accredit(username, password);
        //return new SimpleAuthenticationInfo(jwtToken,password,"");  //把jwtToken放入subject中
        //这里shiro会自动判断uthenticationToken里的密码和数据库存的密码是否一样
        //第一个参数存的是用户信息或者jwtToken-- 此步操作和把登录标识放入cookie中是一个意思
        return new SimpleAuthenticationInfo(1,password,"");

    }
}
