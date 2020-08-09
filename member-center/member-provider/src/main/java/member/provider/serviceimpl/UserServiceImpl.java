package member.provider.serviceimpl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import member.center.com.Utils.PageBean;
import member.center.com.api.UserService;
import member.center.com.pojo.User;
import member.provider.common.entity.Condition;
import member.provider.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImpl  extends ServiceImpl<UserMapper, User>  implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public String accredit(String username, String password) {
        return null;
    }

    @Override
    public String getUserNameById(Integer id){
        return userMapper.getUserNameById(id);
    }

    @Override
    public User getUserById(int i) {
        return userMapper.getUserById(i);
    }

    @Override
    public List<User> findList() {
        return userMapper.findList();
    }

    @Override
    public PageBean<List<User>> getUserList() {
        List<User> list = userMapper.findList();
        return new PageBean(list);
    }

    @Override
    public User getUserByEntity(User user) {
        QueryWrapper<User> userWrapper = new QueryWrapper<>();
        //UpdateWrapper<User> userWrapper2 = new UpdateWrapper<>();
        userWrapper.setEntity(user);
        User user1 = userMapper.selectOne(userWrapper);
        return user1;
    }

    @Override
    //@Transactional(propagation = Propagation.REQUIRES_NEW)
    @Transactional
    public int saveUser(User user) {
        user =  new User();
        user.setUsername("allen");
        user.setPwd("123456");
        int insert = userMapper.insert(user);
        return insert;
    }

    @Override
    public User queryUser(String username, String password) {
        Condition<User> condition = Condition.create();
        condition.eq("username",username).eq("pwd",password);
        return userMapper.selectOne(condition);
    }
}
