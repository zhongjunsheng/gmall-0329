package member.provider.serviceImpl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import member.center.com.Utils.PageBean;
import member.center.com.api.UserService;
import member.center.com.pojo.User;
import member.provider.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
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
}
