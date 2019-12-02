package com.zhiyou.mapper;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.zhiyou.pojo.Condition;
import com.zhiyou.pojo.Dispensing;
import com.zhiyou.pojo.Medicine;
import com.zhiyou.pojo.Registrationinfor;

public interface DispensingMapper {

	public List<Dispensing> selectDispensingByCondition(Condition condition);

	public Dispensing selectDispensingByDi_id(Integer di_id);

	public int dispensing(Condition condition);

	public List<Registrationinfor> dispensingAll(ArrayList<Integer> idsList);

	public List<Medicine> searchAllMedicine();

	public int addDispensing(@Param("dispensing_list")List<Dispensing> dispensing_list);

	public List<Dispensing> searchRepetitionInfo(ArrayList<Integer> idsList);

	public int updateDispensingByDi_id(Integer di_id);


}
