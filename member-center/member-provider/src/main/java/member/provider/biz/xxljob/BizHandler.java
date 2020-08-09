//package member.provider.biz.xxljob;
//
//import com.xxl.job.core.biz.model.ReturnT;
//import com.xxl.job.core.handler.annotation.XxlJob;
//import com.xxl.job.core.log.XxlJobLogger;
//import com.xxl.job.core.util.ShardingUtil;
//import org.springframework.stereotype.Component;
//
//
//@Component
//public class BizHandler {
//
//    @XxlJob("testHandler")
//    public ReturnT<String> execute(String param) {
//        //必须用 XxlJobLogger.log才能在后台记录调度日志
//        XxlJobLogger.log("XXL-JOB, Hello World");
//        System.out.println("执行了TestHandler一次..." + param );
//        return ReturnT.SUCCESS;
//    }
//
//
//    /**
//     * 2、分片广播任务
//     */
//    @XxlJob("shardingJobHandler")
//    public ReturnT<String> shardingJobHandler(String param) throws Exception {
//
//        ShardingUtil.ShardingVO shardingVo = ShardingUtil.getShardingVo();
//
//
//        // 分片参数
////        int shardIndex = XxlJobContext.getXxlJobContext().getShardIndex();
////        int shardTotal = XxlJobContext.getXxlJobContext().getShardTotal();
//
//
//
//        Integer size = Integer.parseInt(param);
//        Integer startindex = size * shardingVo.getIndex();
//        Integer endIndex = size * (shardingVo.getIndex() +1);
//
//        XxlJobLogger.log("分片参数：当前分片序号 = {}, 总分片数 = {}",
//                shardingVo.getIndex(), shardingVo.getIndex());
//
//        System.out.println("开始坐标:");
//
//
////        // 业务逻辑
////        for (int i = 0; i < shardTotal; i++) {
////            if (i == shardIndex) {
////                XxlJobLogger.log("第 {} 片, 命中分片开始处理", i);
////            } else {
////                XxlJobLogger.log("第 {} 片, 忽略", i);
////            }
////        }
//
//        return ReturnT.SUCCESS;
//    }
//
//}