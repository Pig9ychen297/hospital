package com.zhiyou.service;

import java.util.ArrayList;
import java.util.List;

import com.zhiyou.pojo.Condition;
import com.zhiyou.pojo.Hospitalinfor;

public interface HospitalService {
	/**
	 *  首页 分页查询住院信息
	 * @param condition  页面传递的条件 
	 * @return 返回住院信息list  或者null
	 */
	public List<Hospitalinfor> selectHospitalByCondition(Condition condition);
	/**
	 *  添加住院信息
	 * @param hospitalinfor
	 * @return 返回数据库受影响行数
	 */
	public int insertHospital(Hospitalinfor hospitalinfor);
	/**
	 * 检查床号是否空闲 空闲则可以使用 否则不能使用
	 * @param hi_bedno  前端页面传递的床号信息
	 * @return 返回是实体类对象 根据对象是否存在判断床号是否使用
	 */
	public Hospitalinfor searchHospitalInfoByhi_bedno(Integer hi_bedno);
	/**
	 *  详情页展示详情
	 * @param hi_id  页面传递的住院表主键 
	 * @return 返回一个住院实体类
	 */
	public Hospitalinfor selectHospitalDetail(Integer hi_id);
	/**
	 *  修改住院信息
	 * @param registrationinfor 页面传递的信息  
	 * @return 返回数据库受影响行数
	 */
	public int editHospital(Hospitalinfor hospitalinfor);
	/**
	 * 
	 * @param idsList 导出excel
	 * @return
	 */
	public List<Hospitalinfor> exportHospital(ArrayList<Integer> idsList);
	
}
