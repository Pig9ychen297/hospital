package com.zhiyou.pojo;

public class Chargeitem {
    private Integer ci_id;//收费项目表主键id
    private String ci_name;//收费项目名称
    private Double ci_amount;//应收金额
    private Integer ci_flag;//标志：0表示已删除不显示，1显示
	public Integer getCi_id() {
		return ci_id;
	}
	public void setCi_id(Integer ci_id) {
		this.ci_id = ci_id;
	}
	public String getCi_name() {
		return ci_name;
	}
	public void setCi_name(String ci_name) {
		this.ci_name = ci_name;
	}
	public Double getCi_amount() {
		return ci_amount;
	}
	public void setCi_amount(Double ci_amount) {
		this.ci_amount = ci_amount;
	}
	public Integer getCi_flag() {
		return ci_flag;
	}
	public void setCi_flag(Integer ci_flag) {
		this.ci_flag = ci_flag;
	}
	@Override
	public String toString() {
		return "Chargeitem [ci_id=" + ci_id + ", ci_name=" + ci_name + ", ci_amount=" + ci_amount + ", ci_flag="
				+ ci_flag + "]";
	}
}