package member.provider.designpattern.impl;

import member.provider.designpattern.StrategyService;

/**
 * 锦囊妙计三
 */
public class BlackEnemy implements StrategyService {
    @Override
    public void operate() {
        System.out.println("让孙夫人挡追兵");
    }
}
