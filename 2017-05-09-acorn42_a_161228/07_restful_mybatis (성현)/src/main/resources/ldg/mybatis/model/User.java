package ldg.mybatis.model;


public class User {
	
	private long id;
	private String name;
	private String address;
	private String email;
	
	public User() {
		id = 0;
	}
	
	public User(long id, String name, String address, String email) {
		this.id = id;
		this.name = name;
		this.address = address;
		this.email = email;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int)(id^(id>>>32));
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		User other = (User) obj;
		
		if (this == obj)  return true;
		if (obj == null) return false;
		if (!(obj instanceof User)) return false;
		if (id != other.id) return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + name + ",address="
					+ address + ", email=" + email + "]";
	}
	
}
