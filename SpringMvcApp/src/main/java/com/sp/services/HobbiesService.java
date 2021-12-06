package com.sp.services;

import java.util.List;

import com.sp.beans.HobbyBean;
import com.sp.beans.SkillsBean;

public interface HobbiesService {

	//add
	public String addHobby(HobbyBean hobbyBean);
	//delete
	public String removeHobby(int hbId);
	//update
	public String modifyHobby(int hbId, HobbyBean hobbyBean);
	//get/search skill
	public HobbyBean showHobby(int hbId);
	//get all skills
	public List<HobbyBean> showAllHobbies();
}
