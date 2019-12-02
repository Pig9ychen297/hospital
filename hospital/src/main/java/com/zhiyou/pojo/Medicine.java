package com.zhiyou.pojo;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Medicine {
    private Integer m_id;//药品主键id
    private String m_number;//药品编号
    private String m_image_addr;//药品图片地址
    private Double m_purchase;//药品进价
    private Double m_selling;//药品售价
    private String m_name;//药品名称
    private String m_type;//药品类型
    private String m_description;//药品简单描述
    @JsonFormat(pattern="yyyy-MM-dd",timezone="GMT+8")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date m_product_date;//药品生产日期
    @JsonFormat(pattern="yyyy-MM-dd",timezone="GMT+8")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date m_expiration_date;//药品过期日期
    private Integer m_quality_date;//保质期
    private String m_detail;//药品详细描述
    private String m_productor;//生产厂商
    private String m_direction;//服用说明
    private Integer m_total_purchase;//总的进货量
    private Integer m_residue;//剩余量
    private String m_state;//状态
    private Integer m_flag;//标志：0表示已删除不显示，1显示
    private String m_remark;//备注
    private MultipartFile file;
    
   
	public MultipartFile getFile() {
		return file;
	}
	public void setFile(MultipartFile file) {
		this.file = file;
	}
	public Integer getM_id() {
		return m_id;
	}
	public void setM_id(Integer m_id) {
		this.m_id = m_id;
	}
	public String getM_number() {
		return m_number;
	}
	public void setM_number(String m_number) {
		this.m_number = m_number;
	}
	public String getM_image_addr() {
		return m_image_addr;
	}
	public void setM_image_addr(String m_image_addr) {
		this.m_image_addr = m_image_addr;
	}
	public Double getM_purchase() {
		return m_purchase;
	}
	public void setM_purchase(Double m_purchase) {
		this.m_purchase = m_purchase;
	}
	public Double getM_selling() {
		return m_selling;
	}
	public void setM_selling(Double m_selling) {
		this.m_selling = m_selling;
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
	public String getM_description() {
		return m_description;
	}
	public void setM_description(String m_description) {
		this.m_description = m_description;
	}
	public Date getM_product_date() {
		return m_product_date;
	}
	public void setM_product_date(Date m_product_date) {
		this.m_product_date = m_product_date;
	}
	public Date getM_expiration_date() {
		return m_expiration_date;
	}
	public void setM_expiration_date(Date m_expiration_date) {
		this.m_expiration_date = m_expiration_date;
	}
	public Integer getM_quality_date() {
		return m_quality_date;
	}
	public void setM_quality_date(Integer m_quality_date) {
		this.m_quality_date = m_quality_date;
	}
	public String getM_detail() {
		return m_detail;
	}
	public void setM_detail(String m_detail) {
		this.m_detail = m_detail;
	}
	public String getM_productor() {
		return m_productor;
	}
	public void setM_productor(String m_productor) {
		this.m_productor = m_productor;
	}
	public String getM_direction() {
		return m_direction;
	}
	public void setM_direction(String m_direction) {
		this.m_direction = m_direction;
	}
	public Integer getM_total_purchase() {
		return m_total_purchase;
	}
	public void setM_total_purchase(Integer m_total_purchase) {
		this.m_total_purchase = m_total_purchase;
	}
	public Integer getM_residue() {
		return m_residue;
	}
	public void setM_residue(Integer m_residue) {
		this.m_residue = m_residue;
	}
	public Integer getM_flag() {
		return m_flag;
	}
	public void setM_flag(Integer m_flag) {
		this.m_flag = m_flag;
	}
	public String getM_remark() {
		return m_remark;
	}
	public void setM_remark(String m_remark) {
		this.m_remark = m_remark;
	}
	
	public String getM_state() {
		return m_state;
	}
	public void setM_state(String m_state) {
		this.m_state = m_state;
	}
	@Override
	public String toString() {
		return "Medicine [m_id=" + m_id + ", m_number=" + m_number + ", m_image_addr=" + m_image_addr + ", m_purchase="
				+ m_purchase + ", m_selling=" + m_selling + ", m_name=" + m_name + ", m_type=" + m_type
				+ ", m_description=" + m_description + ", m_product_date=" + m_product_date + ", m_expiration_date="
				+ m_expiration_date + ", m_quality_date=" + m_quality_date + ", m_detail=" + m_detail + ", m_productor="
				+ m_productor + ", m_direction=" + m_direction + ", m_total_purchase=" + m_total_purchase
				+ ", m_residue=" + m_residue + ", m_flag=" + m_flag + ", m_remark=" + m_remark + "]";
	}
}