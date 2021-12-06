package com.sp.daos;

import java.util.List;

import com.sp.beans.HobbyBean;
import com.sp.entities.HobbyEn;

public interface HobbiesDao {
	
	//add
	public String saveHobby(HobbyEn hobbyEn);
	//delete
	public String deleteHobby(int hbId);
	//update
	public String updateHobby(int hbId, HobbyEn hobbyEn);
	//get/search skill
	public HobbyEn getHobby(int hbId);
	//get all skills
	public List<HobbyEn> getAllHobbies();

}
