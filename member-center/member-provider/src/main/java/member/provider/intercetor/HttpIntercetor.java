package member.provider.intercetor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;


@Component
public class HttpIntercetor implements HandlerInterceptor{
    private final static org.slf4j.Logger Log = org.slf4j.LoggerFactory
            .getLogger(HttpIntercetor.class);

    public boolean preHandle(HttpServletRequest request,
	    HttpServletResponse response, Object handler) throws Exception {
	Log.info("preHandle...."); //进去url对应方法之前
	//RequestHolder.add((long) 200);
	return true;
    }

    public void postHandle(HttpServletRequest request,
	    HttpServletResponse response, Object handler,
	    ModelAndView modelAndView) throws Exception {
	
    }

    public void afterCompletion(HttpServletRequest request,
	    HttpServletResponse response, Object handler, Exception ex)
	    throws Exception {
	//RequestHolder.remove();
	Log.info("afterCompletion......remove");  ////出来url对应方法之后
	
    }

}
