package com.zhiyou.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhiyou.mapper.UserMapper;
import com.zhiyou.pojo.User;
import com.zhiyou.service.UserService;
@Service
public class UserServiceImpl implements UserService{
	@Autowired
	private UserMapper userMapper;
	
	@Override
	public User selectUserByUsernameAndPassword(User user) {
		return userMapper.selectUserByUsernameAndPassword(user);
	}
	

}
