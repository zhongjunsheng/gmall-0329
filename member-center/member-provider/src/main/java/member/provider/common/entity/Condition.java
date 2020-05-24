package member.provider.common.entity;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;

/**
 * mybatis-plus统一查询实体
 * @param <T>
 */
public class Condition<T> extends QueryWrapper<T> {

    /**
     * 创建一个查询条件器
     *
     * @param <T>
     *            泛型
     *
     * @return 查询条件器
     */
    public static <T> Condition<T> create() {
        return new Condition<>();
    }

    public Condition() {}

    public Condition(T entity) {

        super(entity);
    }

    public Condition(T entity, String... columns) {

        super(entity, columns);
    }
}
