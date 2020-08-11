package member.provider;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import java.util.Date;

@SpringBootApplication
//@NacosPropertySource(dataId = "example", autoRefreshed = true) //自动配置生效注解 --- 针对springboot集成nacos
//@MapperScan("member.provider.mapper")
//@EnableAspectJAutoProxy(proxyTargetClass = true, exposeProxy = true)
@ServletComponentScan  //过滤器生效需要加上该注解
public class MemberProviderApplication {

    private static final Logger log = LoggerFactory.getLogger(MemberProviderApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(MemberProviderApplication.class, args);
    }
}
