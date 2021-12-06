package com.sp.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sp.beans.EmployeeBean;
import com.sp.beans.SkillsBean;
import com.sp.daos.EmployeeDaoImpl;
import com.sp.entities.EmployeeEn;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeDaoImpl empdao;
	
	@Override
	public String addEmployee(EmployeeBean employeeBean) {
		System.out.println(employeeBean);
		return empdao.saveEmployee(beanToEntity(employeeBean));
	}

	@Override
	public List<EmployeeBean> showAllEmps() {
		List<EmployeeEn> emps = empdao.getAllEmployees();
		return entitiesToBean(emps);
	}

	@Override
	public String modifyEmployee(int empId, EmployeeBean employeeBean) {
		return empdao.updateEmployee(empId, beanToEntity(employeeBean));
	}

	private EmployeeEn beanToEntity(EmployeeBean employeeBean) {
		if (employeeBean == null) {
			return null;
		}
		EmployeeEn entity = new EmployeeEn();
		entity.setEmpId(employeeBean.getEmpId());
		entity.setEmpName(employeeBean.getEmpName());
		entity.setEmpAge(employeeBean.getEmpAge());
		entity.setEmpGender(employeeBean.getEmpGender());
		entity.setEmpSalary(employeeBean.getEmpSalary());
		return entity;
	}

	
	private List<EmployeeBean> entitiesToBean(List<EmployeeEn> emps) {
		List<EmployeeBean> beans = new ArrayList<EmployeeBean>();
		for (EmployeeEn employeeEn : emps) {
			EmployeeBean bean = new EmployeeBean( employeeEn.getEmpId(),
					employeeEn.getEmpName(), employeeEn.getEmpAge(),
					employeeEn.getEmpGender(), employeeEn.getEmpSalary(),null,null,null);
					beans.add(bean);
		}
		return beans;
	}
	
	private EmployeeBean entityToBean(EmployeeEn employeeEn) {
		EmployeeBean bean = new EmployeeBean();
		bean.setEmpId(employeeEn.getEmpId());
		bean.setEmpAge(employeeEn.getEmpAge());	
		bean.setEmpName(employeeEn.getEmpName());	
		bean.setEmpGender(employeeEn.getEmpGender());	
		bean.setEmpSalary(employeeEn.getEmpSalary());	
		bean.setEmpSkills(null);	
		bean.setEmpCity(null);	
		bean.setEmpHobbies(null);
		return bean;
	}

	@Override
	public String removeEmployee(int empId) {
		return empdao.deleteEmployee(empId);
	}

	@Override
	public EmployeeBean getEmployee(int empId) {
		return entityToBean(empdao.getEmployee(empId));
	}
	
	@Override
	public boolean searchEmployee(int empId) {
		return empdao.searchEmployee(empId);
	}
}
