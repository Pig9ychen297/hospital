package com.zhiyou.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhiyou.mapper.ChargeManageMapper;
import com.zhiyou.pojo.Chargeitem;
import com.zhiyou.pojo.Chargemanage;
import com.zhiyou.pojo.Condition;
import com.zhiyou.service.ChargeManageService;
@Service
public class ChargeManageServiceImpl implements ChargeManageService {
	
	@Autowired
	private ChargeManageMapper chargeManagemapper;
	@Override
	public List<Chargemanage> selectChargeManageByCondition(Condition condition) {
		List<Chargemanage> list = chargeManagemapper.selectChargeManageByCondition(condition);
		return list;
	}
	@Override
	public List<Chargeitem> searchChargeItem() {
		List<Chargeitem> list = chargeManagemapper.searchChargeItem();
		return list;
	}
	@Override
	public Chargeitem searchPriceByCi_id(Integer ci_id) {
		Chargeitem chargeitem = chargeManagemapper.searchPriceByCi_id(ci_id);
		return chargeitem;
	}
	@Override
	public int addChargeManage(Chargemanage chargemanage) {
		int i = chargeManagemapper.addChargeManage(chargemanage);
		return i;
	}

}
