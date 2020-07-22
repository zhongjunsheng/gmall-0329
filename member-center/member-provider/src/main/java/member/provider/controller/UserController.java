package member.provider.controller;

import com.github.pagehelper.PageHelper;
import jodd.util.StringUtil;
import member.center.com.Utils.PageBean;
import member.center.com.api.UserService;
import member.center.com.pojo.Member;
import member.center.com.pojo.User;
import member.provider.common.globalException.CommonEnum;
import member.provider.common.globalException.CustomException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;




    @RequestMapping("myTest")
    public String myTest(String name){

        int a = 1/0;
        if(StringUtil.isEmpty(name)){
            throw new CustomException("参数不能为空!");
        }
        return name;
    }


    @RequestMapping("myTest2")
    public String myTest2(String name){

        if(StringUtil.isEmpty(name)){
            throw new CustomException("1001","!");
        }
        return name;
    }

    @RequestMapping("myTest3")
    public String myTest3(String name){

        if(StringUtil.isEmpty(name)){
            throw new CustomException(CommonEnum.BAD_PARM);
        }
        return name;
    }

    @RequestMapping("myTest4")
    public String myTest4(String name){

        name.toString();
        return name;
    }

    @RequestMapping("myTest5")
    public String myTest5(){

        int a = 1/0;
        return "gg";
    }




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
