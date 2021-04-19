package member.provider.test;


import member.provider.biz.designpattern.StrategyContext;
import member.provider.biz.designpattern.StrategyService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StrategyTest {


    /**
     * 通过上下文对象获取实例
     */
    @Autowired
    private StrategyContext strategyContext;

    @Resource(name = "backDook")
    private  StrategyService strategyService;

    @Test
    public void operate(){
        String channelCode = "BD";
        StrategyService strategyService = strategyContext.getTargetService(channelCode);
        String operate = strategyService.operate();
        System.out.println(operate);
    }


    /**
     * 通过注入名称获取对应对象
     */
    @Test
    public void  test(){
        System.out.println(strategyService.operate());
    }
}
