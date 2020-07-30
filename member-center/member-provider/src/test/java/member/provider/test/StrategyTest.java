package member.provider.test;


import member.provider.designpattern.StrategyContext;
import member.provider.designpattern.StrategyService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StrategyTest {


    @Autowired
    private StrategyContext strategyContext;

    @Test
    public void operate(){
        String channelCode = "BD";
        StrategyService strategyService = strategyContext.getTargetService(channelCode);
        String operate = strategyService.operate();
        System.out.println(operate);
    }
}
