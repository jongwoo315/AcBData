//package com.acorn.dec_eight.model;
package ldg.mybatis.model;
public class User {

	private long id;	
	private String username;
	private String address;
	private String email;

	public User(){id=0;}
	
	public User(long id, String username, String address, String email){
		this.id = id;
		this.username = username;
		this.address = address;
		this.email = email;
	}

	public void setId(long id) {this.id = id;}
	public void setUsername(String username) {this.username = username;}
	public void setAddress(String address) {this.address = address;}
	public void setEmail(String email) {this.email = email;}

	public long getId() {return id;}
	public String getUsername() {return username;}
	public String getAddress() {return address;}
	public String getEmail() {return email;}

	@Override	// import를 하면 기본적으로 object를 가져온다. / 동적으로 만들면 나중에 gc로 미사용 것들을 삭제하기 용이하다
	public int hashCode() {		// hash를 사용하는 때: 가장 빨리 검색할 수 있는 방법
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof User))
			return false;
		User other = (User) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", address=" + address+ ", email=" + email + "]";
	}
}
