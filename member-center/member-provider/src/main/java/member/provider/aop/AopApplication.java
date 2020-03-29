package member.provider.aop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;


/**
 * jdk动态代理   必须是接口
 * cglib动态代理  是类
 */
@SpringBootApplication
public class AopApplication {
	public static void main(String[] args) {
		ConfigurableApplicationContext ct= SpringApplication.run(AopApplication.class, args);
		UserDao bean = ct.getBean(UserDao.class);
		ct.getBean(UserDao.class).addUser("allen", "123456");
		ct.close();
	}

}
