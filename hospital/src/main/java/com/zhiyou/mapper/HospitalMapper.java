package com.zhiyou.mapper;

import java.util.ArrayList;
import java.util.List;

import com.zhiyou.pojo.Condition;
import com.zhiyou.pojo.Hospitalinfor;

public interface HospitalMapper {

	public List<Hospitalinfor> selectHospitalByCondition(Condition condition);
	
	public int insertHospital(Hospitalinfor hospitalinfor);

	public Hospitalinfor searchHospitalInfoByhi_bedno(Integer hi_bedno);

	public Hospitalinfor selectHospitalDetail(Integer hi_id);

	public int editHospital(Hospitalinfor hospitalinfor);

	public List<Hospitalinfor> exportHospital(ArrayList<Integer> idsList);

}
