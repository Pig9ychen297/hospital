package com.zhiyou.pojo;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Condition {
	private String d_id; //医生编号
	private String d_name; //医生姓名
	private String de_name;	//科室姓名
	private String ri_no;//病历号
	private String ri_name;//姓名
	private String m_name;//药品名
	private String m_type;//药品类型
	private int di_id;
	@JsonFormat(pattern="yyyy-MM-dd",timezone="GMT+8")
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date beginTime;
	@JsonFormat(pattern="yyyy-MM-dd",timezone="GMT+8")
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date endTime;
	private int pageNum;//当前页码
	private int num;
	
	private int[] ids;
	private int m_id;
	private int di_counts;
	
	
	
	public int getM_id() {
		return m_id;
	}
	public void setM_id(int m_id) {
		this.m_id = m_id;
	}
	public int getDi_counts() {
		return di_counts;
	}
	public void setDi_counts(int di_counts) {
		this.di_counts = di_counts;
	}
	public int[] getIds() {
		return ids;
	}
	public void setIds(int[] ids) {
		this.ids = ids;
	}
	public int getDi_id() {
		return di_id;
	}
	public void setDi_id(int di_id) {
		this.di_id = di_id;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getRi_no() {
		return ri_no;
	}
	public void setRi_no(String ri_no) {
		this.ri_no = ri_no;
	}
	
	public Date getBeginTime() {
		return beginTime;
	}
	public void setBeginTime(Date beginTime) {
		this.beginTime = beginTime;
	}
	public Date getEndTime() {
		return endTime;
	}
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
	public String getD_id() {
		return d_id;
	}
	public void setD_id(String d_id) {
		this.d_id = d_id;
	}
	public String getD_name() {
		return d_name;
	}
	public void setD_name(String d_name) {
		this.d_name = d_name;
	}
	public String getDe_name() {
		return de_name;
	}
	public void setDe_name(String de_name) {
		this.de_name = de_name;
	}

	public String getRi_name() {
		return ri_name;
	}
	public void setRi_name(String ri_name) {
		this.ri_name = ri_name;
	}
	public String getM_name() {
		return m_name;
	}
	public void setM_name(String m_name) {
		this.m_name = m_name;
	}
	public String getM_type() {
		return m_type;
	}
	public void setM_type(String m_type) {
		this.m_type = m_type;
	}
	
	public int getPageNum() {
		return pageNum;
	}
	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}
	@Override
	public String toString() {
		return "Condition [d_id=" + d_id + ", d_name=" + d_name + ", de_name=" + de_name + ", ri_no=" + ri_no
				+ ", ri_name=" + ri_name + ", m_name=" + m_name + ", m_type=" + m_type + ", pageNum=" + pageNum + "]";
	}
	
	
	
}
