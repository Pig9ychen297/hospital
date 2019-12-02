package com.zhiyou.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zhiyou.pojo.Chargeitem;
import com.zhiyou.pojo.Chargemanage;
import com.zhiyou.pojo.Condition;
import com.zhiyou.pojo.Result;
import com.zhiyou.service.ChargeManageService;

@Controller
@RequestMapping
public class ChargeManageController {

	
	@Autowired
	private  ChargeManageService chargeManageService;
	
	@RequestMapping(value="/selectChargeManageByCondition.do",method={RequestMethod.POST})
	@ResponseBody
	public Result selectHospitalByCondition(Condition condition){
		System.out.println("进来了");
		System.out.println(condition.getPageNum());
		Result result = null;
		PageHelper.startPage(condition.getPageNum(), 5);
		List<Chargemanage>  chargemanage_list = chargeManageService.selectChargeManageByCondition(condition);
		PageInfo<Chargemanage> pageInfo = new PageInfo<>(chargemanage_list);
		if(chargemanage_list.size()>0){
			result = Result.success(1012, "请求成功",pageInfo);
		}else{
			result =  Result.fail(1011, "没有找到相关信息",pageInfo);
		}
		return result;
	}
	@RequestMapping(value="/searchChargeItem.do",method={RequestMethod.POST})
	@ResponseBody
	public Result searchChargeItem(){
		Result result = null;
		List<Chargeitem>  chargeitem_list = chargeManageService.searchChargeItem();
		if(chargeitem_list.size()>0){
			result = Result.success(1012, "请求成功",chargeitem_list);
		}else{
			result =  Result.fail(1011, "没有找到相关信息",chargeitem_list);
		}
		return result;
	}
	@RequestMapping(value="/searchPriceByCi_id.do",method={RequestMethod.POST})
	@ResponseBody
	public Result searchPriceByCi_id(Integer ci_id){
		Result result = null;
		Chargeitem chargeitem = chargeManageService.searchPriceByCi_id(ci_id);
		if(chargeitem != null){
			result = Result.success(1012, "请求成功",chargeitem);
		}else{
			result =  Result.fail(1011, "没有找到相关信息",chargeitem);
		}
		return result;
	}
	@RequestMapping(value="/addChargeManage.do",method={RequestMethod.POST})
	@ResponseBody
	public Result addChargeManage(Chargemanage chargemanage){
		Result result = null;
		int i = chargeManageService.addChargeManage(chargemanage);
		if(i>0){
			result = Result.success(1012, "请求成功");
		}else{
			result =  Result.fail(1011, "没有找到相关信息");
		}
		return result;
	}
}
