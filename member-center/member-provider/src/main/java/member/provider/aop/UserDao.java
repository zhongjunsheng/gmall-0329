package member.provider.aop;

import member.provider.annotation.Cache;
import org.springframework.stereotype.Component;

@Component
public class UserDao {

	//EL表达式#
	@Cache(name = "#name",pwd = "#pwd")  //动态也业务参数name和pwd传到aop切面
	public void addUser(String name,String pwd){
		System.out.println("进入核心业务层");
		System.out.println("name:"+name+",psw:"+pwd);
	}
	

}
