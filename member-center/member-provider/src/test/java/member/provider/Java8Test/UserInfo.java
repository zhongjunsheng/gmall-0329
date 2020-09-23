package member.provider.Java8Test;

import java.util.Arrays;
import java.util.List;

public class UserInfo {
	private String username;
	private Integer age;
	private String address;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}

	public static void main(String[] args) {
//		double d = 23.24764d;
//
//		double v = d * 1000;
//
//		int a = (int)d * 1000;
//
//		int round = (int)Math.round(v);
//
//		System.out.println(v);
//
//		System.out.println( a);
//
//
//		System.out.println(round);


		List<Long> list = Arrays.asList(1L,2l);

		Long[] objects = (Long[]) list.toArray();


		System.out.println(objects);
	}
	

}
