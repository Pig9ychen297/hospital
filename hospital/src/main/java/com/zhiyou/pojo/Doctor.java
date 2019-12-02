package com.zhiyou.pojo;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Doctor {
    private Integer d_id;//医生表主键id
    private String d_name;//姓名
    private String d_id_type;//证件类型(身份证,护照，军人证)
    private String d_id_number;//证件号
    private String d_tel;//手机号
    private String d_plane;//座机
    private String d_sex;//性别
    private Integer d_age;//年龄
    @JsonFormat(pattern="yyyy-MM-dd",timezone="GMT+8")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date d_date;//出生年月
    private String d_mail;//电子邮箱
    private Integer de_id;//外键  科室表主键
    private String d_educ;//学历(专科，本科，博士，博士后)
    private String d_remark;//备注
    private Integer d_flag;//删除标记(0:已删除/1:未删除)
    private Department department;
    
    
	public Department getDepartment() {
		return department;
	}
	public void setDepartment(Department department) {
		this.department = department;
	}
	public Integer getD_id() {
		return d_id;
	}
	public void setD_id(Integer d_id) {
		this.d_id = d_id;
	}
	public String getD_name() {
		return d_name;
	}
	public void setD_name(String d_name) {
		this.d_name = d_name;
	}
	public String getD_id_type() {
		return d_id_type;
	}
	public void setD_id_type(String d_id_type) {
		this.d_id_type = d_id_type;
	}
	public String getD_id_number() {
		return d_id_number;
	}
	public void setD_id_number(String d_id_number) {
		this.d_id_number = d_id_number;
	}
	public String getD_tel() {
		return d_tel;
	}
	public void setD_tel(String d_tel) {
		this.d_tel = d_tel;
	}
	public String getD_plane() {
		return d_plane;
	}
	public void setD_plane(String d_plane) {
		this.d_plane = d_plane;
	}
	public String getD_sex() {
		return d_sex;
	}
	public void setD_sex(String d_sex) {
		this.d_sex = d_sex;
	}
	public Integer getD_age() {
		return d_age;
	}
	public void setD_age(Integer d_age) {
		this.d_age = d_age;
	}
	public Date getD_date() {
		return d_date;
	}
	public void setD_date(Date d_date) {
		this.d_date = d_date;
	}
	public String getD_mail() {
		return d_mail;
	}
	public void setD_mail(String d_mail) {
		this.d_mail = d_mail;
	}
	public Integer getDe_id() {
		return de_id;
	}
	public void setDe_id(Integer de_id) {
		this.de_id = de_id;
	}
	public String getD_educ() {
		return d_educ;
	}
	public void setD_educ(String d_educ) {
		this.d_educ = d_educ;
	}
	public String getD_remark() {
		return d_remark;
	}
	public void setD_remark(String d_remark) {
		this.d_remark = d_remark;
	}
	public Integer getD_flag() {
		return d_flag;
	}
	public void setD_flag(Integer d_flag) {
		this.d_flag = d_flag;
	}
	@Override
	public String toString() {
		return "Doctor [d_id=" + d_id + ", d_name=" + d_name + ", d_id_type=" + d_id_type + ", d_id_number="
				+ d_id_number + ", d_tel=" + d_tel + ", d_plane=" + d_plane + ", d_sex=" + d_sex + ", d_age=" + d_age
				+ ", d_date=" + d_date + ", d_mail=" + d_mail + ", de_id=" + de_id + ", d_educ=" + d_educ
				+ ", d_remark=" + d_remark + ", d_flag=" + d_flag + "]";
	}
}