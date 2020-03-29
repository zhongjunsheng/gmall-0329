package member.provider.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import member.center.com.pojo.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper extends BaseMapper<User> {

   // @Select("select username from user where id = #{id}")
    String getUserNameById(Integer id);

    User getUserById(int id);

    List<User> findList();
}
