//package member.provider.common.intercetor;
//
//import jodd.util.StringUtil;
//import member.provider.common.utils.DateUtils;
//import member.provider.common.utils.JsonUtils;
//import member.provider.common.utils.ServletUtil;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.web.servlet.HandlerInterceptor;
//import org.springframework.web.servlet.ModelAndView;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.BufferedInputStream;
//import java.io.ByteArrayOutputStream;
//import java.io.IOException;
//import java.util.Map;
//
///**
// * 请求自定义拦截器--请求日志拦截器
// *
// */
//public class RequestLogInterceptor  implements HandlerInterceptor {
//
//    private final Logger log = LoggerFactory.getLogger(RequestLogInterceptor.class);
//
//    private ThreadLocal<Long> requestTimeLocal = new ThreadLocal<>();
//
//
//    @Override
//    public boolean preHandle(final HttpServletRequest request, HttpServletResponse response, Object handler){
//        System.out.println("进入全局日志##########################");
//        long requestTime = System.currentTimeMillis();
//        requestTimeLocal.set(requestTime);
//        StringBuilder logContent = new StringBuilder();
//        logContent.append("请求时间=").append(DateUtils.now()).append("\t");
//        logContent.append("请求uri=").append(request.getRequestURI()).append("\t");
//        logContent.append("请求method=").append(request.getMethod()).append("\t");
//        logContent.append("请求ip=").append(ServletUtil.getIp(request)).append("\t");
//        String paramStr = getParameterJson(request);
//        if (StringUtil.isNotBlank(paramStr)) {
//            //logContent.append(System.lineSeparator());
//            logContent.append("请求参数=");
//            logContent.append(paramStr);
//        }
////        String requestBody = getRequestBodyJson(request);
////        if (StringUtil.isNotEmpty(requestBody)) {
////            logContent.append("请求Body=").append(requestBody).append(System.lineSeparator());
////        }
//        log.info(logContent.toString());
//        return true;
//    }
//
//    @Override
//    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
//        ModelAndView modelAndView) {
//    }
//
//
//    @Override
//    public void afterCompletion(final HttpServletRequest request, final HttpServletResponse response, Object handler,
//        Exception ex) {
//        try {
//            Long renderEndTime = System.currentTimeMillis();
//            Long requestTime = requestTimeLocal.get();
//            long totalUseTime = renderEndTime - requestTime;
//            StringBuilder logContent = new StringBuilder(System.lineSeparator());
//            logContent.append("请求uri=").append(request.getRequestURI()).append("\t");
//            logContent.append("请求总耗时=").append(totalUseTime).append("ms\t");
//            log.info(logContent.toString());
//        } finally {
//            //一定要清空线程本地变量,不然会导致内存泄漏
//            requestTimeLocal.remove();
//        }
//
//        System.out.println("退出全局日志##########################");
//    }
//
//
//    /**
//     * 获取请求参数
//     *
//     * @param request
//     *            请求体
//     *
//     * @return 请求参数JSON化
//     */
//    private String getParameterJson(HttpServletRequest request) {
//        try {
//            Map<String, String[]> parameterMap = request.getParameterMap();
//            if (parameterMap == null || parameterMap.size() == 0) {
//                return null;
//            }
//            return JsonUtils.toJsonStr(parameterMap);
//        } catch (Exception e) {
//            return null;
//        }
//    }
//
//    /**
//     * 获取请求参数
//     *
//     * @param request
//     *            请求体
//     *
//     * @return 请求参数JSON化
//     */
//    private String getRequestBodyJson(HttpServletRequest request) {
//        try (
//            BufferedInputStream bis = new BufferedInputStream(request.getInputStream());
//            ByteArrayOutputStream bos = new ByteArrayOutputStream()) {
//            byte[] buffer = new byte[1024];
//            int len;
//            while ((len = bis.read(buffer)) > 0) {
//                bos.write(buffer, 0, len);
//            }
//            return bos.toString(request.getCharacterEncoding());
//        } catch (IOException e) {
//            return null;
//        }
//    }
//}
