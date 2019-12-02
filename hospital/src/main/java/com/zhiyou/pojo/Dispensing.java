package com.zhiyou.pojo;

import java.util.Date;

public class Dispensing {
    private Integer di_id;//发药主键id
    private Integer m_id;//外键	药品表主键
    private Integer ri_id;
    private Integer di_counts;//发药数量
    private Integer di_hascounts;//已发数量
    private Integer di_notcounts;//未发数量
    private Date di_date;//发药时间
    private Integer di_flag;//状态标志：0表示已删除不显示，1显示
    private Registrationinfor registrationinfor;
    private Medicine Medicine;
    
    
    
    
    
   	public Dispensing() {
		super();
	}
	public Dispensing(Integer m_id, Integer ri_id, Integer di_counts, Integer di_notcounts) {
		super();
		this.m_id = m_id;
		this.ri_id = ri_id;
		this.di_counts = di_counts;
		this.di_notcounts = di_notcounts;
	}
	public Medicine getMedicine() {
   		return Medicine;
   	}
   	public void setMedicine(Medicine medicine) {
   		Medicine = medicine;
   	}
	public Integer getRi_id() {
		return ri_id;
	}
	public void setRi_id(Integer ri_id) {
		this.ri_id = ri_id;
	}
	public Registrationinfor getRegistrationinfor() {
		return registrationinfor;
	}
	public void setRegistrationinfor(Registrationinfor registrationinfor) {
		this.registrationinfor = registrationinfor;
	}
	public Integer getDi_id() {
		return di_id;
	}
	public void setDi_id(Integer di_id) {
		this.di_id = di_id;
	}
	
	public Integer getM_id() {
		return m_id;
	}
	public void setM_id(Integer m_id) {
		this.m_id = m_id;
	}
	public Integer getDi_counts() {
		return di_counts;
	}
	public void setDi_counts(Integer di_counts) {
		this.di_counts = di_counts;
	}
	public Integer getDi_hascounts() {
		return di_hascounts;
	}
	public void setDi_hascounts(Integer di_hascounts) {
		this.di_hascounts = di_hascounts;
	}
	public Integer getDi_notcounts() {
		return di_notcounts;
	}
	public void setDi_notcounts(Integer di_notcounts) {
		this.di_notcounts = di_notcounts;
	}
	public Date getDi_date() {
		return di_date;
	}
	public void setDi_date(Date di_date) {
		this.di_date = di_date;
	}
	public Integer getDi_flag() {
		return di_flag;
	}
	public void setDi_flag(Integer di_flag) {
		this.di_flag = di_flag;
	}
	@Override
	public String toString() {
		return "Dispensing [di_id=" + di_id + ", di_medicalnum="  + ", m_id=" + m_id + ", di_counts="
				+ di_counts + ", di_hascounts=" + di_hascounts + ", di_notcounts=" + di_notcounts + ", di_time="
				+ di_date + ", di_flag=" + di_flag + "]";
	}
}