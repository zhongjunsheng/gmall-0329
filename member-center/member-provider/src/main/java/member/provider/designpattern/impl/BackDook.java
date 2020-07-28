package member.provider.designpattern.impl;

import member.provider.designpattern.StrategyService;
import org.springframework.stereotype.Service;

/**
 * 锦囊妙计一
 */
@Service("backDook")
public class BackDook implements StrategyService {
    @Override
    public String operate() {
        System.out.println("让赵云一行先去访问乔国老");
        return "让赵云一行先去访问乔国老";
    }
}
