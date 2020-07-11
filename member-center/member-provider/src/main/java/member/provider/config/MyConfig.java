package member.provider.config;

import com.alibaba.nacos.api.config.annotation.NacosConfigurationProperties;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@ConfigurationProperties(prefix = "app")
//@NacosConfigurationProperties(dataId = "example", autoRefreshed = true)  //需要加上这个动态刷新配置bean
public class MyConfig {

    private String id;
    private String secret;
}
