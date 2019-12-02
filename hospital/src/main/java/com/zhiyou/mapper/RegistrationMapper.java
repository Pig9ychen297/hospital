package com.zhiyou.mapper;

import java.util.ArrayList;
import java.util.List;

import com.zhiyou.pojo.Condition;
import com.zhiyou.pojo.Department;
import com.zhiyou.pojo.Doctor;
import com.zhiyou.pojo.Registrationinfor;

public interface RegistrationMapper {

	public List<Registrationinfor> selectRegistrationByCondition(Condition condition);

	public List<Department> searchAllDepartment();


	public List<Doctor> searchDoctorByDe_id(Integer de_id);

	public int insertRegistration(Registrationinfor registrationinfor);

	public Registrationinfor selectRegistrationDetail(Integer ri_id);

	public int updateRegistration(Registrationinfor registrationinfor);

	public List<Registrationinfor> exportRegistration(ArrayList<Integer> idsList);

	public Integer quitNumber(ArrayList<Integer> idsList);

	public List<Registrationinfor> searchRepetition(ArrayList<Integer> idsList);

}
