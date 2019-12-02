package com.zhiyou.service;

import java.util.ArrayList;
import java.util.List;

import com.zhiyou.pojo.Condition;
import com.zhiyou.pojo.Dispensing;
import com.zhiyou.pojo.Medicine;
import com.zhiyou.pojo.Registrationinfor;

public interface DispensingService {
	/**
	 * 条件查询分页显示
	 * @param condition  页面传递的条件 
	 * @return 返回一个list 或者null
	 */
	public List<Dispensing> selectDispensingByCondition(Condition condition);

	public Dispensing selectDispensingByDi_id(Integer di_id);

	public int dispensing(Condition condition);
	
	public List<Registrationinfor> dispensingAll(ArrayList<Integer> idsList);
	/**
	 * 查询药品下拉列表
	 * @return
	 */
	public List<Medicine> searchAllMedicine();

	public int addDispensing(List<Dispensing> dispensing_list);
	/**
	 *  发药之前 查询是否存在相关数据 存在则不允许添加
	 * @param idsList
	 * @return 返回 list  或者 null
	 */
	public List<Dispensing> searchRepetitionInfo(ArrayList<Integer> idsList);
	/**
	 * 如果药品发放完毕 那么在主页面不显示 在详情页显示一次
	 * @param di_id
	 * @return 
	 */
	public int updateDispensingByDi_id(Integer di_id);


}
