package com.zhiyou.service;

import com.zhiyou.pojo.User;

public interface UserService {
	/**
	 * 根据用户名帐号密码判断是否能登录
	 * @param user 用户传送的username password
	 * @return  返回user 或者 null
	 */
	public User selectUserByUsernameAndPassword(User user);

}
