package com.zhiyou.service;

import java.util.ArrayList;
import java.util.List;

import com.zhiyou.pojo.Condition;
import com.zhiyou.pojo.Medicine;

public interface MedicineService {
	/**
	 * 通过前台的条件传递 查询
	 * @param condition 前台的传递的条件
	 * @return 返回一个list  或者null
	 */
	public List<Medicine> selectMedicineByCondition(Condition condition);
	/**
	 * 
	 * @param medicine  添加一个医生信息
	 * @return	 返回受影响的行数
	 */
	public int insertMedicine(Medicine medicine);
	/**
	 * 
	 * @param m_id  根据id查询药品
	 * @return 返回一个Medicine对象  或者null
	 */
	public Medicine selectMedicineDetail(Integer m_id);
	/**
	 * 
	 * @param idsList  根据id列表查询相应 的药品信息
	 * @return 返回药品对象集合 或者null；
	 */
	public List<Medicine> exportMedicine(ArrayList<Integer> idsList);

}
