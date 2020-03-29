package member.provider.intercetor;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class WebConfiguration extends WebMvcConfigurerAdapter {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
    	//拦截/usr开头的所有请求 然后都走HttpIntercetor 这个类的逻辑
	registry.addInterceptor(new HttpIntercetor()).addPathPatterns("/usr/*");  //可以指定某条url
    }

}
