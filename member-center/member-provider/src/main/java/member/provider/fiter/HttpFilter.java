//package member.provider.fiter;
//
//import javax.servlet.*;
//import javax.servlet.http.HttpServletRequest;
//import java.io.IOException;
//import java.io.PrintWriter;
//import java.net.InetAddress;
//import java.net.UnknownHostException;
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.List;
//
//public class HttpFilter  implements Filter {
//
//
//    private final static org.slf4j.Logger LOGGER = org.slf4j.LoggerFactory.getLogger(HttpFilter.class);
//    private static final String[] whileIps =  {"10.1.2.18","192.168.171.100","192.168.0.90"} ;
//
//    //@Autowired
//    //private UserServiceImpl userServiceImpl;
//
//    public void init(FilterConfig filterConfig) throws ServletException {
//
//    }
//
//    //配置过滤器
//    public void doFilter(ServletRequest req, ServletResponse resp,
//	    FilterChain chain) throws IOException, ServletException {
//	    HttpServletRequest request = (HttpServletRequest) req;
//	   //RequestHolder.add(Thread.currentThread().getId()); //获取当前线程id 添加进ThreadLocal
//	    LOGGER.info("*********************************HttpFilter过滤器被使用*********************************");
//	   //LOGGER.info("httpfilter,{},{},{}",Thread.currentThread().getId(),request.getServletPath(),request.getRemoteAddr());
//	   LOGGER.info("ip：{}",getClientIP(request));
//	   String clientIP = getClientIP(request);
//
//	  //User userById = userServiceImpl.getUserById(1);
//	  //LOGGER.info("userById：{},{}",userById,userById.getUsername());
//	  LOGGER.info("ip：{}",getClientIP(request));
//	  List<String> while_ips = new ArrayList<String>();
//	  while_ips = Arrays.asList(whileIps);
//	  if(while_ips.contains(clientIP)){
//	      //是白名单
//	      chain.doFilter(request, resp);
//	  }else {
//	      LOGGER.info("IP address no permissions!");
//	      resp.setCharacterEncoding("gb2312");
//	      PrintWriter out = resp.getWriter();
//	     out.print("IP address no permissions");
//	  }
//
//
//    }
//
//    public void destroy() {
//
//    }
//
//
//    //获取真实ip
//    public static String getClientIP(HttpServletRequest httpservletrequest) {
//	    if (httpservletrequest == null)
//	        return null;
//	    String s = httpservletrequest.getHeader("X-Forwarded-For");
//	    if (s == null || s.length() == 0 || "unknown".equalsIgnoreCase(s))
//	        s = httpservletrequest.getHeader("Proxy-Client-IP");
//	    if (s == null || s.length() == 0 || "unknown".equalsIgnoreCase(s))
//	        s = httpservletrequest.getHeader("WL-Proxy-Client-IP");
//	    if (s == null || s.length() == 0 || "unknown".equalsIgnoreCase(s))
//	        s = httpservletrequest.getHeader("HTTP_CLIENT_IP");
//	    if (s == null || s.length() == 0 || "unknown".equalsIgnoreCase(s))
//	        s = httpservletrequest.getHeader("HTTP_X_FORWARDED_FOR");
//	    if (s == null || s.length() == 0 || "unknown".equalsIgnoreCase(s))
//	        s = httpservletrequest.getRemoteAddr();
//	    if ("127.0.0.1".equals(s) || "0:0:0:0:0:0:0:1".equals(s))
//	        try {
//	            s = InetAddress.getLocalHost().getHostAddress();
//	        }
//	        catch (UnknownHostException unknownhostexception) {
//	        }
//	    return s;
//	}
//
//
//
//    public static void main(String[] args) {
//	String[] strArray = {"1","2","3"};
//	List<String> fauCodeList = new ArrayList<String>();
//	fauCodeList=Arrays.asList(strArray);
//	if(fauCodeList.contains("1")){
//	    System.out.println("包含");
//
//	 }else{
//	     System.out.println("不包含");
//	 }
//
//  }
//
//
//
//
//
//}
