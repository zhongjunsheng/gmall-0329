package member.provider.test;

import member.center.com.pojo.User;

public class ClassLoadTest {


    public static void main(String[] args) {


        Object  object =  new Object();
        System.out.println(object.getClass().getClassLoader());
        System.out.println();


        User user = new User();

        System.out.println(user.getClass().getClassLoader());
        System.out.println(user.getClass().getClassLoader().getParent());
        System.out.println(user.getClass().getClassLoader().getParent().getParent());
    }

}
