package member.provider.aop;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestUserController {


	@RequestMapping("/addUser")
	public String addUser(String sessionId){
		System.out.println("sessionId是:" + sessionId);
		System.out.println("11");
		System.out.println("12");
		return "add success!";


		/*String cacheSessionId = cacheApi.get(userCode + openId);
		if(null != cacheSessionId && null != user){
			//说明sessionId肯定没有过期
			CookieUtils.setCookie(response,"SHRIOSESSIONID",cacheSessionId);
			String url = request.getRequestURL().toString();
			StringBuffer parms = new StringBuffer();
			parms.append("?sessionId="+cacheSessionId);
			Map<String,Object> parameterMap = request.getParameterMap();
			for(Map.Entry<String,Object> mp : parameterMap.entrySet()){
				parms.append("&" + mp.getKey() + "=" + mp.getValue());
			}
			try {
				response.sendRedirect(url+parms);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}*/
	}


}
