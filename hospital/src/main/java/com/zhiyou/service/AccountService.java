package com.zhiyou.service;

import java.util.List;

import com.zhiyou.pojo.Account;
import com.zhiyou.pojo.Condition;

public interface AccountService {
	/**
	 * 分页显示结算表
	 * @param condition
	 * @return
	 */
	public List<Account> selectAccountByCondition(Condition condition);

}
