package member.provider.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.context.request.ServletWebRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

//定义切面
@Aspect
@Component
public class LogControllerAspect {
	//aop包及其子包下所有类的所有方法
	//@Before("execution(* cn.itcast.springboot.aop..*.*(..))")
	//@Around("execution(* member.provider.aop..*.*(..))")
	@Around("execution(* member.provider.aop.TestUserController..*(..))")
	public String log(ProceedingJoinPoint joint) throws Throwable{
		System.out.println("mothod  log done....目标方法执行前 先执行该方法before");
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
		HttpServletResponse response3= ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getResponse();
		HttpServletResponse response4 = ((ServletWebRequest)RequestContextHolder.getRequestAttributes()).getResponse();
		//url
		String url = request.getRequestURL().toString();
		System.out.println("请求url是："+url);
		String name = request.getParameter("name");
		String pwd = request.getParameter("pwd");
		String requestedSessionId = request.getRequestedSessionId();

		Object[] args = joint.getArgs();
		//获取签名对象
		MethodSignature method = (MethodSignature) joint.getSignature();
		//获取拦截的方法名
		Method method2 = method.getMethod();

		Object proceed = joint.proceed(joint.getArgs());//执行拦截目标方法,带着参数执行
		joint.proceed();
        //执行拦截目标方法之后执行的操作
		System.out.println("这是执行拦截目标方法之后执行的操作");
		return proceed.toString();
	}

}
