package member.provider.common.intercetor;

import member.provider.common.fiter.InitFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.servlet.Filter;
import java.util.Collections;

/**
 * @author zhongjs
 */
@Configuration
public class WebConfiguration implements WebMvcConfigurer {

    @Autowired
    private LoginInterceptor loginInterceptor;
    @Autowired
    private RequestLogInterceptor requestLogInterceptor;


    @Bean
    public FilterRegistrationBean<Filter> getFilter() {
        FilterRegistrationBean<Filter> registrationBean = new FilterRegistrationBean<>();
        registrationBean.setOrder(1);
        registrationBean.setFilter(new InitFilter());
        registrationBean.setUrlPatterns(Collections.singleton("*"));
        return registrationBean;
    }


    @Override
    public void addInterceptors(InterceptorRegistry registry) {
    	//拦截/usr开头的所有请求 然后都走HttpIntercetor 这个类的逻辑 --  多个拦截器时 执行顺序由这里的添加顺序决定 先加先执行
	    //registry.addInterceptor(new HttpIntercetor()).addPathPatterns("/usr/*");  //可以指定某条url:以/user开头
        registry.addInterceptor(loginInterceptor).addPathPatterns("/**").excludePathPatterns("/login/**","/loginOut/**");  //注意这里务必要使用注入进来的LoginInterceptor对象，不能New,否则会发现在拦截器里注入的对象全为空
	    registry.addInterceptor(requestLogInterceptor).addPathPatterns("/**");  //全部拦截
    }

}
