package member.provider.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import member.center.com.pojo.Mark;
import member.center.com.pojo.MarkVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface MarkMapper extends BaseMapper<Mark> {

    List<MarkVO>  getDistanceByLatAndLng(@Param("lng") String lng, @Param("lat") String lat);



}
