package member.provider.Java8Test;

import java.util.List;
import java.util.Optional;

import org.junit.Test;


public class Java8OptionalTest {
	
	
	@Test
	public void test1() {
		Optional<User> op =  Optional.of(null); //不能接收null的参数
		User user = op.get();
		System.out.println(user);
	}
	
	@Test
	public void test2() {
		List<String>  list= null;
		Optional<List<String>> op = Optional.ofNullable(list);  //能接收null值
		
		//isPresent() 判断是否有值
		if(op.isPresent()) { //
			System.out.println("存在");
		}else {
			System.out.println("不存在");
		}
		//System.out.println(op.get());
	}

}
