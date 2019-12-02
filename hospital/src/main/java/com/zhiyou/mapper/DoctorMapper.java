package com.zhiyou.mapper;

import java.util.ArrayList;
import java.util.List;

import com.zhiyou.pojo.Condition;
import com.zhiyou.pojo.Doctor;

public interface DoctorMapper {
	
	

	public List<Doctor> selectDoctorByCondition(Condition condition);
	
	public int insertDoctor(Doctor doctor);

	public Doctor selectDoctorDetail(Integer d_id);

	public int updateDoctor(Doctor doctor);

	public List<Doctor> exportDoctor(ArrayList<Integer> idsList);
	
}
