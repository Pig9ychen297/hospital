package com.zhiyou.pojo;

import java.util.Date;

public class User {
    private int u_id;//用户id
    private String u_username;//用户�?
    private String u_password;//密码
    public Date u_creat_time;//创建时间
	public int getU_id() {
		return u_id;
	}
	public void setU_id(int u_id) {
		this.u_id = u_id;
	}
	public String getU_username() {
		return u_username;
	}
	public void setU_username(String u_username) {
		this.u_username = u_username;
	}
	public String getU_password() {
		return u_password;
	}
	public void setU_password(String u_password) {
		this.u_password = u_password;
	}
	public Date getU_creat_time() {
		return u_creat_time;
	}
	public void setU_creat_time(Date u_creat_time) {
		this.u_creat_time = u_creat_time;
	}
	@Override
	public String toString() {
		return "Users [u_id=" + u_id + ", u_username=" + u_username + ", u_password=" + u_password + ", u_creat_time="
				+ u_creat_time + "]";
	}
}