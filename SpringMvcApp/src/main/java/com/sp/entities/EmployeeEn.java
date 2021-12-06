package com.sp.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Employee_Table")
public class EmployeeEn {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int empId;
	private String empName;
	private int empAge;
	private String empGender;
	private double empSalary;
	@Override
	public String toString() {
		return "EmployeeEn [empId=" + empId + ", empName=" + empName + ", empAge=" + empAge + ", empGender=" + empGender
				+ ", empSalary=" + empSalary + "]";
	}
	public int getEmpId() {
		return empId;
	}
	public String getEmpName() {
		return empName;
	}
	public int getEmpAge() {
		return empAge;
	}
	public String getEmpGender() {
		return empGender;
	}
	public double getEmpSalary() {
		return empSalary;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public void setEmpAge(int empAge) {
		this.empAge = empAge;
	}
	public void setEmpGender(String empGender) {
		this.empGender = empGender;
	}
	public void setEmpSalary(double empSalary) {
		this.empSalary = empSalary;
	}
	public EmployeeEn() {
		super();
		// TODO Auto-generated constructor stub
	}
	public EmployeeEn(int empId, String empName, int empAge, String empGender, double empSalary) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.empAge = empAge;
		this.empGender = empGender;
		this.empSalary = empSalary;
	}
	
	
}
