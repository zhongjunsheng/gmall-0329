package member.provider.Java8Test;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

public class Detail {
	
	private Integer id;
	private String name;
	private String orderNo;
	
	
	
	public Detail() {
		super();
	}
	public Detail(Integer id, String name, String orderNo) {
		super();
		this.id = id;
		this.name = name;
		this.orderNo = orderNo;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}
	@Override
	public String toString() {
		return "Detail [id=" + id + ", name=" + name + ", orderNo=" + orderNo + "]";
	}
	
	
	
	public static void main(String[] args) {
		System.out.println(UUID.randomUUID().toString().replaceAll("-", ""));
		
		String str ="a"; 
        int length = str.split(",").length;
        List<String> list = Arrays.asList(str.split(","));
        list.forEach(System.out::println);
        System.out.println(length);
	}
	
	

}
