package member.provider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@MapperScan("member.provider.mapper")
public class MemberProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(MemberProviderApplication.class, args);
    }

}
