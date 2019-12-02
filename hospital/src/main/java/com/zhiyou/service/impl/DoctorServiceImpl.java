package com.zhiyou.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhiyou.mapper.DoctorMapper;
import com.zhiyou.pojo.Condition;
import com.zhiyou.pojo.Doctor;
import com.zhiyou.service.DoctorService;
@Service
public class DoctorServiceImpl implements DoctorService{
	@Autowired
	private DoctorMapper doctorMapper;
	
	@Override
	public List<Doctor> selectDoctorByCondition(Condition condition) {
		List<Doctor> doctors = doctorMapper.selectDoctorByCondition(condition);
		return doctors;
	}

	@Override
	public int insertDoctor(Doctor doctor) {
		int i = doctorMapper.insertDoctor(doctor);
		return i;
	}

	@Override
	public Doctor selectDoctorDetail(Integer d_id) {
		Doctor doctor = doctorMapper.selectDoctorDetail(d_id);
		return doctor;
	}

	@Override
	public int updateDoctor(Doctor doctor) {
		int i = doctorMapper.updateDoctor(doctor);
		return i;
	}
	//导出数据
	@Override
	public List<Doctor> exportDoctor(ArrayList<Integer> idsList) {
		
		List<Doctor> list = doctorMapper.exportDoctor(idsList);
		return list;
	}
	
	
}
