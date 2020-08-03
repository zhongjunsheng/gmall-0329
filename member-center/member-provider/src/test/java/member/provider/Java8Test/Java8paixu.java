package member.provider.Java8Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Java8paixu {
	
	
	public static void main(String[] args) {
		
		/*List<String> list = Arrays.asList("19","20","18");
		
		List<Detail> lt = Arrays.asList(
				new Detail(1,"a","18"),
				new Detail(2,"a1","18"),
				new Detail(3,"b","19"),
				new Detail(1,"b1","19"),
				new Detail(1,"c","19"),
				new Detail(1,"c1","20"),
				new Detail(1,"c2","20")
				);
		
		Map<String, List<Detail>> map = lt.stream().collect(Collectors.groupingBy(Detail::getOrderNo));
		List<Detail> list2 = map.get("18");
		
		List<Detail> targetList = new ArrayList();
		
		
		
		for(String str :list) {
			List<Detail> list3 = map.get(str);
			list3.forEach(item -> targetList.add(item));
		}
		
		targetList.forEach(System.out::println);
		
	}*/
		
		/*
		int a =1;
		int b =3;
		
		//两数相除保留2位小数
	  double f1 = new BigDecimal((float)a/b).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
	  
	  System.out.println(f1);
		*/
		 /*测试合并两个类型相同的list*/
        List<String> list1 = new ArrayList<String>();
        List<String> list2 = new ArrayList<String>();
        //给list1赋值
        list1.add("测");
        list1.add("试");
        list1.add("一");
        list1.add("下");
        //给list2赋值
        list2.add("合");
        list2.add("并");
        list2.add("列");
        list2.add("表");
        //将list1.list2合并
        list1.addAll(list2);
		
		list1.forEach(System.out::println);
	}
}
