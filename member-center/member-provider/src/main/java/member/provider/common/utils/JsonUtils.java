package member.provider.common.utils;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalTimeSerializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Collection;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;

/**
 * Jackson 对Json 处理的工具类

 */
public class JsonUtils {
    private JsonUtils() {}

    private static final Logger log = LoggerFactory.getLogger(JsonUtils.class);
    private static final ObjectMapper OBJECT_MAPPER;
    private static final Locale CHINA = Locale.CHINA;
    private static final String JSON_ARRAY_START = "[";
    private static final String JSON_ARRAY_END = "]";

    static {
        OBJECT_MAPPER = new ObjectMapper();
        OBJECT_MAPPER.setLocale(CHINA);
        // 去掉默认的时间戳格式
        OBJECT_MAPPER.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
        // 设置为中国上海时区
        OBJECT_MAPPER.setTimeZone(TimeZone.getTimeZone("GMT+8"));
        // 空值不序列化
        OBJECT_MAPPER.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        // 反序列化时，属性不存在的兼容处理
        OBJECT_MAPPER.getDeserializationConfig().withoutFeatures(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        // 序列化时，日期的统一格式
        OBJECT_MAPPER.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
        OBJECT_MAPPER.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
        OBJECT_MAPPER.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        // 单引号处理
        OBJECT_MAPPER.configure(JsonParser.Feature.ALLOW_SINGLE_QUOTES, true);
        OBJECT_MAPPER.configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);
        OBJECT_MAPPER.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
        OBJECT_MAPPER.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        // LocalDate LocalTime LocalDateTime 的处理
        JavaTimeModule javaTimeModule = new JavaTimeModule();
        javaTimeModule.addSerializer(LocalDateTime.class,
            new LocalDateTimeSerializer(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        javaTimeModule.addSerializer(LocalDate.class,
            new LocalDateSerializer(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
        javaTimeModule.addSerializer(LocalTime.class, new LocalTimeSerializer(DateTimeFormatter.ofPattern("HH:mm:ss")));
        OBJECT_MAPPER.registerModule(javaTimeModule);

    }

    /**
     * 将JSON字符串转换为集合
     *
     * @param collectionClass
     *            集合-Class
     * @param elementClass
     *            元素-Class
     * @param jsonStr
     *            Json-字符串
     * @param <T>
     *            集合-泛型
     *
     * @return 集合-结果
     */
    public static <T extends Collection> T toCollections(Class<? extends Collection> collectionClass,
        Class<?> elementClass, String jsonStr) {
        if (jsonStr.startsWith(JSON_ARRAY_START) && jsonStr.endsWith(JSON_ARRAY_END)) {
            JavaType javaType = OBJECT_MAPPER.getTypeFactory().constructCollectionType(collectionClass, elementClass);
            try {
                return OBJECT_MAPPER.readValue(jsonStr, javaType);
            } catch (Exception e) {
                log.error("Json转换为集合时,发生异常", e);
            }
        }
        return null;
    }

    /**
     * 将Json字符串转换为集合
     *
     * @param elementClass
     *            元素Class
     * @param jsonStr
     *            Json字符串
     * @param <T>
     *            元素
     *
     * @return 数组-结果
     */
    public static <T> T toArray(Class<?> elementClass, String jsonStr) {
        JavaType javaType = OBJECT_MAPPER.getTypeFactory().constructArrayType(elementClass);
        try {
            return OBJECT_MAPPER.readValue(jsonStr, javaType);
        } catch (IOException e) {
            log.error("Json转换为数组时,发生异常", e);
        }
        return null;
    }

    /**
     * 将JSON转换为Map
     *
     * @param mapClass
     *            Map-Class
     * @param keyClass
     *            Key-Class
     * @param valueClass
     *            Value-Class
     * @param jsonStr
     *            Json 字符串
     * @param <T>
     *            结果泛型
     *
     * @return Map-结果
     */
    public static <T extends Map<?, ?>> T toMap(Class<? extends Map> mapClass, Class<?> keyClass, Class<?> valueClass,
        String jsonStr) {
        JavaType javaType = OBJECT_MAPPER.getTypeFactory().constructMapType(mapClass, keyClass, valueClass);
        try {
            return OBJECT_MAPPER.readValue(jsonStr, javaType);
        } catch (IOException e) {
            log.error("Json转换Map时,发生异常", e);
        }
        return null;
    }

    /**
     * 将JSON转换为对象
     *
     * @param clazz
     *            类型Class
     * @param jsonStr
     *            Json-字符串
     */
    public static <T> T toPo(Class<? extends T> clazz, String jsonStr) {
        try {
            return OBJECT_MAPPER.readValue(jsonStr, clazz);
        } catch (Exception e) {
            log.error("Json转换PO时,发生异常", e);
        }
        return null;
    }

    /**
     * 将对象转为JSON
     *
     * @param obj
     *            对象
     *
     * @return Json-字符串
     */
    public static String toJsonStr(Object obj) {
        try {
            return OBJECT_MAPPER.writer().writeValueAsString(obj);
        } catch (Exception e) {
            log.error("对象转换Json时,发生异常", e);
        }
        return "";
    }

    /**
     * 复杂的类型转换，使用 TypeReference
     * 
     * @param json
     * @param typeReference
     * @return
     */
    public static <T> T toPo(TypeReference<T> typeReference, String json) {
        try {
            return OBJECT_MAPPER.readValue(json, typeReference);
        } catch (Exception e) {
            log.error("对象转换Json时,发生异常", e);
        }
        return null;
    }

    /**
     * 将对象转为JSON
     *
     * @param obj
     *            对象
     *
     * @return Json-字符串
     */
    public static String toPrettyJsonStr(Object obj) {
        try {
            return OBJECT_MAPPER.writerWithDefaultPrettyPrinter().writeValueAsString(obj);
        } catch (Exception e) {
            log.error("对象转换Json时,发生异常", e);
        }
        return "";
    }

}
