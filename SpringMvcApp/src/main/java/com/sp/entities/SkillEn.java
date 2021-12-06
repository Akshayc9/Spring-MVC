package com.sp.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Skill_Table")
public class SkillEn {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int skillId;
	private String skillName;
	@Override
	public String toString() {
		return "SkillEn [skillId=" + skillId + ", skillName=" + skillName + "]";
	}
	public int getSkillId() {
		return skillId;
	}
	public String getSkillName() {
		return skillName;
	}
	public void setSkillId(int skillId) {
		this.skillId = skillId;
	}
	public void setSkillName(String skillName) {
		this.skillName = skillName;
	}
	public SkillEn() {
		super();
		// TODO Auto-generated constructor stub
	}
	public SkillEn(int skillId, String skillName) {
		super();
		this.skillId = skillId;
		this.skillName = skillName;
	}
	
	

}
