package member.provider.common.fiter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(urlPatterns = "/*",filterName = "corsFilter")
public class CorsFilter implements Filter {

    private final static org.slf4j.Logger LOGGER = org.slf4j.LoggerFactory.getLogger(CorsFilter.class);

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
        LOGGER.info("*********************************过滤器被使用*********************************");
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

