package member.provider.test;

import member.center.com.pojo.User;
import org.apache.commons.beanutils.BeanUtils;

public class CopyTest {


    public static void main(String[] args) throws  Exception {

        User user = new User();

        user.setPwd("123");

        User user2 = new User();

        user2.setUsername("Allen");

        BeanUtils.copyProperties(user,user2);


        System.out.println(user);
    }
}
