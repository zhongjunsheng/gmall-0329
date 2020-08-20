package member.provider.common.fiter;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(urlPatterns = "/*",filterName = "corsFilter")
@Slf4j
public class CorsFilter implements Filter {


    /**
     * 处理跨域问题过滤器
     */

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
        HttpServletResponse response = (HttpServletResponse) res;
        HttpServletRequest request = (HttpServletRequest) req;
        response.addHeader("Access-Control-Allow-Origin", "*");
        response.addHeader("Access-Control-Allow-Methods", "POST,GET");
        response.addHeader("Access-Control-Max-Age", "3600");
        response.addHeader("Access-Control-Allow-Headers", "origin, content-type, accept, x-requested-with, sid, mycustom, smuser,Content-disposition");
        log.info("*********************************过滤器被使用*********************************");
        System.out.println("====================filter=======================");
        chain.doFilter(req, res);
    }



    @Override
    public void init(FilterConfig filterConfig) {
    }


    @Override
    public void destroy() {
    }
}

