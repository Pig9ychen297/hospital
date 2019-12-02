package com.zhiyou.mapper;

import java.util.List;

import com.zhiyou.pojo.Chargeitem;
import com.zhiyou.pojo.Chargemanage;
import com.zhiyou.pojo.Condition;

public interface ChargeManageMapper {

	public List<Chargemanage> selectChargeManageByCondition(Condition condition);

	public List<Chargeitem> searchChargeItem();

	public Chargeitem searchPriceByCi_id(Integer ci_id);

	public int addChargeManage(Chargemanage chargemanage);

}
