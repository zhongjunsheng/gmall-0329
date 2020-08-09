package member.provider.common.intercetor;

import member.center.com.pojo.UserInfo;
import member.provider.common.annotation.NotAuth;
import member.provider.common.globalException.CommonEnum;
import member.provider.common.globalException.CustomException;
import member.provider.common.utils.CookieUtils;
import member.provider.common.utils.JwtUtils;
import member.provider.config.JwtProperties;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;


@Component
public class LoginInterceptor extends HandlerInterceptorAdapter {


    @Autowired
    private JwtProperties jwtProperties;


    private static final ThreadLocal<UserInfo> THREAD_LOCAL = new ThreadLocal<>(); //存储用户的登录信息

    /**
     * 统一获取登陆状态
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("进入登录拦截器##########################");
        if(checkIsNotAuth(handler)){
          return true;
        }

        // 获取cookie中的token信息（jwt）及userKey信息
        UserInfo userInfo = new UserInfo();
        String token = CookieUtils.getCookieValue(request, jwtProperties.getCookieName());
        if (StringUtils.isNotBlank(token)) {
            //解析token信息(私钥生产token,公钥解密Token)
            Map<String, Object> infoFromToken = JwtUtils.getInfoFromToken(token, jwtProperties.getPublicKey());
            userInfo.setId(new Long(infoFromToken.get("id").toString()));

            THREAD_LOCAL.set(userInfo);
        }

        return super.preHandle(request, response, handler);
    }

    //THREAD_LOCAL是本类私有 所以要提供一个方法给其他类调用
    public static UserInfo getUserInfo(){
        return THREAD_LOCAL.get();
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex){
        // 必须手动清除threadLocal中线程变量，因为使用的是tomcat线程池
        THREAD_LOCAL.remove();
    }


    /**
     * 放行不需要登录的请求
     * @param handler
     * @return
     */
    private boolean checkIsNotAuth(Object handler) {
        HandlerMethod handlerMethod = (HandlerMethod)handler;
        boolean flag = AnnotationUtils.findAnnotation(handlerMethod.getMethod(), NotAuth.class) != null
                || AnnotationUtils.findAnnotation(handlerMethod.getBeanType(), NotAuth.class) != null;

        return  flag;
    }

}

