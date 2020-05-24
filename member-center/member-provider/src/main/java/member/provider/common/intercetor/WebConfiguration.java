package member.provider.common.intercetor;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfiguration implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
    	//拦截/usr开头的所有请求 然后都走HttpIntercetor 这个类的逻辑
	    //registry.addInterceptor(new HttpIntercetor()).addPathPatterns("/usr/*");  //可以指定某条url:以/user开头
	    registry.addInterceptor(new  RequestLogInterceptor()).addPathPatterns("/**");  //全部拦截
    }

}
