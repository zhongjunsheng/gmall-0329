package member.provider.common.utils;

import cn.hutool.core.lang.Assert;
import cn.hutool.core.util.ArrayUtil;
import java.math.BigDecimal;
import java.math.RoundingMode;


public class NumberUtils {
    private NumberUtils() {}

    /**
     * 将对象转为Long类型 默认值为0
     *
     * @param obj
     *            需要转换的对象
     *
     * @return 类型
     */
    public static long toLong(Object obj) {
        return toLong(obj, 0L);
    }

    /**
     * 将对象转为Long类型 默认值为0
     *
     * @param obj
     *            需要转换的对象
     * @param defaultValue
     *            默认值
     *
     * @return 类型
     */
    public static long toLong(Object obj, long defaultValue) {
        if (obj == null) {
            return defaultValue;
        }
        try {
            return Long.parseLong(obj.toString());
        } catch (final NumberFormatException nfe) {
            return defaultValue;
        }
    }

    /**
     * 将对象转为Double类型 默认值为0.0
     *
     * @param obj
     *            需要转换的对象
     *
     * @return 类型
     */
    public static double toDouble(Object obj) {
        return toDouble(obj, 0D);
    }

    /**
     * 将对象转为Double类型 默认值为0.0
     *
     * @param obj
     *            需要转换的对象
     * @param defaultValue
     *            默认值
     *
     * @return 类型
     */
    public static double toDouble(Object obj, double defaultValue) {
        if (obj == null) {
            return defaultValue;
        }
        try {
            return Double.parseDouble(obj.toString());
        } catch (final NumberFormatException nfe) {
            return defaultValue;
        }
    }

    /**
     * 将对象转为Float类型 默认值为0.0
     *
     * @param obj
     *            需要转换的对象
     *
     * @return 类型
     */
    public static float toFloat(Object obj) {
        return toFloat(obj, 0F);
    }

    /**
     * 将对象转为Float类型 默认值为0.0
     *
     * @param obj
     *            需要转换的对象
     * @param defaultValue
     *            默认值
     *
     * @return 类型
     */
    public static float toFloat(Object obj, float defaultValue) {
        if (obj == null) {
            return defaultValue;
        }
        try {
            return Float.parseFloat(obj.toString());
        } catch (final NumberFormatException nfe) {
            return defaultValue;
        }
    }

    /**
     * 将对象转为int类型 默认值为0
     *
     * @param obj
     *            需要转换的对象
     *
     * @return 类型
     */
    public static int toInt(Object obj) {
        return toInt(obj, 0);
    }

    /**
     * 将对象转为int类型 默认值为0
     *
     * @param obj
     *            需要转换的对象
     * @param defaultValue
     *            默认值
     *
     * @return 类型
     */
    public static int toInt(Object obj, int defaultValue) {
        if (obj == null) {
            return defaultValue;
        }
        try {
            return Integer.parseInt(obj.toString());
        } catch (final NumberFormatException nfe) {
            return defaultValue;
        }

    }

    /**
     * 将对象转为Byte类型 默认值为0
     *
     * @param obj
     *            需要转换的对象
     *
     * @return 类型
     */
    public static byte toByte(Object obj) {
        return toByte(obj, (byte)0);
    }

    /**
     * 将对象转为Byte类型 默认值为0
     *
     * @param obj
     *            需要转换的对象
     * @param defaultValue
     *            默认值
     *
     * @return 类型
     */
    public static byte toByte(Object obj, byte defaultValue) {
        if (obj == null) {
            return defaultValue;
        }
        try {
            return Byte.parseByte(obj.toString());
        } catch (final NumberFormatException nfe) {
            return defaultValue;
        }
    }

    /**
     * 将对象转为Short类型 默认值为0
     *
     * @param obj
     *            需要转换的对象
     *
     * @return 类型
     */
    public static short toShort(Object obj) {
        return toShort(obj, (short)0);
    }

    /**
     * 将对象转为Short类型 默认值为0
     *
     * @param obj
     *            需要转换的对象
     * @param defaultValue
     *            默认值
     *
     * @return 类型
     */
    public static short toShort(Object obj, short defaultValue) {
        if (obj == null) {
            return defaultValue;
        }
        try {
            return Short.parseShort(obj.toString());
        } catch (final NumberFormatException nfe) {
            return defaultValue;
        }
    }

    /**
     * 提供(相对)精确的除法运算,当发生除不尽的情况时,由scale指定精确度
     *
     * @param v1
     *            被除数
     * @param v2
     *            除数
     * @param scale
     *            精确度，如果为负值，取绝对值
     * @param roundingMode
     *            保留小数的模式 {@link RoundingMode}
     *
     * @return 两个参数的商
     */
    public static BigDecimal div(BigDecimal v1, BigDecimal v2, int scale, RoundingMode roundingMode) {
        Assert.notNull(v2, "Divisor must be not null !");
        if (null == v1) {
            return BigDecimal.ZERO;
        }
        if (scale < 0) {
            scale = -scale;
        }
        return v1.divide(v2, scale, roundingMode);
    }

    /**
     * 提供(相对)精确的除法运算,当发生除不尽的情况时,由scale指定精确度
     *
     * @param v1
     *            被除数
     * @param v2
     *            除数
     * @param scale
     *            精确度，如果为负值，取绝对值
     * @param roundingMode
     *            保留小数的模式 {@link RoundingMode}
     *
     * @return 两个参数的商
     */
    public static BigDecimal div(Number v1, Number v2, int scale, RoundingMode roundingMode) {
        Assert.notNull(v2, "Divisor must be not null !");
        if (null == v1) {
            return BigDecimal.ZERO;
        }
        if (scale < 0) {
            scale = -scale;
        }
        return new BigDecimal(v1 + "").divide(new BigDecimal(v2 + ""), scale, roundingMode);
    }

    /**
     * 提供精确的乘法运算<br>
     * 如果传入多个值为null或者空，则返回0
     *
     * @param values
     *            多个被乘值
     *
     * @return 积
     */
    public static BigDecimal mul(BigDecimal... values) {
        if (ArrayUtil.isEmpty(values)) {
            return BigDecimal.ZERO;
        }

        BigDecimal value = values[0];
        BigDecimal result = null == value ? BigDecimal.ZERO : value;
        for (int i = 1; i < values.length; i++) {
            value = values[i];
            if (null != value) {
                result = result.multiply(value);
            }
        }
        return result;
    }

    /**
     * 判断数字-是否在范围之中
     *
     * @param data
     *            数据
     * @param min
     *            最小值
     * @param max
     *            最大值
     *
     * @return 是否存在
     */
    public static boolean in(long data, long min, long max) {
        return min <= data && max >= data;
    }

    /**
     * 判断是否大于 ( one > two)
     *
     * @param one
     *            ONE
     * @param two
     *            TWO
     * @param <T>
     *            泛型
     *
     * @return 结果
     */
    public static <T> boolean isGt(Comparable<T> one, T two) {
        if (one == null) {
            return false;
        }
        return one.compareTo(two) > 0;
    }

    /**
     * 判断是否大于等于 ( one >= two)
     *
     * @param one
     *            ONE
     * @param two
     *            TWO
     * @param <T>
     *            泛型
     *
     * @return 结果
     */
    public static <T> boolean isGe(Comparable<T> one, T two) {
        if (one == null) {
            return two == null;
        }
        return one.compareTo(two) >= 0;
    }

    /**
     * 判断是否小于 ( one < two)
     *
     * @param one
     *            ONE
     * @param two
     *            TWO
     * @param <T>
     *            泛型
     *
     * @return 结果
     */
    public static <T> boolean isLt(Comparable<T> one, T two) {
        if (one == null) {
            return false;
        }
        return one.compareTo(two) < 0;
    }

    /**
     * 判断是否小于等于 ( one <= two)
     *
     * @param one
     *            ONE
     * @param two
     *            TWO
     * @param <T>
     *            泛型
     *
     * @return 结果
     */
    public static <T> boolean isLe(Comparable<T> one, T two) {
        if (one == null) {
            return two == null;
        }
        return one.compareTo(two) <= 0;
    }

    /**
     * 判断是否等于 ( one == two)
     *
     * @param one
     *            ONE
     * @param two
     *            TWO
     * @param <T>
     *            泛型
     *
     * @return 结果
     */
    public static <T> boolean isEq(Comparable<T> one, T two) {
        if (one == null) {
            return two == null;
        }
        return one.compareTo(two) == 0;
    }

    /**
     * 判断是否不等于 ( one <> two)
     *
     * @param one
     *            ONE
     * @param two
     *            TWO
     * @param <T>
     *            泛型
     *
     * @return 结果
     */
    public static <T> boolean isNe(Comparable<T> one, T two) {
        return !isEq(one, two);
    }

    /**
     * 数字转汉字
     *
     * @param src
     *
     * @return
     */
    public static String int2chineseNum(int src) {
        final String[] num = {"零", "一", "二", "三", "四", "五", "六", "七", "八", "九"};
        final String[] unit = {"", "十", "百", "千", "万", "十", "百", "千", "亿", "十", "百", "千"};
        String dst = "";
        int count = 0;
        while (src > 0) {
            dst = (num[src % 10] + unit[count]) + dst;
            src = src / 10;
            count++;
        }
        return dst.replaceAll("零[千百十]", "零").replaceAll("零+万", "万").replaceAll("零+亿", "亿").replaceAll("亿万", "亿零")
            .replaceAll("零+", "零").replaceAll("零$", "");
    }

    public static void main(String[] args) {
        System.out.println(int2chineseNum(1));
    }

}