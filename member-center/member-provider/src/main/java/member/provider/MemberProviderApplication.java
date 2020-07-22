package member.provider;

import com.alibaba.nacos.spring.context.annotation.config.NacosPropertySource;
import member.provider.common.utils.ServletUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@NacosPropertySource(dataId = "example", autoRefreshed = true)
//@MapperScan("member.provider.mapper")
//@EnableAspectJAutoProxy(proxyTargetClass = true, exposeProxy = true)
public class MemberProviderApplication {

    private static final Logger log = LoggerFactory.getLogger(MemberProviderApplication.class);

    public static void main(String[] args) {

        SpringApplication.run(MemberProviderApplication.class, args);
        log.info(">>>>>>>> start  project  success1 !!!! <<<<<<<<<<<<");
        log.info(">>>>>>>> start  project  success2 !!!! <<<<<<<<<<<<");
        log.info(">>>>>>>> start  project  success3 !!!! <<<<<<<<<<<<");
        log.debug(">>>>>>>> start  project  success4 !!!! <<<<<<<<<<<<");
        log.debug(">>>>>>>> start  project  success5 !!!! <<<<<<<<<<<<");
        log.debug(">>>>>>>> start  project  success6 !!!! <<<<<<<<<<<<");
        log.debug(">>>>>>>> start  project  success7 !!!! <<<<<<<<<<<<");
    }

}
