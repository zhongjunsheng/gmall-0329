package member.provider.Java8Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Test;

/**
 * 
 * @author zhongjunsheng
 * 
 * Stream的3个操作步骤
 * 
 *
 */
public class Java8StreamApiTest {
	
	static List<User> list = 	Arrays.asList(
			 new User("gg",13,5000.99),
			 new User("aa",10,5000.99),
			 new User("bb",11,4000.00)
			 );

	
	
	@Test
	public void test1() {
		
		List<String> list = new ArrayList<>();
		Stream<String> stream = list.stream();
		String a = "1";
		
		
		Stream.generate(() -> Math.random())
		               .limit(10)
		               .forEach(System.out::println);
	}
	
	@Test
	//stream 的过滤操作
	public void test2() {
	
	  //list.stream().filter(e -> e.getAge()>11).forEach(System.out::println);
	  //collect 把流 汇集
	
	   List<User> collect = list.stream().filter(e -> e.getAge()>11).collect(Collectors.toList());
	   collect.forEach(System.out::println);
	} 
	
	@Test
	//stream 的limit 数量操作 
	public void test3() {
		 list.stream().filter(e -> e.getSlary() > 4000).limit(1).forEach(System.out::println);
	}
	
	
	@Test
	//stream 的skip操作  -- 跳过结果的前2个
	public void test4() {
		 list.stream().filter(e -> e.getSlary() > 4000).skip(2).forEach(System.out::println);
	}

	@Test
	//stream 的distinct操作  -- 去重
	public void test5() {
		 list.stream().distinct().forEach(System.out::println);
	}
	
	
	@Test
	//stream 的映射 list---转新list
	public void test6() {
		List<String> collect = list.stream().map(u -> u.getName()).distinct().collect(Collectors.toList());
		 list.stream().map(u -> u.getName()).distinct().collect(Collectors.toList()).forEach(System.out::println);
		 list.stream().map(u -> u.getName()).distinct().collect(Collectors.toList()).forEach(System.out::println);
		
  	}
	
	
	
	@Test
	//stream 的映射 -- list 转 map
	public void test7() {
		Map<String, Double> collect = list.stream().collect(Collectors.toMap(User::getName, User::getSlary,(key1,key2) -> key2));
		collect.forEach((k,v) -> {
			System.out.println(collect.get(k));
			System.out.println(k);
			System.out.println(v);
			System.out.println("==================================");
			System.out.println("key是:"+k +"value:"+v);
		});
		
	}
	
	
	
	
	@Test
	//stream 的映射 -- list 转 m
	
	public void test8() {
		List<String> collect = list.stream().map(user -> user.getName()).distinct().collect(Collectors.toList());
		collect.forEach(item -> System.out.println(item));
	}
	
	
	@Test
	//stream ---排序
	public void test9() {
		
		List<String> lt = Arrays.asList("aa","cc","bb","dd");
		//lt.stream().sorted().forEach(item -> System.out.println(item));
		
		//只有一个条件的 比较
		list.stream().sorted((a,b) -> a.getAge().compareTo(b.getAge())).forEach(System.out::println) ;
		
		
		System.out.println("==================================");
		//2个条件的比较--年龄相同比较名字
		/*list.stream().sorted((a,b) -> {
			if(a.getAge().equals(b.getAge())) {
				return a.getName().compareTo(b.getName());
			  }else {
			 	return a.getAge().compareTo(b.getAge());
			  }
			}).forEach(System.out::println) ;
		*/

	}		
	
	
		@Test
		//求和
		public static void test10() {
			int sum = list.stream().mapToInt(user -> user.getAge()).sum(); //年龄总和
			System.out.println(sum);
		}
	
		
		
	public static void main(String[] args) throws InterruptedException {
		

		/*List<String> lt = Arrays.asList("aa","cc","bb","dd");
		//lt.stream().sorted().forEach(item -> System.out.println(item));
		
		//只有一个条件的 比较
		//list.stream().sorted((a,b) -> b.getAge().compareTo(a.getAge())).forEach(System.out::println);
		List<User> collect = list.stream().sorted((a,b) -> b.getAge().compareTo(a.getAge())).collect(Collectors.toList());
		
		
		System.out.println("==================================");
		*/
		
		//System.out.println(d);
		
		
		
             
	}
	
	private int getA() {
		try {
			int a = 10;
			System.out.println("test over"+a);
			return 10;
		}catch(Exception e) {
			System.out.println("gg");
		}finally {
			return 11;
		}
	}
}
