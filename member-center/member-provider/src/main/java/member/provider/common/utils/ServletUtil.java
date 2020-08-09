package member.provider.common.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.method.HandlerMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Spring MVC 的帮助类

 */
public class ServletUtil {

    private static final Logger log = LoggerFactory.getLogger(ServletUtil.class);

    private ServletUtil() {}

    /**
     * 返回SpringMvc forward 地址
     */
    public static String forward(String uri) {
        return "forward:" + uri;
    }

    /**
     * 返回SpringMvc redirect 地址
     */
    public static String redirect(String uri) {
        return "redirect:" + uri;
    }

    /**
     * response sendRedirect 地址
     */
    public static void sendRedirect(String url, HttpServletResponse response) {
        try {
            response.sendRedirect(url);
        } catch (IOException e) {
            log.info(e.getMessage(), e);
        }
    }

    /**
     * 获取请求前的URL
     */
    public static String referer() {
        return getRequest().getHeader("Referer");
    }

    /**
     * 获取请求前的URL
     */
    public static String referer(HttpServletRequest request) {
        return request.getHeader("Referer");
    }

    /**
     * 获取HttpServletRequest
     */
    public static HttpServletRequest getRequest() {
        ServletRequestAttributes requestAttributes =
            ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes());
        if (requestAttributes == null) {
            throw new RuntimeException("无法获取HttpServletRequest");
        }
        return requestAttributes.getRequest();
    }

    /**
     * 获取HttpServletResponse
     */
    public static HttpServletResponse getResponse() {
        ServletRequestAttributes requestAttributes =
            ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes());
        HttpServletResponse response = null;
        if (requestAttributes != null) {
            response = requestAttributes.getResponse();
        }
        if (response == null) {
            ServletWebRequest request = ((ServletWebRequest) RequestContextHolder.getRequestAttributes());
            if (request != null) {
                response = request.getResponse();
            }
        }
        if (response == null) {
            throw new RuntimeException("无法获取HttpServletResponse");
        }
        return response;
    }

    /**
     * HttpResponse 输出文字
     */
    public static void write(String resp, HttpServletResponse response) {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter print = response.getWriter()) {
            print.write(resp);
            print.flush();
        } catch (IOException e) {
            log.error(e.getMessage(), e);
        }
    }

    /**
     * 获取当前请求的IP
     */
    public static String getIp() {
        return getIp(getRequest());
    }

    /**
     * 获取IP
     */
    public static String getIp(HttpServletRequest request) {
        String ipAddress = request.getHeader("x-forwarded-for");
        String unknown = "unknown";
        if (ipAddress == null || ipAddress.length() == 0 || unknown.equalsIgnoreCase(ipAddress)) {
            ipAddress = request.getHeader("Proxy-Client-IP");
        }
        if (ipAddress == null || ipAddress.length() == 0 || unknown.equalsIgnoreCase(ipAddress)) {
            ipAddress = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ipAddress == null || ipAddress.length() == 0 || unknown.equalsIgnoreCase(ipAddress)) {
            ipAddress = request.getRemoteAddr();
        }
        // 对于通过多个代理的情况，第一个IP为客户端真实IP,多个IP按照','分割
        int ipAddressProxyLength = 15;
        if (ipAddress.length() > ipAddressProxyLength) {
            String proxySeparate = ",";
            if (ipAddress.contains(proxySeparate)) {
                ipAddress = ipAddress.substring(0, ipAddress.indexOf(proxySeparate));
            }
        }
        return ipAddress;
    }

    /**
     * 获取IP（转成数字类型）
     */
    public static long getIpNum(HttpServletRequest request) {
        String ip = getIp();
        return NetUtils.ipv4ToLong(ip);
    }

    /**
     * 获取项目的域名根路径
     */
    public static String root(HttpServletRequest request) {
        return String.join("", request.getScheme(), "://", request.getServerName(), ":", request.getServerPort() + "",
            request.getContextPath(), "/");
    }

    /**
     * 获取项目域名的根路径
     */
    public static String root() {
        return root(getRequest());
    }

    /**
     * 判断是否-HandlerMethod
     *
     * @param object
     *            Obj
     *
     * @return 是否
     */
    public static boolean isHandlerMethod(Object object) {
        return object instanceof HandlerMethod;
    }

}
