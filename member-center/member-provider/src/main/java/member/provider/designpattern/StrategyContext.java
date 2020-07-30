package member.provider.designpattern;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

@Service
public class StrategyContext {


    @Autowired
    private ApplicationContext applicationContext;
    @Autowired
    private StrategyContext strategyContext;


    public StrategyService  getTargetService(String channelCode){
        ChannelEnum channelEnum = null;
        ChannelEnum[] values = ChannelEnum.values();
        for (ChannelEnum value : values) {
            if(value.getCode().equals(channelCode)){
                channelEnum = value;
                break;
            }
        }
        StrategyService strategyService = (StrategyService)applicationContext.getBean(channelEnum.getName());
        return  strategyService;
    }
}
