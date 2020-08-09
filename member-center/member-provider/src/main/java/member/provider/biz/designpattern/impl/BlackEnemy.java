package member.provider.biz.designpattern.impl;

import member.provider.biz.designpattern.StrategyService;
import org.springframework.stereotype.Service;

/**
 * 锦囊妙计三
 */
@Service("blackEnemy")
public class BlackEnemy implements StrategyService {
    @Override
    public String operate() {

        System.out.println("让孙夫人挡追兵");
        return "孙夫人挡追兵";
    }
}
