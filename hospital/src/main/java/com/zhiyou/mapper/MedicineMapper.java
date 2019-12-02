package com.zhiyou.mapper;

import java.util.ArrayList;
import java.util.List;

import com.zhiyou.pojo.Condition;
import com.zhiyou.pojo.Medicine;

public interface MedicineMapper {
	
	public List<Medicine> selectMedicineByCondition(Condition condition);

	public int insertMedicine(Medicine medicine);

	public Medicine selectMedicineDetail(Integer m_id);

	public List<Medicine> exportMedicine(ArrayList<Integer> idsList);

}
