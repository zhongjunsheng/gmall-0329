package member.provider.designpattern.impl;

import member.provider.designpattern.StrategyService;

/**
 * 锦囊妙计一
 */
public class BackDook implements StrategyService {
    @Override
    public void operate() {
        System.out.println("让赵云一行先去访问乔国老");
    }
}
