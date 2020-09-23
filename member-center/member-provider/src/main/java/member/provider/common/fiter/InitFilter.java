package member.provider.common.fiter;


import member.provider.common.servlet.BufferedServletRequestWrapper;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;


/**
 * @author zhongjs
 */
public class InitFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
        throws IOException, ServletException {
        if (request instanceof HttpServletRequest) {
            BufferedServletRequestWrapper requestWrapper = new BufferedServletRequestWrapper((HttpServletRequest)request);
            chain.doFilter(requestWrapper, response);
        } else {
            chain.doFilter(request, response);
        }
    }
}