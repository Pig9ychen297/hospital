package com.zhiyou.controller;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zhiyou.pojo.Condition;
import com.zhiyou.pojo.Doctor;
import com.zhiyou.pojo.Result;
import com.zhiyou.service.DoctorService;
import com.zhiyou.util.ExcelUtils;

@Controller
@RequestMapping
public class DoctorController {
	
	@Autowired
	private DoctorService doctorService;
	
	@RequestMapping(value="/selectDoctorByCondition.do",method={RequestMethod.POST})
	@ResponseBody
	public Result selectDoctorByCondition(Condition	condition){
		System.out.println("进来了");
		System.out.println(condition.getPageNum());
		Result result =null;
		PageHelper.startPage(condition.getPageNum(), 5);
		List<Doctor> doctor_list = doctorService.selectDoctorByCondition(condition);
		PageInfo<Doctor> pageInfo = new PageInfo<>(doctor_list);
		if(doctor_list.size()>0){
			result = Result.success(1004, "请求成功",pageInfo);
		}else{
			result =  Result.fail(1003, "没有找到相关信息",pageInfo);
		}
		return result;
	}
	
	//添加
	@RequestMapping(value="/addDoctor.do",method={RequestMethod.POST})
	@ResponseBody
	public Result addDoctor(Doctor doctor){
		System.out.println(1111111);
		Result result = Result.fail(1005, "添加医生信息失败");
		int i  = doctorService.insertDoctor(doctor);
		if(i>0){
			//添加数据成功
			result = Result.success(1006, "添加医生信息成功");
		}
		System.out.println(result);
		return result;
	}
	//展示详情
	@RequestMapping(value="/selectDoctorDetail.do",method={RequestMethod.POST})
	@ResponseBody
	public Result selectDoctorDetail(Integer d_id){
		System.out.println(1111111);
		Result result = Result.fail(1007, "请求信息失败");
		Doctor doctor  = doctorService.selectDoctorDetail(d_id);
		if(doctor!=null){
			result = Result.success(1008, "请求信息成功",doctor);
		}
		System.out.println(result);
		return result;
	}
	
	@RequestMapping(value="/editDoctor.do",method={RequestMethod.POST})
	@ResponseBody
	public Result editDoctor(Doctor doctor){
		Result result = Result.fail(1009, "修改信息失败");

		int i = doctorService.updateDoctor(doctor);
		if(i>0){
			//修改成功
			result = Result.success(1010, "修改信息成功");
		}
		return result;
	}
	//导出excel
	@RequestMapping(value="/exportDoctor.do",method={RequestMethod.POST})
	@ResponseBody
	public Result exportDoctor(@RequestParam(value="ids[]")Integer[] ids) throws Exception{
		System.out.println(Arrays.toString(ids));
		Result result = Result.fail(6000, "导出失败");
		ArrayList<Integer> idsList = new ArrayList<>();
		Collections.addAll(idsList, ids);
		String[] titles={"序号","医生编号","科室","医生姓名","入院时间"};
		List<Doctor> doctors = doctorService.exportDoctor(idsList);
		if(doctors.size()>0){
			//导出成功
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
			OutputStream os = new FileOutputStream(new File("C:\\Users\\admin\\Desktop\\hospitalResource\\doctor"+sdf.format(new Date())+".xls"));
			Workbook wk=ExcelUtils.exportExcel(os, titles);	
			XSSFSheet sheet=(XSSFSheet) wk.getSheet("医生信息");
			for(int i=0;i<doctors.size();i++){
				XSSFRow row = sheet.createRow(i+1);
				row.createCell(0).setCellValue(i+1);
				row.createCell(1).setCellValue(doctors.get(i).getD_id());
				row.createCell(2).setCellValue(doctors.get(i).getDepartment().getDe_name());
				row.createCell(3).setCellValue(doctors.get(i).getD_name());
				row.createCell(4).setCellValue(doctors.get(i).getD_date());
			}
			wk.write(os);
			wk.close();
			result = Result.success(1010, "导出成功");
		}
		return result;
	}

}