package member.provider;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import member.center.com.api.UserService;
import member.center.com.pojo.MarkVO;
import member.center.com.pojo.User;
import member.provider.mapper.MarkMapper;
import member.provider.mapper.UserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.omg.CORBA.PUBLIC_MEMBER;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MybatisplusTests {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private ApplicationContext applicationContext;

    @Autowired
    private MarkMapper markMapper;

    @Autowired
    private UserService userService;


    @Test
    public  void   dddd(){

        User user = new User();
        user.setId(1L);
        user.setUsername("allen");
        user.setPwd("999998");
        userService.saveOrUpdate(user);
    }
    @Test
    public  void  getDistance(){
        List<MarkVO> distanceByLatAndLng = markMapper.getDistanceByLatAndLng("113.871300", "23.248335");
        System.out.println(distanceByLatAndLng);
    }


    //查询单个数据
    @Test
    public void getUser(){
        QueryWrapper<User> userWrapper = new QueryWrapper<>();
        //UpdateWrapper<User> userWrapper2 = new UpdateWrapper<>();
        User user = new  User();
        user.setUsername("pp");
        user.setAddress("sz");
        userWrapper.setEntity(user);
        User user1 = userMapper.selectOne(userWrapper);
        System.out.printf(user1.toString());
    }

    //查询字段等于某值的用法 ---单条记录
    @Test
    public void getUser2(){
        QueryWrapper<User> userWrapper = new QueryWrapper<>();
        userWrapper.eq("username","pp");  //username=pp
        userWrapper.eq("address","sz");    //address=sz
        User user1 = userMapper.selectOne(userWrapper);
        System.out.printf(user1.toString());
    }

    //查询字段等于某值的用法 ---多条记录
    @Test
    public void getUserList(){
        QueryWrapper<User> userWrapper = new QueryWrapper<>();
        userWrapper.eq("username","allen");  //username=allen
        //userWrapper.eq("flag","1");    //flag =1
        List<User> users = userMapper.selectList(userWrapper);
        System.out.println(users);
    }
    @Test
    public void getCount(){
        QueryWrapper<User> userWrapper = new QueryWrapper<>();
        userWrapper.gt("flag",1);
        int a= userMapper.selectCount(userWrapper);
        System.out.println(a);
    }
    //添加数据
    @Test
    public void addUser(){
        User user = new  User();
        user.setUsername("pyh");
        user.setAddress("cd");
        user.setPwd("1234");
        user.setFlag("0");
        userMapper.insert(user);
        //自增加 id 会回填到user中
        System.out.println(user.getId());
    }
    //查询列表
    @Test
    public void selectList(){
        //1.NULL代表所有数据
        // List<User> users = userMapper.selectList(null);
        // users.forEach(System.out::println);
        //2.条件查询列表 --QueryWrappe 表示查询实体
        QueryWrapper<User> userWrapper = new QueryWrapper<>();
        //UpdateWrapper<User> userWrapper2 = new UpdateWrapper<>();
        User user = new  User();
        user.setUsername("allen");
        userWrapper.setEntity(user);
        List<User> users = userMapper.selectList(userWrapper);
        users.forEach(System.out::println);

    }

    //跟新数据BYID
    @Test
    public void updateUserBI(){
        User user = new  User();
        user.setId(5l);
        user.setUsername("allen");
        user.setAddress("suixi");
        user.setPwd("155");
        user.setFlag("0");
       userMapper.updateById(user); //传入实体中必须要有主键
    }

    //跟新数据--根据条件
    @Test
    public void update(){
        User user = new  User(); //要更新胡的// 字段
        user.setUsername("ccy-nm");
        user.setAddress("huizhou");

        QueryWrapper<User> userWrapper = new QueryWrapper<>(); //要跟新的条件
        userWrapper.eq("username","allen");  //条件是username=allen and parent_code =1
        userWrapper.eq("parent_code",1);
        userMapper.update(user,userWrapper);
    }

    //删除
    @Test
    public void delete() {
        userMapper.deleteById(5l);
    }

    //删除
    @Test
    public void delete2() {
        //2.条件查询列表 --QueryWrappe 表示查询实体
        QueryWrapper<User> userWrapper = new QueryWrapper<>();
        //UpdateWrapper<User> updateWrapper = new UpdateWrapper<>();
        User user = new  User();
        user.setUsername("allen");
        userWrapper.setEntity(user);
        userMapper.delete(userWrapper);

    }

}
