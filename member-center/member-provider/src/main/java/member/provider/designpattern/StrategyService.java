package member.provider.designpattern;

/**
 * 策略模式抽象接口  -- 一个接口多个实现类(优雅实现不同环境条件下的策略选择)
 * 此例子模拟诸葛亮的3个锦囊妙计
 */
public interface StrategyService {

    String operate();
}
