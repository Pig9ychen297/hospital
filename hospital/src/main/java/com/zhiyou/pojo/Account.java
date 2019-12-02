package com.zhiyou.pojo;

import java.util.Date;

public class Account {
    private Integer ac_id;//结算id
    private String ri_id;//病历号
    private String ac_status;//结算状态 (未结算/已结算)
    private Integer ac_total_pay;//总花费
    private Integer ac_pledge;//押金
    private Integer ac_need_pay;//还需缴纳
    private Integer ac_balance;//余额
    private Date ac_time;//结算时间
    private Integer ac_cure_pay;//医疗费用
    private Integer ac_medicine_pay;//药物费用
    private Integer ac_already_pay;//已缴金额
    private Integer ac_flag;//状态
    private Registrationinfor registrationinfor;
    
    
    
    
	public String getRi_id() {
		return ri_id;
	}
	public void setRi_id(String ri_id) {
		this.ri_id = ri_id;
	}
	public Registrationinfor getRegistrationinfor() {
		return registrationinfor;
	}
	public void setRegistrationinfor(Registrationinfor registrationinfor) {
		this.registrationinfor = registrationinfor;
	}
	public Integer getAc_id() {
		return ac_id;
	}
	public void setAc_id(Integer ac_id) {
		this.ac_id = ac_id;
	}
	
	public String getAc_status() {
		return ac_status;
	}
	public void setAc_status(String ac_status) {
		this.ac_status = ac_status;
	}
	public Integer getAc_total_pay() {
		return ac_total_pay;
	}
	public void setAc_total_pay(Integer ac_total_pay) {
		this.ac_total_pay = ac_total_pay;
	}
	public Integer getAc_pledge() {
		return ac_pledge;
	}
	public void setAc_pledge(Integer ac_pledge) {
		this.ac_pledge = ac_pledge;
	}
	public Integer getAc_need_pay() {
		return ac_need_pay;
	}
	public void setAc_need_pay(Integer ac_need_pay) {
		this.ac_need_pay = ac_need_pay;
	}
	public Integer getAc_balance() {
		return ac_balance;
	}
	public void setAc_balance(Integer ac_balance) {
		this.ac_balance = ac_balance;
	}
	public Date getAc_time() {
		return ac_time;
	}
	public void setAc_time(Date ac_time) {
		this.ac_time = ac_time;
	}
	public Integer getAc_cure_pay() {
		return ac_cure_pay;
	}
	public void setAc_cure_pay(Integer ac_cure_pay) {
		this.ac_cure_pay = ac_cure_pay;
	}
	public Integer getAc_medicine_pay() {
		return ac_medicine_pay;
	}
	public void setAc_medicine_pay(Integer ac_medicine_pay) {
		this.ac_medicine_pay = ac_medicine_pay;
	}
	public Integer getAc_already_pay() {
		return ac_already_pay;
	}
	public void setAc_already_pay(Integer ac_already_pay) {
		this.ac_already_pay = ac_already_pay;
	}
	public Integer getAc_flag() {
		return ac_flag;
	}
	public void setAc_flag(Integer ac_flag) {
		this.ac_flag = ac_flag;
	}
	@Override
	public String toString() {
		return "Account [ac_id=" + ac_id + ", ac_number=" + ri_id + ", ac_status=" + ac_status + ", ac_total_pay="
				+ ac_total_pay + ", ac_pledge=" + ac_pledge + ", ac_need_pay=" + ac_need_pay + ", ac_balance="
				+ ac_balance + ", ac_time=" + ac_time + ", ac_cure_pay=" + ac_cure_pay + ", ac_medicine_pay="
				+ ac_medicine_pay + ", ac_already_pay=" + ac_already_pay + ", ac_flag=" + ac_flag + "]";
	}  
}