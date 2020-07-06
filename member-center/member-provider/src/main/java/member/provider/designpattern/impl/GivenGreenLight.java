package member.provider.designpattern.impl;

import member.provider.designpattern.StrategyService;

/**
 * 锦囊妙计二
 */
public class GivenGreenLight implements StrategyService {
    @Override
    public void operate() {
        System.out.println("让乔国老放行");
    }
}
