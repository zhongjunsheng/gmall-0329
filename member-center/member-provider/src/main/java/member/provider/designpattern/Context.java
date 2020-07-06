package member.provider.designpattern;

/**
 * 具体环境类 --- 统一使用一个策略类 通过传入不同的的实现类来控制具体的执行逻辑
 */
public class Context {
    private StrategyService strategyService;

    public Context(StrategyService strategyService) {
        this.strategyService = strategyService;
    }

    public Context setStrategyService(StrategyService strategyService) {
        this.strategyService = strategyService;
        return this;
    }
    public  void operate(){
        this.strategyService.operate();
    }
}

