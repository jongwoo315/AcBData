package com.spring.web.model;

import java.sql.Date;

public class User {
	
	private long no;
	private String id;
	private String pw;
	private String name;
	private Date regDate;
	
	public User() {
		no=0L;
	}

	public User(long no, String id, String pw, String name, Date regDate) {
		this.no = no;
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.regDate = regDate;
	}

	public long getNo() {
		return no;
	}

	public void setNo(long no) {
		this.no = no;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime*result+(int)(no^(no>>>33));
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(this==obj)
			return true;
		if(obj==null)
			return false;
		if(!(obj instanceof User))
			return false;
		
		User other = (User) obj;
		if(id!=other.id)
			return false;
		return true;			
	}
	
	@Override
	public String toString() {
		return "User[no=" + no + ", id=" + id + ", pw=" + pw + ", name=" + name+", regDate=" + regDate + "]";
	}

}
