package com.zhiyou.service;

import java.util.ArrayList;
import java.util.List;

import com.zhiyou.pojo.Condition;
import com.zhiyou.pojo.Doctor;

public interface DoctorService {
	/**
	 * 根据doctor的条件 查询医生 默认查询所有
	 * @param condition 根据doctor的条件 查询医生
	 * @return 可能有医生 可能 null
	 */
	public List<Doctor> selectDoctorByCondition(Condition condition);
	/**
	 * 根据传入的医生参数 添加医生信息
	 * @param doctor 传入的医生参数
	 * @return	返回数据库受影响行数
	 */
	public int insertDoctor(Doctor doctor);
	/**
	 *  根据d_id 查询doctor
	 * @param d_id 
	 * @return  返回 Doctor 或者null
	 */
	public Doctor selectDoctorDetail(Integer d_id);
	/**
	 * 
	 * @param doctor 根据用户传递的信息修改数据
	 * @return 返回数据库受影响的行数
	 */
	public int updateDoctor(Doctor doctor);
	/**
	 * 
	 * @param idsList 页面传递的ids
	 * @return 返回一个List<Doctor> 或者null
	 */
	public List<Doctor> exportDoctor(ArrayList<Integer> idsList);
	
}
