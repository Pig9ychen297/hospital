package com.zhiyou.service;

import java.util.ArrayList;
import java.util.List;

import com.zhiyou.pojo.Condition;
import com.zhiyou.pojo.Department;
import com.zhiyou.pojo.Doctor;
import com.zhiyou.pojo.Registrationinfor;

public interface RegistrationService {
	/**
	 * 
	 * @param condition 通过条件查询挂号信息
	 * @return 返回一个集合 或者null
	 * 
	 */
	public List<Registrationinfor> selectRegistrationByCondition(Condition condition);
	/**
	 * 
	 * @param de_id 
	 * @return 查询所有的科室信息
	 */
	public List<Department> searchAllDepartment();
	/**
	 *  根据de_id 查询相应 的医生列表
	 * @return  返回医生列表 或者null
	 */
	public List<Doctor> searchDoctorByDe_id(Integer de_id);
	/**
	 * 
	 * @param registrationinfor  前端传递的挂号信息数据
	 * @return 返回数据库受影响行数
	 */
	public int insertRegistration(Registrationinfor registrationinfor);
	/**
	 * 
	 * @param ri_id  根据ri_id查询 详情
	 * @return 返回Registrationinfor 对象  或者null
	 */
	public Registrationinfor selectRegistrationDetail(Integer ri_id);
	/**
	 * 
	 * @param registrationinfor 编辑  函数
	 * @return 返回受影响的行数
	 */
	public int updateRegistration(Registrationinfor registrationinfor);
	/**
	 * 
	 * @param idsList 通过idslist获得相应的 挂号列表信息
	 * @return
	 */
	public List<Registrationinfor> exportRegistration(ArrayList<Integer> idsList);
	/**
	 * 
	 * @param idsList  通过idslist 修改项相应的状态字段相应的 挂号列表信息
	 * @return
	 */
	public int quitNumber(ArrayList<Integer> idsList);
	/**
	 * 
	 * @param idsList
	 * @return
	 */
	public List<Registrationinfor> searchRepetition(ArrayList<Integer> idsList);

}
