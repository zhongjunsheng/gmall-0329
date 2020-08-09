package member.provider.biz.designpattern.impl;

import member.provider.biz.designpattern.StrategyService;
import org.springframework.stereotype.Service;

/**
 * 锦囊妙计二
 */
@Service("givenGreenLight")
public class GivenGreenLight implements StrategyService {
    @Override
    public String operate() {
        System.out.println("让乔国老放行");
        return "让乔国老放行" ;
    }
}
