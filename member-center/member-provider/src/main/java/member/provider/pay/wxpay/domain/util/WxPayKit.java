package member.provider.pay.wxpay.domain.util;

import cn.hutool.core.util.CharsetUtil;
import cn.hutool.core.util.ReflectUtil;
import cn.hutool.core.util.StrUtil;
import member.provider.common.utils.AesUtil;
import member.provider.pay.wxpay.domain.anno.WxProperty;
import member.provider.pay.wxpay.domain.enums.SignType;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.codec.digest.HmacUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.Base64Utils;
import org.springframework.util.StringUtils;

import javax.crypto.Mac;
import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.net.URLEncoder;
import java.security.NoSuchAlgorithmException;
import java.util.*;

/**
 * 微信支付工具类
 *
 * @author Administrator
 */
public class WxPayKit {
    private WxPayKit() {}

    private static final Logger log = LoggerFactory.getLogger(WxPayKit.class);
    private static final String FIELD_SIGN = "sign";
    private static final String FIELD_SIGN_TYPE = "sign_type";

    /**
     * hmacSha256 加密
     *
     * @param data
     *            加密数据
     * @param key
     *            KEY
     *
     * @return 加密结果
     */
    public static String hmacSha256(String data, String key) throws NoSuchAlgorithmException {
        byte[] result = HmacUtils.updateHmac(Mac.getInstance(key), data).doFinal();
        return Base64Utils.encodeToString(result);
    }

    /**
     * Md5 加密
     *
     * @param data
     *            数据
     *
     * @return 加密后的结果
     */
    public static String md5(String data) {
        return DigestUtils.md5Hex(data);
    }

    /**
     * AES 解密
     *
     * @param base64Data
     *            需要解密的数据
     * @param key
     *            密钥
     *
     * @return 解密后的数据
     */
    public static String decryptData(String base64Data, String key) {
        try {
            byte[] result = AesUtil.decryptAES(base64Data.getBytes(), AesUtil.strKey2SecretKey(md5(key).toLowerCase()));
            return Base64Utils.encodeToString(result);
        } catch (Exception e) {
            log.info("Base64 解密时发生异常", e);
            return null;
        }
    }

    /**
     * AES 加密
     *
     * @param data
     *            需要加密的数据
     * @param key
     *            密钥
     *
     * @return 加密后的数据
     */
    public static String encryptData(String data, String key) {
        try {
            byte[] result = AesUtil.encryptAES(data.getBytes(), AesUtil.strKey2SecretKey(md5(key).toLowerCase()));
            return Base64Utils.encodeToString(result);
        } catch (Exception e) {
            log.info("Base64 加密时发生异常", e);
            return null;
        }
    }

    /**
     * 产品随机数
     *
     * @return 随机数
     */
    public static String generateStr() {
        String data = UUID.randomUUID().toString();
        data = data.replace("-", "");
        return data;
    }

    /**
     * 组装签名的字段
     *
     * @param params
     *            参数
     * @param urlEncoder
     *            是否urlEncoder
     *
     * @return {String}
     */
    public static String packageSign(Map<String, Object> params, boolean urlEncoder) {
        // 先将参数以其参数名的字典序升序进行排序
        TreeMap<String, Object> sortedParams = new TreeMap<>(params);
        // 遍历排序后的字典，将所有参数按"key=value"格式拼接在一起
        StringBuilder sb = new StringBuilder();
        boolean first = true;
        for (Map.Entry<String, Object> param : sortedParams.entrySet()) {
            Object value = param.getValue();
            if (StringUtils.isEmpty(value)) {
                continue;
            }
            if (first) {
                first = false;
            } else {
                sb.append("&");
            }
            sb.append(param.getKey()).append("=");
            if (urlEncoder) {
                try {
                    value = urlEncode(value.toString());
                } catch (UnsupportedEncodingException e) {
                    log.warn("转换异常,已忽略该次转换..转换值:" + value, e);
                }
            }
            sb.append(value);
        }
        return sb.toString();
    }



    public static String urlEncode(String src) throws UnsupportedEncodingException {
        return URLEncoder.encode(src, CharsetUtil.UTF_8).replace("+", "%20");
    }


    /**
     * 生成签名
     *
     * @param params
     *            需要签名的参数
     * @param partnerKey
     *            密钥
     * @param signType
     *            签名类型
     *
     * @return 签名后的数据
     */
    public static String createSign(Map<String, Object> params, String partnerKey, SignType signType) {
        if (signType == null) {
            signType = SignType.MD5;
        }
        // 生成签名前先去除sign
        params.remove(FIELD_SIGN);
        String tempStr = packageSign(params, false);
        String stringSignTemp = tempStr + "&key=" + partnerKey;
        if (signType == SignType.MD5) {
            return md5(stringSignTemp).toUpperCase();
        } else {
            try {
                return hmacSha256(stringSignTemp, partnerKey).toUpperCase();
            } catch (Exception e) {
                throw new RuntimeException("加密失败.", e);
            }
        }
    }

    /**
     * 构建签名
     *
     * @param params
     *            需要签名的参数
     * @param partnerKey
     *            密钥
     * @param signType
     *            签名类型
     *
     * @return 签名后的 Map
     */
    public static Map<String, Object> buildSign(Map<String, Object> params, String partnerKey, SignType signType) {
        if (signType == null) {
            signType = SignType.MD5;
        }
        params.put(FIELD_SIGN_TYPE, signType.getType());
        String sign = createSign(params, partnerKey, signType);
        params.put(FIELD_SIGN, sign);
        return params;
    }

    public static StringBuilder forEachMap(Map<String, Object> params, String prefix, String suffix) {
        StringBuilder xml = new StringBuilder();
        if (StrUtil.isNotEmpty(prefix)) {
            xml.append(prefix);
        }
        for (Map.Entry<String, Object> entry : params.entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();
            // 略过空值
            if (value == null ||  StringUtils.isEmpty(value)) {
                continue;
            }
            xml.append("<").append(key).append(">");
            xml.append(entry.getValue());
            xml.append("</").append(key).append(">");
        }
        if (StrUtil.isNotEmpty(suffix)) {
            xml.append(suffix);
        }
        return xml;
    }

    /**
     * 微信下单 map to xml
     *
     * @param params
     *            Map 参数
     *
     * @return xml 字符串
     */
    public static String toXml(Map<String, Object> params) {
        StringBuilder xml = forEachMap(params, "<xml>", "</xml>");
        return xml.toString();
    }

    /**
     * 针对支付的 xml，没有嵌套节点的简单处理
     *
     * @param xmlStr
     *            xml 字符串
     *
     * @return 转化后的 Map
     */
    public static Map<String, Object> xmlToMap(String xmlStr) {
        XmlHelper xmlHelper = XmlHelper.of(xmlStr);
        return xmlHelper.toMap();
    }

    /**
     * 替换url中的参数
     *
     * @param str
     *            原始字符串
     * @param regex
     *            表达式
     * @param args
     *            替换字符串
     *
     * @return {String}
     */
    public static String replace(String str, String regex, String... args) {
        for (String arg : args) {
            str = str.replaceFirst(regex, arg);
        }
        return str;
    }

    /**
     * 判断接口返回的 code
     *
     * @param codeValue
     *            code 值
     *
     * @return 是否是 SUCCESS
     */
    public static boolean codeIsOk(String codeValue) {
        return StrUtil.isNotEmpty(codeValue) && "SUCCESS".equals(codeValue);
    }

    /**
     * <p>
     * 公众号支付-预付订单再次签名
     * </p>
     * <p>
     * 注意此处签名方式需与统一下单的签名类型一致
     * </p>
     *
     * @param prepayId
     *            预付订单号
     * @param appId
     *            应用编号
     * @param partnerKey
     *            API Key
     *
     * @return 再次签名后的 Map
     */
    public static Map<String, Object> prepayIdCreateSign(String prepayId, String appId, String partnerKey,
        SignType signType) {
        Map<String, Object> packageParams = new HashMap<>(6);
        packageParams.put("appId", appId);
        packageParams.put("timeStamp", String.valueOf(System.currentTimeMillis() / 1000));
        packageParams.put("nonceStr", String.valueOf(System.currentTimeMillis()));
        packageParams.put("package", "prepay_id=" + prepayId);
        if (signType == null) {
            signType = SignType.MD5;
        }
        packageParams.put("signType", signType.getType());
        String packageSign = WxPayKit.createSign(packageParams, partnerKey, signType);
        packageParams.put("paySign", packageSign);
        return packageParams;
    }

    /**
     * Map->转换对象
     *
     * @param xml
     *            xml
     * @param <T>
     *            返回结构
     *
     * @return 结果
     *
     * @throws Exception
     *             转换异常
     */
    public static <T> T xmlToObject(String xml, Class<T> clazz) {
        Map<String, Object> xmlMap = WxPayKit.xmlToMap(xml);
        return mapToObject(xmlMap, clazz);
    }

    /**
     * Map->转换对象
     *
     * @param map
     *            Map
     * @param <T>
     *            返回结构
     *
     * @return 结果
     *
     * @throws Exception
     *             转换异常
     */
    @SuppressWarnings("unchecked")
    public static <T> T mapToObject(Map<String, Object> map, Class<T> clazz) {
        if (map == null) {
            return null;
        }
        try {
            Object obj = ReflectUtil.newInstance(clazz);
            BeanInfo beanInfo = Introspector.getBeanInfo(obj.getClass());
            Map<String, String> filedMap = WxPayKit.getFiledNames(obj);
            PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
            for (PropertyDescriptor property : propertyDescriptors) {
                Method setter = property.getWriteMethod();
                if (setter != null) {
                    Object data = map.get(property.getName());
                    if (data instanceof String) {
                        data = ((String)data).trim();
                    }
                    setter.invoke(obj, data);
                }
            }
            for (Map.Entry<String, String> each : filedMap.entrySet()) {
                String key = StringUtils.isEmpty(each.getValue()) ? each.getKey() : each.getValue();
                Object value = map.get(key);
                if (value instanceof String) {
                    value = ((String)value).trim();
                }
                ReflectUtil.setFieldValue(obj, each.getKey(), value);
            }
            return (T)obj;
        } catch (Exception e) {
            throw new RuntimeException("mapToObject 失败", e);
        }
    }


    /**
     * 获取属性名-带映射关系
     *
     * @param obj
     *            对象
     *
     * @return 返回Map（属性名,映射名）
     */
    public static Map<String, String> getFiledNames(Object obj) {
        Field[] fields = ReflectUtil.getFields(obj.getClass());
        Map<String, String> fieldNameMap = new HashMap<>();
        for (Field each : fields) {
            WxProperty property = each.getAnnotation(WxProperty.class);
            fieldNameMap.put(each.getName(), property != null ? property.value() : "");
        }
        return fieldNameMap;
    }



    public static void main(String[] args) {
//        UnifiedOrderResponse response = new UnifiedOrderResponse().setAppId("10086");
////        Map<String, String> filedNames = getFiledNames(response);
////
////        System.out.println(filedNames);
////
////        for (Map.Entry<String, String> each : filedNames.entrySet()) {
////            //String key = ObjectUtils.isNotEmpty(each.getValue()) ? each.getValue() : each.getKey();
////            String fieldName = each.getKey();
////            Object value = ReflectUtil.getFieldValue(response, fieldName);
////            System.out.println(value);
////        }

        Map<String,String> map = new HashMap<>();
        map.put("a","a1");
        map.put("c","a2");
        map.put("b","a3");

        TreeMap<String, Object> ascMap= new TreeMap<>(map);

        NavigableMap<String, String> descMap = new TreeMap<>(map).descendingMap();

        System.out.println("升序:"+ ascMap);


        System.out.println("======================");
        System.out.println("倒序:"+ descMap);


    }

}
