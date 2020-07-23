//package member.provider.aop;
//
//import jodd.util.StringUtil;
//import member.provider.annotation.Cache;
//import org.aspectj.lang.JoinPoint;
//import org.aspectj.lang.ProceedingJoinPoint;
//import org.aspectj.lang.annotation.Around;
//import org.aspectj.lang.annotation.Aspect;
//import org.aspectj.lang.annotation.Before;
//import org.aspectj.lang.reflect.MethodSignature;
//import org.aspectj.lang.reflect.Pointcut;
//import org.springframework.core.LocalVariableTableParameterNameDiscoverer;
//import org.springframework.expression.ExpressionParser;
//import org.springframework.expression.spel.standard.SpelExpressionParser;
//import org.springframework.expression.spel.support.StandardEvaluationContext;
//import org.springframework.stereotype.Component;
//
//import java.lang.reflect.Method;
//
//@Aspect
//@Component
//public class CacheAspect {
//
//    /**
//     * 拦截目标方法，执行相关操作
//     *
//     * @throws Exception
//     */
//    //@Before("execution(* com.taotao.datachange.service..*(..))") //常用的表达式拦截
//    //@Before("@annotation(member.provider.annotation.Cache)")//这个表示拦截所有带有@Cache的注解,推荐使用这个
//    //@Around("@annotation(member.provider.annotation.Cache)")//这个表示拦截所有带有@Cache的注解,推荐使用这个
//    //@Before("@annotation(cache)")//这个表示拦截所有带有@Cache的注解,推荐使用这个
//    @Around("@annotation(cache)")//这个表示拦截所有带有@Cache的注解,推荐使用这个
//    public void intercept(JoinPoint joinPoint, Cache cache) throws Throwable {
//        System.out.println("进入切面=================");
//        //参数列表
//        Object[] args = joinPoint.getArgs();
//        MethodSignature ms = (MethodSignature) joinPoint.getSignature();
//        Method method = ms.getMethod();
//        //获取动态传过来的业务参数
//        String name = parseAnnotationKey(cache.name(), method, args);
//        String pwd = parseAnnotationKey(cache.pwd(), method, args);
//        System.out.println("name是:"+name);
//        System.out.println("pwd是："+pwd);
//        //Cache ch = method.getAnnotation(Cache.class);
//        //System.out.println("===========入参"+ch.name());//
//        //System.out.println(ch.pwd());//
//        //Class<?> target = point.getTarget().getClass(); //拦截方法所在的类
//        //Signature signature2 = point.getSignature(); //获取封装了署名信息的对象,在该对象中可以获取到目标方法名,所属类的Class等信息
//        //MethodSignature signature = (MethodSignature) point.getSignature(); //获取方法参数列表
//        //target.getInterfaces()
//        //signature.getMethod() 拿到拦截的具体方法
//        //默认使用目标类型的注解，如果没有则使用其实现接口的注解
//        //resolveTodo(target, signature.getMethod());
//        //point.proceed(); //执行目标方法
//        //执行拦截目标方法之后执行的操作
//        //System.out.println("这是执行拦截目标方法之后执行的操作");
//
//        System.out.println("切面跑完=================");
//        ProceedingJoinPoint point = (ProceedingJoinPoint) joinPoint;
//        //执行目标方法
//        point.proceed();
//    }
//
//    /**
//     * 提取目标对象方法注解和类型注解中的数据源标识
//     *
//     * @param clazz
//     * @param method
//     */
//    private void resolveTodo(Class<?> clazz, Method method) {
//        try {
//            Class<?>[] types = method.getParameterTypes(); //拿到方法参数
//            // 默认使用类型注解
//            //判断类上是否有注解
//            if (clazz.isAnnotationPresent(Cache.class)) {
//                System.out.println("目标方法前先执行这个操作");
//            }
//            //如果方法上也有注解 则以方法上的为准
//            // 方法上的注解覆盖类上的注解
//            Method m = clazz.getMethod(method.getName(), types); //通过方法参数拿到具体的类
//            //判断方法上是否有注解
//            if (m != null && m.isAnnotationPresent(Cache.class)) {
//                System.out.println("目标方法前先执行这个操作");
//            }
//
//        } catch (Exception e) {
//            System.out.println(clazz + ":" + e.getMessage());
//        }
//    }
//
//
//
//    /**
//     * 解析注解上的el表达式获取动态参数
//     * key 注解上的属性值，支持SPEL表达式
//     * @return
//     */
//    private String parseAnnotationKey(String key, Method method, Object [] args){
//        if(StringUtil.isEmpty(key)){
//            return null;
//        }
//        //获取被拦截方法参数名列表(使用Spring支持类库)
//        LocalVariableTableParameterNameDiscoverer u = new LocalVariableTableParameterNameDiscoverer();
//        String[] paraNameArr = u.getParameterNames(method);
//
//        //使用SPEL进行key的解析
//        ExpressionParser parser = new SpelExpressionParser();
//        //SPEL上下文
//        StandardEvaluationContext context = new StandardEvaluationContext();
//        //把方法参数放入SPEL上下文中
//        for(int i=0;i<paraNameArr.length;i++){
//            context.setVariable(paraNameArr[i], args[i]);
//        }
//        return parser.parseExpression(key).getValue(context,String.class);
//    }
//
//}
//
