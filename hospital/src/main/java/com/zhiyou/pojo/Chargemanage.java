package com.zhiyou.pojo;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Chargemanage {
    private Integer cm_id;//收费管理主键id
    private String cm_medicalnum;//病例号
    private Integer ci_id;//收费项目主键
    private Double cm_price;//收费金额
    private Integer ri_id;//病历号主键
    @JsonFormat(pattern="yyyy-MM-dd",timezone="GMT+8")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date cm_date;//收费日期
    private Integer cm_flag;//标志
    private Registrationinfor registrationinfor;
    private Chargeitem chargeitem;
    
    
	public Integer getRi_id() {
		return ri_id;
	}
	public void setRi_id(Integer ri_id) {
		this.ri_id = ri_id;
	}
	public Integer getCm_flag() {
		return cm_flag;
	}
	public void setCm_flag(Integer cm_flag) {
		this.cm_flag = cm_flag;
	}
	public Registrationinfor getRegistrationinfor() {
		return registrationinfor;
	}
	public void setRegistrationinfor(Registrationinfor registrationinfor) {
		this.registrationinfor = registrationinfor;
	}
	public Chargeitem getChargeitem() {
		return chargeitem;
	}
	public void setChargeitem(Chargeitem chargeitem) {
		this.chargeitem = chargeitem;
	}
	public Integer getCm_id() {
		return cm_id;
	}
	public void setCm_id(Integer cm_id) {
		this.cm_id = cm_id;
	}
	public String getCm_medicalnum() {
		return cm_medicalnum;
	}
	public void setCm_medicalnum(String cm_medicalnum) {
		this.cm_medicalnum = cm_medicalnum;
	}
	public Integer getCi_id() {
		return ci_id;
	}
	public void setCi_id(Integer ci_id) {
		this.ci_id = ci_id;
	}
	public Double getCm_price() {
		return cm_price;
	}
	public void setCm_price(Double cm_price) {
		this.cm_price = cm_price;
	}
	public Date getCm_date() {
		return cm_date;
	}
	public void setCm_date(Date cm_date) {
		this.cm_date = cm_date;
	}
	@Override
	public String toString() {
		return "Chargemanage [cm_id=" + cm_id + ", cm_medicalnum=" + cm_medicalnum + ", ci_id=" + ci_id + ", cm_price="
				+ cm_price + ", cm_date=" + cm_date + ", cm_flag=" + cm_flag + ", getCm_id()=" + getCm_id()
				+ ", getCm_medicalnum()=" + getCm_medicalnum() + ", getCi_id()=" + getCi_id() + ", getCm_price()="
				+ getCm_price() + ", getCm_date()=" + getCm_date() + ", getClass()=" + getClass() + ", hashCode()="
				+ hashCode() + ", toString()=" + super.toString() + "]";
	}
}