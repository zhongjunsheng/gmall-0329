package member.provider.Java8Test;

import org.assertj.core.util.Lists;

import java.util.List;
import java.util.Optional;

public class Java8Tester2 {

	public static void main(String args[]){

		//Arrays.asList( "a", "b", "d" ).forEach( fe -> System.out.println( fe ) );

		String str = "2";
		Optional<String> ofNullable = Optional.ofNullable(str);

		Optional.ofNullable(str).orElseThrow(() -> new RuntimeException() );



		String str3 = "x";
		//这代码的意思时 判断str3 如果为空 则 给个默认值rest
		String orElse = Optional.ofNullable(str3).orElse("rest");

		//这代码的意思时 判断str3 如果为空 则 抛出异常
		String orElse2 = Optional.ofNullable(str3).orElseThrow(() -> new RuntimeException());

		//
		 Optional<String> ofNullable2 = Optional.ofNullable(str3);

		 //ofNullable2存在  即str3 不为空 则返回true
		 boolean present = ofNullable2.isPresent();

		 // 33
		 List<Integer> nums = Lists.newArrayList(1,null,3,4,null,6);
	    nums.stream().filter(e -> e!= null).limit(2).forEach(f -> System.out.println(f));

		// System.out.println(findFirst.get());
		 long count = nums.stream().filter(num -> num != null).count();
		 System.out.println(count);


	}
}
