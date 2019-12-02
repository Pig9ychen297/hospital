package com.zhiyou.pojo;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Registrationinfor {
    private Integer ri_id;//挂号主键id
    private String ri_name;//姓名
    private String ri_identytype;//证件类型(身份证，护照，军人证)（下拉框）
    private String ri_idnum;//证件号
    private String ri_socialnum;//社保号
    private String ri_phone;//联系电话
    private String ri_selef_paying;//是否自费(单选框)
    private String ri_sex;//性别(单选框)
    private Integer ri_age;//年龄
    private String ri_career;//职业
    private String ri_first_visit;//初复诊（初诊，复诊 单选框）
    private Integer d_id;//医生表主键id
    private String ri_state;//状态
    private String ri_remark;//备注
    private Integer ac_id;//住院结算表id
    private Integer di_id;//发药表主键id
    private Integer cm_id;//收费表主键id
    private Integer hi_id;//住院信息表主键id
    @JsonFormat(pattern="yyyy-MM-dd",timezone="GMT+8")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date ri_date;
    private Integer ri_flag;//状态
    private Doctor doctor;
  
   
	public Date getRi_date() {
		return ri_date;
	}
	public void setRi_date(Date ri_date) {
		this.ri_date = ri_date;
	}
	public Doctor getDoctor() {
		return doctor;
	}
	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}
	public Integer getRi_id() {
		return ri_id;
	}
	public void setRi_id(Integer ri_id) {
		this.ri_id = ri_id;
	}
	
	public String getRi_name() {
		return ri_name;
	}
	public void setRi_name(String ri_name) {
		this.ri_name = ri_name;
	}
	public String getRi_identytype() {
		return ri_identytype;
	}
	public void setRi_identytype(String ri_identytype) {
		this.ri_identytype = ri_identytype;
	}
	public String getRi_idnum() {
		return ri_idnum;
	}
	public void setRi_idnum(String ri_idnum) {
		this.ri_idnum = ri_idnum;
	}
	public String getRi_socialnum() {
		return ri_socialnum;
	}
	public void setRi_socialnum(String ri_socialnum) {
		this.ri_socialnum = ri_socialnum;
	}
	public String getRi_phone() {
		return ri_phone;
	}
	public void setRi_phone(String ri_phone) {
		this.ri_phone = ri_phone;
	}
	public String getRi_selef_paying() {
		return ri_selef_paying;
	}
	public void setRi_selef_paying(String ri_selef_paying) {
		this.ri_selef_paying = ri_selef_paying;
	}
	public String getRi_sex() {
		return ri_sex;
	}
	public void setRi_sex(String ri_sex) {
		this.ri_sex = ri_sex;
	}
	public Integer getRi_age() {
		return ri_age;
	}
	public void setRi_age(Integer ri_age) {
		this.ri_age = ri_age;
	}
	public String getRi_career() {
		return ri_career;
	}
	public void setRi_career(String ri_career) {
		this.ri_career = ri_career;
	}
	public String getRi_first_visit() {
		return ri_first_visit;
	}
	public void setRi_first_visit(String ri_first_visit) {
		this.ri_first_visit = ri_first_visit;
	}
	public Integer getD_id() {
		return d_id;
	}
	public void setD_id(Integer d_id) {
		this.d_id = d_id;
	}
	public String getRi_state() {
		return ri_state;
	}
	public void setRi_state(String ri_state) {
		this.ri_state = ri_state;
	}
	public String getRi_remark() {
		return ri_remark;
	}
	public void setRi_remark(String ri_remark) {
		this.ri_remark = ri_remark;
	}
	public Integer getAc_id() {
		return ac_id;
	}
	public void setAc_id(Integer ac_id) {
		this.ac_id = ac_id;
	}
	public Integer getDi_id() {
		return di_id;
	}
	public void setDi_id(Integer di_id) {
		this.di_id = di_id;
	}
	public Integer getCm_id() {
		return cm_id;
	}
	public void setCm_id(Integer cm_id) {
		this.cm_id = cm_id;
	}
	public Integer getHi_id() {
		return hi_id;
	}
	public void setHi_id(Integer hi_id) {
		this.hi_id = hi_id;
	}
	public Integer getRi_flag() {
		return ri_flag;
	}
	public void setRi_flag(Integer ri_flag) {
		this.ri_flag = ri_flag;
	}
	@Override
	public String toString() {
		return "Registrationinfor [ri_id=" + ri_id + ", ri_no=" + ", ri_name=" + ri_name + ", ri_identytype="
				+ ri_identytype + ", ri_idnum=" + ri_idnum + ", ri_socialnum=" + ri_socialnum + ", ri_phone=" + ri_phone
				+ ", ri_selef_paying=" + ri_selef_paying + ", ri_sex=" + ri_sex + ", ri_age=" + ri_age + ", ri_career="
				+ ri_career + ", ri_first_visit=" + ri_first_visit + ", d_id=" + d_id + ", ri_state=" + ri_state
				+ ", ri_remark=" + ri_remark + ", ac_id=" + ac_id + ", di_id=" + di_id + ", cm_id=" + cm_id + ", hi_id="
				+ hi_id + ", ri_flag=" + ri_flag + "]";
	}
}