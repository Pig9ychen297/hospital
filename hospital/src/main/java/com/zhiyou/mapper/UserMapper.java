package com.zhiyou.mapper;

import com.zhiyou.pojo.User;

public interface UserMapper {
	
	public User selectUserByUsernameAndPassword(User user);

}
