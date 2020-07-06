package member.center.com.api;

import member.center.com.Utils.PageBean;
import member.center.com.pojo.User;

import java.util.List;

public interface UserService {

    String getUserNameById(Integer id);

    User getUserById(int i);

    List<User> findList();

    PageBean<List<User>> getUserList();

    User getUserByEntity(User user);

    int save(User user);
}
