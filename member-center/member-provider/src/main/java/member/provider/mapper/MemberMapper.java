package member.provider.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import member.center.com.pojo.Member;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MemberMapper extends BaseMapper<Member> {
}
