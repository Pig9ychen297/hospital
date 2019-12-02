package com.zhiyou.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhiyou.mapper.HospitalMapper;
import com.zhiyou.pojo.Condition;
import com.zhiyou.pojo.Hospitalinfor;
import com.zhiyou.service.HospitalService;
@Service
public class HospitalServiceImpl implements HospitalService {
	
	@Autowired 
	private HospitalMapper hospitalMapper;
	
	@Override
	public List<Hospitalinfor> selectHospitalByCondition(Condition condition) {
		 List<Hospitalinfor> list = hospitalMapper.selectHospitalByCondition(condition);
		return list;
	}

	@Override
	public int insertHospital(Hospitalinfor hospitalinfor) {
		int i = hospitalMapper.insertHospital(hospitalinfor);
		return i;
	}

	@Override
	public Hospitalinfor searchHospitalInfoByhi_bedno(Integer hi_bedno) {
		Hospitalinfor hospitalinfor = hospitalMapper.searchHospitalInfoByhi_bedno(hi_bedno);
		return hospitalinfor;
	}

	@Override
	public Hospitalinfor selectHospitalDetail(Integer hi_id) {
		Hospitalinfor hospitalinfor = hospitalMapper.selectHospitalDetail(hi_id);
		return hospitalinfor;
	}

	@Override
	public int editHospital(Hospitalinfor hospitalinfor) {
		int i = hospitalMapper.editHospital(hospitalinfor);
		return i;
	}

	@Override
	public List<Hospitalinfor> exportHospital(ArrayList<Integer> idsList) {
		 List<Hospitalinfor> list = hospitalMapper.exportHospital(idsList);
		return list;
	}

}
