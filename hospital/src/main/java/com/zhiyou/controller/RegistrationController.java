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
import com.zhiyou.pojo.Department;
import com.zhiyou.pojo.Doctor;
import com.zhiyou.pojo.Registrationinfor;
import com.zhiyou.pojo.Result;
import com.zhiyou.service.RegistrationService;
import com.zhiyou.util.ExcelUtils;

@Controller
@RequestMapping
public class RegistrationController {

	
	@Autowired
	private  RegistrationService  registrationService;
	
	@RequestMapping(value="/selectRegistrationByCondition.do",method={RequestMethod.POST})
	@ResponseBody
	public Result selectRegistrationByCondition(Condition condition){
		System.out.println("进来了");
		System.out.println(condition.getPageNum());
		Result result = null;
		PageHelper.startPage(condition.getPageNum(), 5);
		List<Registrationinfor>  registration_list = registrationService.selectRegistrationByCondition(condition);
		PageInfo<Registrationinfor> pageInfo = new PageInfo<>(registration_list);
		if(registration_list.size()>0){
			result = Result.success(1012, "请求成功",pageInfo);
		}else{
			result =  Result.fail(1011, "没有找到相关信息",pageInfo);
		}
		return result;
	}
	
	//添加页面的加载科室
	@RequestMapping(value="/searchDepartment.do",method={RequestMethod.POST})
	@ResponseBody
	public Result searchAllDepartment(){
		System.out.println("进来了");
		Result result = Result.fail(1020, "请求查询科室列表失败");
		List<Department>  department_list = registrationService.searchAllDepartment();
		if(department_list.size()>0){
			result = Result.success(1021, "请求查询科室列表成功",department_list);
		}
		return result;
	}
	
	//查询响应的医生根据de_id
		@RequestMapping(value="/searchDoctorByDe_id.do",method={RequestMethod.POST})
		@ResponseBody
		public Result searchDoctorByDe_id(Integer de_id){
			System.out.println("进来了");
			Result result = Result.fail(1022, "请求查询医生列表失败");
			List<Doctor>  doctor_list = registrationService.searchDoctorByDe_id(de_id);
			if(doctor_list.size()>0){
				result = Result.success(1023, "请求查询医生列表成功",doctor_list);
			}
			return result;
		}
		
		
		//添加
		@RequestMapping(value="/addRegistration.do",method={RequestMethod.POST})
		@ResponseBody
		public Result addRegistration(Registrationinfor Registrationinfor){
			System.out.println(111111);
		      Result result = Result.fail(1024, "添加挂号信息失败");
		      int i  = registrationService.insertRegistration(Registrationinfor);
		      if(i>0){
					//添加数据成功
					result = Result.success(1025, "添加挂号信息成功");
				}
				return result;
		}
		
		//展示详情
		@RequestMapping(value="/selectRegistrationDetail.do",method={RequestMethod.POST})
		@ResponseBody
		public Result selectRegistrationDetail(Integer ri_id){
			Result result = Result.fail(1026, "请求失败");
			Registrationinfor registrationinfor  = registrationService.selectRegistrationDetail(ri_id);
			if(registrationinfor!=null){
				result = Result.success(1027, "请求信息成功",registrationinfor);
			}
			System.out.println(result);
			return result;
		}
		//编辑
		@RequestMapping(value="/editRegistration.do",method={RequestMethod.POST})
		@ResponseBody
		public Result editRegistration(Registrationinfor registrationinfor){
			System.out.println(77777777);
			Result result = Result.fail(1028, "修改信息失败");

			int i = registrationService.updateRegistration(registrationinfor);
			if(i>0){
				//修改成功
				result = Result.success(1029, "修改信息成功");
			}
			return result;
		}
		
		//导出excel
		@RequestMapping(value="/exportRegistration.do",method={RequestMethod.POST})
		@ResponseBody
		public Result exportRegistration(@RequestParam(value="ids[]")Integer[] ids) throws Exception{
			System.out.println(Arrays.toString(ids));
			Result result = Result.fail(1030, "导出失败");
			ArrayList<Integer> idsList = new ArrayList<>();
			Collections.addAll(idsList, ids);
			String[] titles={"序号","	门诊编号","主治医生","挂号时间","挂号科室","状态"};
			List<Registrationinfor> registrationinfors = registrationService.exportRegistration(idsList);
			if(registrationinfors.size()>0){
				//导出成功
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
				OutputStream os = new FileOutputStream(new File("C:\\Users\\admin\\Desktop\\hospitalResource\\registration"+sdf.format(new Date())+".xls"));
				Workbook wk=ExcelUtils.exportExcel(os, titles);	
				XSSFSheet sheet=(XSSFSheet) wk.getSheet("医生信息");
				System.out.println(sheet);
				for(int i=0;i<registrationinfors.size();i++){
					XSSFRow row = sheet.createRow(i+1);
					row.createCell(0).setCellValue(i+1);
					row.createCell(1).setCellValue(registrationinfors.get(i).getRi_id());
					row.createCell(2).setCellValue(registrationinfors.get(i).getDoctor().getD_name());
					SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
					row.createCell(3).setCellValue(sdf1.format(registrationinfors.get(i).getRi_date()));
					row.createCell(4).setCellValue(registrationinfors.get(i).getDoctor().getDepartment().getDe_name());
					row.createCell(5).setCellValue(registrationinfors.get(i).getRi_state());
				}
				wk.write(os);
				wk.close();
				result = Result.success(1031, "导出成功");
					}
					return result;
				}
		
		//退号
		@RequestMapping(value="/quitNumber.do",method={RequestMethod.POST})
		@ResponseBody
		public Result quitNumber(@RequestParam(value="ids[]")Integer[] ids){
			System.out.println(77777777);
			Result result = Result.fail(1032, "退号失败");
			System.out.println(Arrays.toString(ids));
			ArrayList<Integer> idsList = new ArrayList<>();
			Collections.addAll(idsList, ids);
			int i  = registrationService.quitNumber(idsList);
			if(i>0){
				//修改成功
				result = Result.success(1033, "退号成功");
			}
			return result;
		}
		//退号
		@RequestMapping(value="/repetition.do",method={RequestMethod.POST})
		@ResponseBody
		public Result repetition(@RequestParam(value="ids[]")Integer[] ids){
			Result result = null;
			System.out.println(Arrays.toString(ids));
			ArrayList<Integer> idsList = new ArrayList<>();
			Collections.addAll(idsList, ids);
			List<Registrationinfor> registrationinfors = registrationService.searchRepetition(idsList);
			boolean flag = true;
			for (Registrationinfor registrationinfor : registrationinfors) {
				String state = registrationinfor.getRi_state();
				CharSequence cs="退";
				if(state.contains(cs)){
					flag=false;
				}
			}
			if(flag){
				result = Result.success(1035, "不存在重复操作",flag);
			}else{
			 result = Result.fail(1034, "操作失败，存在重复操作，请确认后重新尝试",flag);
			}
			return result;
		}
}
