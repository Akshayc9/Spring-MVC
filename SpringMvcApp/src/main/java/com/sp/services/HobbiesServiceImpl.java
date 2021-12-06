package com.sp.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sp.beans.HobbyBean;
import com.sp.beans.SkillsBean;
import com.sp.daos.HobbiesDaoImpl;
import com.sp.entities.HobbyEn;
import com.sp.entities.SkillEn;

@Service
public class HobbiesServiceImpl implements HobbiesService {

	@Autowired
	HobbiesDaoImpl hobdao;
	
	@Override
	public String addHobby(HobbyBean hobbyBean) {
		return hobdao.saveHobby(beanToEntity(hobbyBean));
	}

	private HobbyEn beanToEntity(HobbyBean hobbyBean) {
		if (hobbyBean == null) {
			return null;
		}
		HobbyEn entity = new HobbyEn();
		entity.setHobbyId(hobbyBean.getHobbyId());
		entity.setHobbyName(hobbyBean.getHobbyName());
		return entity;
	}

	@Override
	public String removeHobby(int hbId) {
		return hobdao.deleteHobby(hbId);
	}

	@Override
	public String modifyHobby(int hbId, HobbyBean hobbyBean) {
		return hobdao.updateHobby(hbId, beanToEntity(hobbyBean));
	}

	@Override
	public HobbyBean showHobby(int hbId) {
		return entityToBean(hobdao.getHobby(hbId));
	}

	private HobbyBean entityToBean(HobbyEn hobby) {
		HobbyBean bean = new HobbyBean();
		bean.setHobbyId(hobby.getHobbyId());
		bean.setHobbyName(hobby.getHobbyName());
		return bean;
	}
	

	@Override
	public List<HobbyBean> showAllHobbies() {
		List<HobbyEn> hobbies = hobdao.getAllHobbies();
		return entitiesToBean(hobbies);
	}
	
	private List<HobbyBean> entitiesToBean(List<HobbyEn> hbs) {
		List<HobbyBean> beans = new ArrayList<HobbyBean>();
		for (HobbyEn hobbyEn : hbs) {
			HobbyBean bean = new HobbyBean(hobbyEn.getHobbyId(),hobbyEn.getHobbyName());
			beans.add(bean);
		}
		return beans;
	}

}
