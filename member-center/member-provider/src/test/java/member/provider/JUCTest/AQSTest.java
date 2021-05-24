package member.provider.JUCTest;

public class AQSTest {

    /**
     * AQS：抽象队列同步器
     *
     * 结构   state(信号灯) +  队列（双向列表队列CLH）
     * 队列里是一个个装有客户线程的Node节点
     *
     * 队列的第一个节点是个傀儡节点( 先new 出一个空的Node节点 在进入自旋代码) 之后才是真实的客户线程节点
     *
     *  节点之间有 pred和next指针相连    头指针指向第一个傀儡节点    尾指针指向最后一个节点
     */
}
