package com.zhiyou.mapper;

import java.util.List;

import com.zhiyou.pojo.Account;
import com.zhiyou.pojo.Condition;

public interface AccountMapper {

	public List<Account> selectAccountByCondition(Condition condition);

}
