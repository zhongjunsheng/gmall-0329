package member.provider.pay.wxpay.domain.model;

import cn.hutool.core.util.ReflectUtil;
import member.provider.pay.wxpay.domain.util.WxPayKit;
import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * Model 公用方法
 *
 * @author Administrator
 */
public class BaseWxModel {

    /**
     * 将建构的 builder 转为 Map
     *
     * @return 转化后的 Map
     */
    public Map<String, Object> toMap() {
        Map<String, String> fieldMap = WxPayKit.getFiledNames(this);
        HashMap<String, Object> map = new HashMap<>(fieldMap.size());
        for (Map.Entry<String, String> each : fieldMap.entrySet()) {
            String key = StringUtils.isNotEmpty(each.getValue()) ? each.getValue() : each.getKey();
            String fieldName = each.getKey();
            Object value = ReflectUtil.getFieldValue(this, fieldName);
            map.put(key, value);
        }
        return map;
    }

}
