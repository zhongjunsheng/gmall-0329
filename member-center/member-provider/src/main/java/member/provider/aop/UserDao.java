package member.provider.aop;

import member.provider.annotation.Cache;
import org.springframework.stereotype.Component;

@Component
public class UserDao {

	@Cache
	public void addUser(String name,String psw){
		System.out.println("name:"+name+",psw:"+psw);
	}
	

}
