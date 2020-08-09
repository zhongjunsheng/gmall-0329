package member.center.com.api;

import com.baomidou.mybatisplus.extension.service.IService;
import member.center.com.Utils.PageBean;
import member.center.com.pojo.User;

import java.util.List;

public interface UserService extends IService<User> {

    String  accredit(String username,String password);

    String getUserNameById(Integer id);

    User getUserById(int i);

    List<User> findList();

    PageBean<List<User>> getUserList();

    User getUserByEntity(User user);

    int saveUser(User user);

    User queryUser(String username, String password);
}
