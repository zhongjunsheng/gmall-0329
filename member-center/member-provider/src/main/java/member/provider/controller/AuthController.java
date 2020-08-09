package member.provider.controller;

import lombok.extern.slf4j.Slf4j;
import member.center.com.api.AuthService;
import member.provider.common.annotation.NotAuth;
import member.provider.common.globalException.CustomException;
import member.provider.common.globalException.ResultBody;
import member.provider.common.utils.CookieUtils;
import member.provider.config.JwtProperties;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@Slf4j
public class AuthController {

    @Autowired
    private AuthService authService;

    @Autowired
    private JwtProperties jwtProperties;

    /**
     * sso登录认证（登录接口）
     * @param username
     * @param password
     * @param request
     * @param response
     * @return
     */
    @RequestMapping("login")
    public ResultBody<Object> accredit(@RequestParam("username")String username, @RequestParam("password")String password
            , HttpServletRequest request, HttpServletResponse response){

        //token为空说明登录校验出错--否则就是登录成功并返回jwt生成的token
        String token = authService.accredit(username, password);
        log.info("token:{}",token);
        if (StringUtils.isNotBlank(token)) {
            // 把jwt生产的token放入cookie中--token里解析后就是用户信息
            CookieUtils.setCookie(request, response, jwtProperties.getCookieName(), token, jwtProperties.getExpire() * 60);
            return ResultBody.success();
        }

        throw new CustomException("用户名或者密码错误!");
    }

    @RequestMapping("authLogin")
    public String  tt(){
        return "login";
    }
}
