package member.provider.Java8Test;

import java.util.*;

import com.google.common.collect.Lists;
import com.sun.javafx.scene.control.skin.TableHeaderRow;
import org.junit.Test;


public class Java8OptionalTest {



	@Test
	public void test3() {
		String str = null;
		String string = Optional.ofNullable(str).orElseThrow(() -> new RuntimeException("DD"));
		System.out.println(str);
	}

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



	@Test
	public void test4(){

		Map<String,String> map = new HashMap<>();
		//有就取 没有则取默认的
		String s = map.computeIfAbsent("name", v -> "allen");
		System.out.println(s);

	}



    @Test
    public void test5(){

        List<Integer> all = new ArrayList<>();
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        //list集合分批每批3条
        List<List<Integer>> supList1 = Lists.partition(list, 4);
        //System.out.println(supList1);
        supList1.forEach(item ->{
            all.addAll(item);
        });

        System.out.println(all);

    }

	@Test
	public void test6() {
		String format = String.format("%s:%s:%s", "a", " ", "c");
		//System.out.println(format.trim());

		String a = " a b";


		System.out.println(a.trim());

	}

	}
