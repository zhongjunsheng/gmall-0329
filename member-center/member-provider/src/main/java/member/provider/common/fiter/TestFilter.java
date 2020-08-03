//package member.provider.common.fiter;//package member.provider.common.fiter;
//
//import member.provider.annotation.Cache;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.ApplicationContext;
//import org.springframework.core.annotation.AnnotationUtils;
//import org.springframework.stereotype.Component;
//import org.springframework.web.method.HandlerMethod;
//import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
//import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;
//
//import javax.servlet.*;
//import javax.servlet.http.HttpServletRequest;
//import java.io.IOException;
//import java.io.PrintWriter;
//import java.net.InetAddress;
//import java.net.UnknownHostException;
//import java.util.*;
//
//@Component
//public class TestFilter implements Filter {
//
//
//    private final static org.slf4j.Logger LOGGER = org.slf4j.LoggerFactory.getLogger(TestFilter.class);
//
//    @Autowired
//	private ApplicationContext applicationContext;
//
//
//    @Override
//    public void init(FilterConfig filterConfig){
//
//    }
//
//    @Override
//    public void doFilter(ServletRequest request, ServletResponse resp, FilterChain chain) throws IOException, ServletException {
//		Map<RequestMappingInfo, HandlerMethod> handlerMethodMap = applicationContext.getBean(RequestMappingHandlerMapping.class).getHandlerMethods();
//		for (Map.Entry<RequestMappingInfo, HandlerMethod> infoEntry : handlerMethodMap.entrySet()) {
//			HandlerMethod handlerMethod = infoEntry.getValue();
//			handlerMethod.getBeanType();
//			handlerMethod.getMethod();
//			if (AnnotationUtils.findAnnotation(handlerMethod.getMethod(), Cache.class) != null
//					|| AnnotationUtils.findAnnotation(handlerMethod.getBeanType(), Cache.class) != null) {
//				chain.doFilter(request, resp);
//			}
//		}
//
//    }
//
//    @Override
//    public void destroy() {
//
//    }
//
//
//
//
//
//}
