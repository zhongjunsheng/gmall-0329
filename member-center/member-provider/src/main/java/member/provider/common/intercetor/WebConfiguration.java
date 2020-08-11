package member.provider.common.intercetor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfiguration implements WebMvcConfigurer {

    @Autowired
    private LoginInterceptor loginInterceptor;
    @Autowired
    private RequestLogInterceptor requestLogInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
    	//拦截/usr开头的所有请求 然后都走HttpIntercetor 这个类的逻辑 --  多个拦截器时 执行顺序由这里的添加顺序决定 先加先执行
	    //registry.addInterceptor(new HttpIntercetor()).addPathPatterns("/usr/*");  //可以指定某条url:以/user开头
        //registry.addInterceptor(loginInterceptor).addPathPatterns("/**").excludePathPatterns("/login/**","/loginOut/**");  //注意这里务必要使用注入进来的LoginInterceptor对象，不能New,否则会发现在拦截器里注入的对象全为空
	    //registry.addInterceptor(requestLogInterceptor).addPathPatterns("/**");  //全部拦截
    }

}
