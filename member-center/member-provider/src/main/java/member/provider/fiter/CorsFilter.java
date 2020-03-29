///*
// * 广州丰石科技公司有限公司拥有本软件版权2017并保留所有权利。
// * Copyright 2017, GuangZhou Rich Stone Data Technologies Company Limited,
// * All rights reserved.
// *//*
//
//package member.provider.fiter;
//
//
//import org.springframework.core.annotation.Order;
//
//import javax.servlet.*;
//import javax.servlet.annotation.WebFilter;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//
//
//@Order(1) @WebFilter(filterName = "allow-OriginFitter", urlPatterns = "/*")
//
//public class CorsFilter implements Filter {
//
//    private final static org.slf4j.Logger LOGGER = org.slf4j.LoggerFactory
//            .getLogger(CorsFilter.class);
//
//    */
///**
//     * 处理跨域问题过滤器
//     *//*
//
//    public void doFilter(ServletRequest req, ServletResponse res,
//            FilterChain chain) throws IOException, ServletException {
//        HttpServletResponse response = (HttpServletResponse) res;
//        HttpServletRequest request = (HttpServletRequest) req;
//       // response.setHeader("Allow", "GET,POST");
//        response.addHeader("Access-Control-Allow-Origin", "*");
//        response.addHeader("Access-Control-Allow-Methods", "POST,GET");
//        response.addHeader("Access-Control-Max-Age", "3600");
//        response.addHeader("Access-Control-Allow-Headers",
//                "origin, content-type, accept, x-requested-with, sid, mycustom, smuser,Content-disposition");
//
//        LOGGER.info(
//                "*********************************过滤器被使用*********************************");
//        chain.doFilter(req, res);
//    }
//
//    */
///**
//     * init
//     *//*
//
//    public void init(FilterConfig filterConfig) {
//    }
//
//    */
///**
//     * destroy
//     *//*
//
//    public void destroy() {
//    }
//}
//
//*/
