package member.provider.controller;

import com.github.pagehelper.PageHelper;
import member.center.com.Utils.PageBean;
import member.center.com.api.UserService;
import member.center.com.pojo.Member;
import member.center.com.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;
import java.util.stream.Collectors;

@RestController
public class UserController {

    @Autowired
    private UserService userService;



    @RequestMapping("/test")
    public  String test(){
       Member mb =  new Member(1,"allen",20);
        System.out.println(mb.getName());
        return  mb.getName();
    }


    @RequestMapping("/name")
    public String findUserName(){
        String name = userService.getUserNameById(1);
        return  name;
    }
    @RequestMapping("/user")
    public User findUser(){
        return  userService.getUserById(1);
    }

    @RequestMapping("/list")
    public ResponseEntity findList(){
        PageHelper.startPage(1, 10);
        PageBean<List<User>> pageBean = userService.getUserList();
        return  new ResponseEntity(pageBean, HttpStatus.OK) ;
    }
    @RequestMapping("/plus/test")
    public User findUserByEntity(User user){
        User user2 = userService.getUserByEntity(user);
        return user2;
    }

}
