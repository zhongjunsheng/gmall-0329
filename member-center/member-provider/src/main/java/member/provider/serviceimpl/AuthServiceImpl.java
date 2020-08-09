package member.provider.serviceimpl;

import member.center.com.api.AuthService;
import member.center.com.api.UserService;
import member.center.com.pojo.User;
import member.provider.common.utils.JwtUtils;
import member.provider.config.JwtProperties;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;


@Service
public class AuthServiceImpl  implements AuthService {

    @Autowired
    private JwtProperties jwtProperties;

    @Autowired
    private UserService userService;
    @Override
    public String accredit(String username, String password) {

        //用户名密码验证
        User user = userService.queryUser(username, password);

        if(ObjectUtils.isEmpty(user)){
            return null;
        }
        //登录校验通过制作jwt生产token返回
        try {
            // 制作jwt
            Map<String, Object> map = new HashMap<>();
            map.put("id", user.getId());
            map.put("username", user.getUsername());
            //生成token(需要私钥)返回
            return JwtUtils.generateToken(map, jwtProperties.getPrivateKey(), jwtProperties.getExpire());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
