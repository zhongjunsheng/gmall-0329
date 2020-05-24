package member.provider.aop;//package member.provider.aop;
//
//import org.aspectj.lang.ProceedingJoinPoint;
//import org.aspectj.lang.annotation.Around;
//import org.aspectj.lang.annotation.Aspect;
//import org.aspectj.lang.reflect.MethodSignature;
//import org.springframework.stereotype.Component;
//
//import javax.servlet.http.HttpServletRequest;
//import java.lang.reflect.Method;
//
////定义切面
////@Aspect
////@Component
//public class LogAspectj {
//	//aop包及其子包下所有类的所有方法
//	//@Before("execution(* cn.itcast.springboot.aop..*.*(..))")
//	@Around("execution(* member.provider.aop..*.*(..))")
//	public void log(ProceedingJoinPoint joint, HttpServletRequest request) throws Throwable{
//		System.out.println("mothod  log done....目标方法执行前 先执行该方法before");
//		//获取拦截方法的参数集合
//		Object[] args = joint.getArgs();
//		String url = request.getRequestURL().toString();
//		System.out.println("请求url是："+url);
//		//获取签名对象
//		MethodSignature method = (MethodSignature) joint.getSignature();
//		//获取拦截的方法名
//		Method method2 = method.getMethod();
//		joint.proceed(joint.getArgs());//执行拦截目标方法,带着参数执行
//
//		//执行拦截目标方法之后执行的操作
//		System.out.println("这是执行拦截目标方法之后执行的操作");
//	}
//
//}
