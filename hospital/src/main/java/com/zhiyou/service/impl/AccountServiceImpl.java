package com.zhiyou.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhiyou.mapper.AccountMapper;
import com.zhiyou.pojo.Account;
import com.zhiyou.pojo.Condition;
import com.zhiyou.service.AccountService;
@Service

public class AccountServiceImpl implements AccountService {
	@Autowired
	private AccountMapper accountmapper;
	
	@Override
	public List<Account> selectAccountByCondition(Condition condition) {
		List<Account> list = accountmapper.selectAccountByCondition(condition);
		return list;
	}

}
