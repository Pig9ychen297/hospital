package com.zhiyou.service;

import java.util.List;

import com.zhiyou.pojo.Chargeitem;
import com.zhiyou.pojo.Chargemanage;
import com.zhiyou.pojo.Condition;

public interface ChargeManageService {
	/**
	 * 
	 * @param condition 传递的条件
	 * @return 返回一个实体类list  或者null
	 */
	public List<Chargemanage> selectChargeManageByCondition(Condition condition);
	/**
	 * 查询所有的收费项目
	 * @return 返回收费项目list
	 * 或者返回null
	 */
	public List<Chargeitem> searchChargeItem();
	/**
	 * 根据ci_id 查询对应的项目价格
	 * @return 返回一个对象封装了价格
	 */
	public Chargeitem searchPriceByCi_id(Integer ci_id);
	/**
	 * 添加
	 * @param chargemanage
	 * @return
	 */
	public int addChargeManage(Chargemanage chargemanage);

}
