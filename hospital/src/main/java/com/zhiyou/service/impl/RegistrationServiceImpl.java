package com.zhiyou.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhiyou.mapper.RegistrationMapper;
import com.zhiyou.pojo.Condition;
import com.zhiyou.pojo.Department;
import com.zhiyou.pojo.Doctor;
import com.zhiyou.pojo.Registrationinfor;
import com.zhiyou.service.RegistrationService;
@Service
public class RegistrationServiceImpl implements RegistrationService {
	
	@Autowired
	private RegistrationMapper registrationMapper;
	
	@Override
	public List<Registrationinfor> selectRegistrationByCondition(Condition condition) {
		 List<Registrationinfor> list = registrationMapper.selectRegistrationByCondition(condition);
		return list;
	}

	@Override
	public List<Department> searchAllDepartment() {
		List<Department> list = registrationMapper.searchAllDepartment();
		return list;
	}

	@Override
	public List<Doctor> searchDoctorByDe_id(Integer de_id) {
		 List<Doctor> list = registrationMapper.searchDoctorByDe_id(de_id);
		return list;
	}

	@Override
	public int insertRegistration(Registrationinfor registrationinfor) {
		int i = registrationMapper.insertRegistration(registrationinfor);
		return i;
	}

	@Override
	public Registrationinfor selectRegistrationDetail(Integer ri_id) {
		Registrationinfor registrationinfor = registrationMapper.selectRegistrationDetail(ri_id);
		return registrationinfor;
	}

	@Override
	public int updateRegistration(Registrationinfor registrationinfor) {
		int i = registrationMapper.updateRegistration(registrationinfor);
		return i;
	}

	@Override
	public List<Registrationinfor> exportRegistration(ArrayList<Integer> idsList) {
		List<Registrationinfor> list = registrationMapper.exportRegistration(idsList);
		return list;
	}

	@Override
	public int quitNumber(ArrayList<Integer> idsList) {
		 Integer i = registrationMapper.quitNumber(idsList);
		return i;
	}

	@Override
	public List<Registrationinfor> searchRepetition(ArrayList<Integer> idsList) {
		List<Registrationinfor> list = registrationMapper.searchRepetition(idsList);
		return list;
	}

}
