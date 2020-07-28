package member.provider.test;


import member.provider.designpattern.ChannelEnum;
import member.provider.designpattern.StrategyService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StrategyTest {


    @Autowired
    private ApplicationContext applicationContext;


    @Test
    public void operate(){

         String channelCode = "BD";
        ChannelEnum channelEnum = null;
        ChannelEnum[] values = ChannelEnum.values();
        for (ChannelEnum value : values) {
            if(value.getCode().equals(channelCode)){
                channelEnum = value;
                break;
            }
        }

        StrategyService strategyService = (StrategyService)applicationContext.getBean(channelEnum.getName());


        String operate = strategyService.operate();
        System.out.println(operate);
    }
}
