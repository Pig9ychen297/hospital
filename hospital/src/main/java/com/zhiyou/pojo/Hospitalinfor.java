package com.zhiyou.pojo;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Hospitalinfor {
    private Integer hi_id;//医院id
    private String hi_no;//病历号
    private String hi_nurse;//护理人
    private String hi_bedno;//床位号
    private Double hi_cashpledge;//缴费押金
    private String hi_state;//状态
    @JsonFormat(pattern="yyyy-MM-dd",timezone="GMT+8")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date hi_date; //住院时间
    private Integer ri_id; //挂号信息外键
    private String hi_illstate;//病情
    private Integer hi_flag;//标志：0表示已删除不显示，1显示
    private Registrationinfor registrationinfor;
    
    
    
	public Integer getRi_id() {
		return ri_id;
	}
	public void setRi_id(Integer ri_id) {
		this.ri_id = ri_id;
	}
	public String getHi_illstate() {
		return hi_illstate;
	}
	public void setHi_illstate(String hi_illstate) {
		this.hi_illstate = hi_illstate;
	}
	public Date getHi_date() {
		return hi_date;
	}
	public void setHi_date(Date hi_date) {
		this.hi_date = hi_date;
	}
	public Registrationinfor getRegistrationinfor() {
		return registrationinfor;
	}
	public void setRegistrationinfor(Registrationinfor registrationinfor) {
		this.registrationinfor = registrationinfor;
	}
	public Integer getHi_id() {
		return hi_id;
	}
	public void setHi_id(Integer hi_id) {
		this.hi_id = hi_id;
	}
	public String getHi_no() {
		return hi_no;
	}
	public void setHi_no(String hi_no) {
		this.hi_no = hi_no;
	}
	public String getHi_nurse() {
		return hi_nurse;
	}
	public void setHi_nurse(String hi_nurse) {
		this.hi_nurse = hi_nurse;
	}
	public String getHi_bedno() {
		return hi_bedno;
	}
	public void setHi_bedno(String hi_bedno) {
		this.hi_bedno = hi_bedno;
	}
	public Double getHi_cashpledge() {
		return hi_cashpledge;
	}
	public void setHi_cashpledge(Double hi_cashpledge) {
		this.hi_cashpledge = hi_cashpledge;
	}
	public String getHi_state() {
		return hi_state;
	}
	public void setHi_state(String hi_state) {
		this.hi_state = hi_state;
	}
	public Integer getHi_flag() {
		return hi_flag;
	}
	public void setHi_flag(Integer hi_flag) {
		this.hi_flag = hi_flag;
	}
	@Override
	public String toString() {
		return "Hospitalinfor [hi_id=" + hi_id + ", hi_no=" + hi_no + ", hi_nurse=" + hi_nurse + ", hi_bedno="
				+ hi_bedno + ", hi_cashpledge=" + hi_cashpledge + ", hi_state=" + hi_state + ", hi_flag=" + hi_flag
				+ "]";
	} 
}