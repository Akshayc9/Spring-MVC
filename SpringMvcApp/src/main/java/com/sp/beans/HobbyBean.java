package com.sp.beans;

public class HobbyBean {
	
	private int hobbyId;
	private String hobbyName;
	@Override
	public String toString() {
		return "HobbiesBean [hobbyId=" + hobbyId + ", hobbyName=" + hobbyName + "]";
	}
	public HobbyBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getHobbyId() {
		return hobbyId;
	}
	public String getHobbyName() {
		return hobbyName;
	}
	public void setHobbyId(int hobbyId) {
		this.hobbyId = hobbyId;
	}
	public void setHobbyName(String hobbyName) {
		this.hobbyName = hobbyName;
	}
	public HobbyBean(int hobbyId, String hobbyName) {
		super();
		this.hobbyId = hobbyId;
		this.hobbyName = hobbyName;
	}
}
