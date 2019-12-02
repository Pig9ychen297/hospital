package com.zhiyou.pojo;

import java.util.List;

public class Department {
    private Integer de_id;//科室id
    private String de_no;//科室编号
    private String de_name;//科室名称
    private Integer de_flag;//标志
    private List<Doctor> doctorList;
    
    
	public List<Doctor> getDoctorList() {
		return doctorList;
	}
	public void setDoctorList(List<Doctor> doctorList) {
		this.doctorList = doctorList;
	}
	public Integer getDe_id() {
		return de_id;
	}
	public void setDe_id(Integer de_id) {
		this.de_id = de_id;
	}
	public String getDe_no() {
		return de_no;
	}
	public void setDe_no(String de_no) {
		this.de_no = de_no;
	}
	public String getDe_name() {
		return de_name;
	}
	public void setDe_name(String de_name) {
		this.de_name = de_name;
	}
	public Integer getDe_flag() {
		return de_flag;
	}
	public void setDe_flag(Integer de_flag) {
		this.de_flag = de_flag;
	}
	@Override
	public String toString() {
		return "Department [de_id=" + de_id + ", de_no=" + de_no + ", de_name=" + de_name + ", de_flag=" + de_flag
				+ "]";
	}
}