//package member.provider.middleware.redis;
//
//import org.springframework.context.annotation.Import;
//
//import java.lang.annotation.*;
//
///**
// *
// * @author user
// * 自定义strater 3步骤
// * 1.写一个XXXAutoConfig的类在上面配好所需要的属性
// * 2.创建一个注解类Enablexxx注解类  上面必须有
// * @Target(ElementType.TYPE)
// *  @Retention(RetentionPolicy.RUNTIME)
// *  @Documented
// *  最后一个就是 @Import(XXXAutoConfig.class) 导入这个类
// *
// *  3.最后在启动入口类配合@Enablexxx 这个自定义注解使用 注入容器
// *
// */
//
//@Target(ElementType.TYPE)
//@Retention(RetentionPolicy.RUNTIME)
//@Documented
//@Import(RedisAutoConfig.class)
//public @interface EnableRedis {
//
//}
