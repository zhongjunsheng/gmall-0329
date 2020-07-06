package member.provider;

import com.alibaba.nacos.spring.context.annotation.config.NacosPropertySource;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@NacosPropertySource(dataId = "example", autoRefreshed = true)
//@MapperScan("member.provider.mapper")
//@EnableAspectJAutoProxy(proxyTargetClass = true, exposeProxy = true)
public class MemberProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(MemberProviderApplication.class, args);
    }

}
