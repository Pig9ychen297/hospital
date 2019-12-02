package com.zhiyou.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zhiyou.pojo.Account;
import com.zhiyou.pojo.Condition;
import com.zhiyou.pojo.Result;
import com.zhiyou.service.AccountService;

@Controller
@RequestMapping
public class AccountController {
	@Autowired
	private  AccountService accountService;
	
	@RequestMapping(value="/selectAccountByCondition.do",method={RequestMethod.POST})
	@ResponseBody
	public Result selectAccountByCondition(Condition condition){
		System.out.println("进来了");
		System.out.println(condition.getPageNum());
		Result result = null;
		PageHelper.startPage(condition.getPageNum(), 5);
		List<Account> account_list = accountService.selectAccountByCondition(condition);
		PageInfo<Account> pageInfo = new PageInfo<>(account_list);
		if(account_list.size()>0){
			result = Result.success(1012, "请求成功",pageInfo);
		}else{
			result =  Result.fail(1011, "没有找到相关信息",pageInfo);
		}
		return result;
	}
}
