package com.sp.controllers;

import java.util.HashMap;
import java.util.List;

import org.hibernate.boot.jaxb.internal.stax.HbmEventReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.sp.beans.HobbyBean;
import com.sp.services.HobbiesServiceImpl;


@Controller
@RequestMapping(value = "/hobby")
public class HobbiesController {
	
	public HobbiesController() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Autowired
	HobbiesServiceImpl hbServiceImpl;

	@RequestMapping(value = "/add",method = RequestMethod.GET)
	public ModelAndView addHobby() {
		HashMap<String, Object> model = new HashMap<String, Object>();
		model.put("hbBean", new HobbyBean());
		model.put("message", "::HOBBIES::");
		return new ModelAndView("hobbymain",model);
	}
	
	@RequestMapping(value = "/add",method = RequestMethod.POST)
	public ModelAndView insertHobby(@ModelAttribute("hbBean") HobbyBean hobbyBean) {
		HashMap<String, Object> model = new HashMap<String, Object>();
		String msg = hbServiceImpl.addHobby(hobbyBean);
		model.put("message", msg);
		return new ModelAndView("hobbymain",model);
	}
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ModelAndView showHobbies() {
		HashMap<String, Object> model = new HashMap<String, Object>();
		model.put("hbBean", new HobbyBean());
		model.put("hblist", hbServiceImpl.showAllHobbies());
		return new ModelAndView("hobbylist",model);
	}
	
	@RequestMapping(value = "/delete/{hbid}", method = RequestMethod.GET)
	public ModelAndView deleteSkill(@PathVariable("hbid") int hbid) {
		HashMap<String, Object> model = new HashMap<String, Object>();
		String msg = hbServiceImpl.removeHobby(hbid);
		model.put("message", msg);
		model.put("hblist",hbServiceImpl.showAllHobbies());
		return new ModelAndView("hobbylist",model);
	}

	@RequestMapping(value = "/update/{hbid}", method = RequestMethod.GET)
	public ModelAndView updateHobby(@PathVariable("hbid") int hbid) {
		HashMap<String, Object> model = new HashMap<String, Object>();
		model.put("hbBean", hbServiceImpl.showHobby(hbid));
		return new ModelAndView("hobbylist",model);
	}
}
