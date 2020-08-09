package member.provider.serviceimpl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import member.center.com.api.MemberService;
import member.center.com.pojo.Member;
import member.provider.mapper.MemberMapper;
import org.springframework.stereotype.Component;

@Component
public class MemberServiceImpl extends ServiceImpl<MemberMapper, Member> implements MemberService {

    @Override
    public String findMemberNameById(Integer id) {
        return "Allen";
    }
}
