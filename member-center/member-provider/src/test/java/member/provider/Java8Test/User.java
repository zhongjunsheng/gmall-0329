package member.provider.Java8Test;

import java.util.concurrent.ConcurrentHashMap;

public class User {
	private String name;
	private Integer Age;
	private Double slary;
	public String getName() {
		return name;
	}
	
	
	
	
	public User() {
		super();
	}



	public User(String name, Integer age, Double slary) {
		super();
		this.name = name;
		Age = age;
		this.slary = slary;
	}


	public void setName(String name) {
		this.name = name;
	}
	public Integer getAge() {
		return Age;
	}
	public void setAge(Integer age) {
		Age = age;
	}
	public Double getSlary() {
		return slary;
	}
	public void setSlary(Double slary) {
		this.slary = slary;
	}


	@Override
	public String toString() {
		return "User [name=" + name + ", Age=" + Age + ", slary=" + slary + "]";
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Age == null) ? 0 : Age.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((slary == null) ? 0 : slary.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (Age == null) {
			if (other.Age != null)
				return false;
		} else if (!Age.equals(other.Age))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (slary == null) {
			if (other.slary != null)
				return false;
		} else if (!slary.equals(other.slary))
			return false;
		return true;
	}
	
	
	
	
	public static void main(String[] args) {
	}

}
