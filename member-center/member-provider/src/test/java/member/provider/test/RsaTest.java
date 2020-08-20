package member.provider.test;

import member.provider.common.utils.RsaUtils;
import member.provider.config.JwtProperties;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RsaTest {

    @Autowired
    private JwtProperties jwtProperties;


    //Rsa公钥匙加密
    @Test
    public  void  jiami(){
        RSAPublicKey publicKey = (RSAPublicKey) jwtProperties.getPublicKey();
        String str = RsaUtils.publicEncrypt("123456", publicKey);
        System.out.println(str);

    }



    //Rsa私钥匙解密
    @Test
    public  void  jiemi(){

        RSAPrivateKey privateKey = (RSAPrivateKey) jwtProperties.getPrivateKey();
        String pwd = RsaUtils.privateDecrypt("ftIZaWXJEdDxZQysE86SlVzTFzCbelwgqz3Cr3liV59-IoDdg3lvtsGcdmox0WbvAL2w6M436Z5GHNVe-LK0ihqQ2kpFeezbezOdrlETsoOmR55doGAWI_u9glqPLJVoc60imHIVBpgCw7n5hdI41th_kogx7k2NONx_gWmiJbAEdcD2dxbSHTJFeDMMuhy3KDKjHw0iVaAJNEvc7ltNyNxGtW4nXnhsVzZsZV2z6dCC1fUeDB05bqgigWYRobKf8Kdldf7LdSF0zxeueCPeOTeF6i8WMoZSRuMH-Av3EliSzTI7sal_YsowuXcGGyE1Yt7cC0ff6U9oWYfC-uW5pg\n", privateKey);
        System.out.println(pwd);
    }


}
