package member.provider.common.utils;

import cn.hutool.core.date.DateUtil;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Administrator
 * @date 2019/5/7
 * @since 1.0.0
 */
public class DateUtils extends DateUtil {

    private DateUtils() {}

    /**
     * 获取当前秒数
     *
     * @return 当前秒数
     */
    public static int currentSecond() {
        return (int)(System.currentTimeMillis() / 1000);
    }

    /**
     * 获取当前毫秒
     * 
     * @return
     */
    public static long currentTimeMillis() {
        return System.currentTimeMillis();
    }

    /**
     * 获取今天时间
     *
     * @param format
     *            格式化
     *
     * @return 时间
     */
    public static String date(String format) {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        return sdf.format(new Date());
    }


    /**
     * 毫秒转秒
     * 
     * @param timeMillis
     * @param defaut
     * @return
     */
    public static int timeMillis2Second(Long timeMillis, Integer defaut) {
        if (timeMillis == null) {
            return defaut;
        }
        Long sec = timeMillis / 1000;
        return sec.intValue();
    }

    /**
     * 秒转毫秒
     *
     * @param second
     *
     * @return
     */
    public static long second2Millisecond(int second) {
        long millisecond = second * 1000L;
        return millisecond;
    }



}