package com.zhiyou.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhiyou.mapper.DispensingMapper;
import com.zhiyou.pojo.Condition;
import com.zhiyou.pojo.Dispensing;
import com.zhiyou.pojo.Medicine;
import com.zhiyou.pojo.Registrationinfor;
import com.zhiyou.service.DispensingService;
@Service
public class DispensingServiceImpl implements DispensingService {
	
	@Autowired 
	private DispensingMapper dispensingMapper;
	
	
	@Override
	public List<Dispensing> selectDispensingByCondition(Condition condition) {
		List<Dispensing> list = dispensingMapper.selectDispensingByCondition(condition);
		return list;
	}


	@Override
	public Dispensing selectDispensingByDi_id(Integer di_id) {
		Dispensing dispensing = dispensingMapper.selectDispensingByDi_id(di_id);
		return dispensing;
	}


	@Override
	public int dispensing(Condition condition) {
		int i = dispensingMapper.dispensing(condition);
		return i;
	}


	@Override
	public List<Registrationinfor> dispensingAll(ArrayList<Integer> idsList) {
		List<Registrationinfor> list = dispensingMapper.dispensingAll(idsList);
		return list;
	}


	@Override
	public List<Medicine> searchAllMedicine() {
		List<Medicine> list = dispensingMapper.searchAllMedicine();
		return list;
	}


	@Override
	public int addDispensing(List<Dispensing> dispensing_list) {
		int i = dispensingMapper.addDispensing(dispensing_list);
		return i;
	}


	@Override
	public List<Dispensing> searchRepetitionInfo(ArrayList<Integer> idsList) {
		List<Dispensing> list= dispensingMapper.searchRepetitionInfo(idsList);
		return list;
	}


	@Override
	public int updateDispensingByDi_id(Integer di_id) {
		int i = dispensingMapper.updateDispensingByDi_id(di_id);
		return i;
	}

}
