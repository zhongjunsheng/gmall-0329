package member.provider.Java8Test;

import member.center.com.pojo.User;
import org.junit.Test;

import java.util.Optional;

public class OptionalTest {

    @Test
    public  void method1() {
        Optional<User> user = Optional.of(new User());
        User u = user.get();
        System.out.println(user.get());
    }

    @Test
    public  void method2() {
        Optional<User> user = Optional.of(null);  //直接报空指针
        User u = user.get();
        System.out.println(user.get());
    }
}
