package com.sp.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Hobby_Table")
public class HobbyEn {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int hobbyId;
	private String hobbyName;
	@Override
	public String toString() {
		return "HobbyEn [hobbyId=" + hobbyId + ", hobbyName=" + hobbyName + "]";
	}
	public HobbyEn() {
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
	public HobbyEn(int hobbyId, String hobbyName) {
		super();
		this.hobbyId = hobbyId;
		this.hobbyName = hobbyName;
	}
	
	
}
