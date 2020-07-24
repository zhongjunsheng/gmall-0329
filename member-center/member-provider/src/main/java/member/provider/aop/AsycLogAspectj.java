//package member.provider.aop;//package member.provider.aop;
//
//import org.aspectj.lang.ProceedingJoinPoint;
//import org.aspectj.lang.annotation.Around;
//import org.aspectj.lang.annotation.Aspect;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.context.event.EventListener;
//import org.springframework.stereotype.Component;
//@Aspect
//@Component
//public class AsycLogAspectj {
//    private static final Logger  log = LoggerFactory.getLogger(AsycLogAspectj.class);
//    @Around("@annotation(eventListener)")
//	public void log(ProceedingJoinPoint joint, EventListener eventListener) throws Throwable {
//        System.out.println("mothod  log done....目标方法执行前 先执行该方法before");
//		try {
//            joint.proceed();//执行拦截目标方法
//        } catch (Exception e) {
//		    log.error("异常信息:{}",e);
//        }
//        //执行拦截目标方法之后执行的操作
//		System.out.println("这是执行拦截目标方法之后执行的操作");
//	}
//
//}
