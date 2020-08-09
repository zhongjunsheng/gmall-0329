package member.provider.common.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author Hello
 */
@Target({ElementType.TYPE,ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface Cache {
	/**
	 * z只有一个成员变量是 只能用value()
	 * @return
	 */
	String name() default "";
	String pwd() default "123456";
}
