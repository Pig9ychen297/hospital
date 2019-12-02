package com.zhiyou.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhiyou.mapper.MedicineMapper;
import com.zhiyou.pojo.Condition;
import com.zhiyou.pojo.Medicine;
import com.zhiyou.service.MedicineService;
@Service
public class MedicineServiceImpl implements MedicineService {

	@Autowired
	private MedicineMapper medicineMapper;
	
	@Override
	public List<Medicine> selectMedicineByCondition(Condition condition) {
		List<Medicine> list = medicineMapper.selectMedicineByCondition(condition);
		return list;
	}

	@Override
	public int insertMedicine(Medicine medicine) {
		int i = medicineMapper.insertMedicine(medicine);
		return i;
	}

	@Override
	public Medicine selectMedicineDetail(Integer m_id) {
		Medicine medicine = medicineMapper.selectMedicineDetail(m_id);
		return medicine;
	}

	@Override
	public List<Medicine> exportMedicine(ArrayList<Integer> idsList) {
		 List<Medicine> list = medicineMapper.exportMedicine(idsList);
		return list;
	}

}
