package member.provider.common.entity;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static member.provider.common.entity.Condition.BB;


/**
 * 消息推送日志独立实体
 */
public class MessagePushLog {

    private static final Logger log = LoggerFactory.getLogger("messagePush.log");

    private MessagePushLog() {
        String str = BB;
    }

    /**
     * 消息推送(包括短信、语音、微信公众号)
     *
     * @param msg
     * @param data
     */
    public static void info(String msg, Object... data) {
        log.info(msg, data);
    }

}
