package member.provider.Java8Test;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;

/**
 * 
 * @author zhongjunsheng
 * 
 * Stream的3个操作步骤
 * 
 *
 */
public class Java8StreamApiTest2 {
	
	static List<User> list = 	Arrays.asList(
			 new User("gg",13,5000.99),
			 new User("aa",10,5000.99),
			 new User("bb",11,4000.00),
			 new User("bb",12,8000.00),
			 new User("aa",11,8000.00)
			 );

	
	
	//@Test
	public void test1() {
		
		List<String> list = new ArrayList<>();
		Stream<String> stream = list.stream();
		String a = "1";
		
		
		Stream.generate(() -> Math.random())
		               .limit(10)
		               .forEach(System.out::println);
	}
	
	
	@Test
	public void test2() {
	
		//1.抽取名字组成新的list
		/*List<String> collect = list.stream().map(user -> user.getName()).collect(Collectors.toList());
		System.out.println(collect.toString());*/
		
		//2.以名字分组
   /*     Map<String, List<User>> map= list.stream().collect(Collectors.groupingBy(u -> u.getName()));
    * 
    */     //以名字年龄分组
   /*     Map<String, List<User>> map= list.stream().collect(Collectors.groupingBy(u -> u.getName() +u.getAge()));
       //System.out.println(map.get("aa").toString());
       System.out.println(map.toString());
		*/
		//过滤-工资 
		/*List<User> collect = list.stream().filter(u -> u.getSlary() >7000).limit(1).collect(Collectors.toList());
		System.out.println(collect.toString());*/
		
		//list.stream().map( user -> user.getName().equals("gg") ).collect(Collectors.toList());
		//list转map
		Map<String, User> collect = list.stream().collect(Collectors.toMap(User::getName, User -> User,(key1, key2) -> key2)); //1
		Map<String, Integer> collect3 = list.stream().collect(Collectors.toMap(User::getName, User::getAge,(key1, key2) -> key2));
		//和1的操作一样
		Map<String, User> collect2 = list.stream().distinct().collect(Collectors.toMap(User::getName,Function.identity(),(key1, key2) -> key2));//3
		
		List<UserInfo> collect4 = list.stream().map(user ->{
			UserInfo info = new UserInfo();
			info.setUsername(user.getName());
			info.setAge(user.getAge());
			info.setAddress("GZ");
			return info;
		}).collect(Collectors.toList());
		
		System.out.println(collect.toString());
	}



	@Test
	public void whenFilterList_thenSuccess(){
		List<String> names = Arrays.asList("Adam", "Alexander", "John", "Tom");
//		List<String> result = names.stream()
//				.filter(name -> name.startsWith("A") && name.length() < 5)
//				.collect(Collectors.toList());


		Predicate<String> predicate1 = str -> str.startsWith("A");
		Predicate<String> predicate2 =  str -> str.length() < 5;

		List<String> result = names.stream()
				.filter(predicate1.and(predicate2))
				.collect(Collectors.toList());

		System.out.println(result);

	}
}
