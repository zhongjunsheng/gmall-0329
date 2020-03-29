package member.provider.Java8Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;

import javax.sound.midi.Soundbank;

import org.junit.Test;

public class LambaTest1 {
	
	
	@Test
	//无参数，无返回值
	public void test1() { 
		
		Runnable  rn= new Runnable() {
			
			@Override
			public void run() {
				System.out.println("+++++++=");
			}
		};
		
		rn.run();
		
		System.out.println("####################");
		
		
		Runnable r = () -> System.out.println("lambda.....................");
		r.run();
	}
	
	//有一个参数，you 返回值
	@Test
	public void test2() {
		Consumer<String> con = (x) -> System.out.println(x);
		con.accept("hello");
	} 
	
	//有一多个参数，多条语句 必须{} 括起来
	@Test
	public void test3() {
			Comparator<Integer> com = (x,y) -> {
				System.out.println("00");
				return Integer.compare(x, y);
			};
		} 
	
	@Test
	public void test4() {
		Integer  n = getNum(10, x -> x * x); 
		System.out.println(n);
	}

	public Integer getNum(Integer num ,Myfun mf) {
		return mf.getValue(num);
	}
	
	
	public void e() {
		  List<String> names1 = new ArrayList<String>();
	      names1.add("Boogle ");
	      names1.add("Aunoob ");
	      names1.add("Caobao ");
	      names1.add("Faidu ");
	      names1.add("Dina ");
		Collections.sort(names1,(x,y) -> {
			return 1;
		});
		
	}
}
