package member.provider.config;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import member.provider.common.utils.RsaUtils;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import java.io.File;
import java.security.PrivateKey;
import java.security.PublicKey;

@Data
@Slf4j
@Configuration
@ConfigurationProperties(prefix = "gmall.jwt")
public class JwtProperties {

    private String secret; // 密钥--盐

    private String pubKeyPath;// 公钥

    private String priKeyPath;// 私钥--生产token使用

    private int expire;// token过期时间

    private String cookieName; // cookie名称

    private PublicKey publicKey; // 公钥

    private PrivateKey privateKey; // 私钥

    /**
     * * @PostConstruct：在构造方法执行之后执行该方法--保证对象初始化完成时  公钥私钥也初始化完成
     * 它的作用:被注解的方法，在对象加载完依赖注入后执行--即对象的所有属性依赖注入完后开始执行该注解下的方法
     * 实际是完成私钥公钥的初始化填充(配置文件里没得只能通过配置文件配置的地址去获取然后填充到该对象)
     */
    @PostConstruct
    public void init() {
        try {
            File pubKey = new File(pubKeyPath);
            File priKey = new File(priKeyPath);
            if (!pubKey.exists() || !priKey.exists()) {
                //不存在则加盐在指定目录下生成生成公钥和私钥
                RsaUtils.generateKey(pubKeyPath, priKeyPath, secret);
            }
            //获取公钥和私钥 并完成初始化赋值填充
            this.publicKey = RsaUtils.getPublicKey(pubKeyPath);
            this.privateKey = RsaUtils.getPrivateKey(priKeyPath);
        } catch (Exception e) {
            log.error("初始化公钥和私钥失败！", e);
            throw new RuntimeException();
        }
    }
}
