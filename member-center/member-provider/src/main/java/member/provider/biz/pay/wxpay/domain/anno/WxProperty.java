package member.provider.biz.pay.wxpay.domain.anno;

import java.lang.annotation.*;

/**
 * 微信属性
 *
 * @author Administrator
 * @date 2019/9/9
 * @since 1.0.0
 */
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface WxProperty {
    /**
     * 属性名
     *
     * @return
     */
    String value() default "";

}