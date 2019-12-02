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
import com.zhiyou.pojo.Hospitalinfor;
import com.zhiyou.pojo.Result;
import com.zhiyou.service.HospitalService;
import com.zhiyou.util.ExcelUtils;

@Controller
@RequestMapping
public class HospitalController {
	@Autowired
	private  HospitalService hospitalService;
	
	@RequestMapping(value="/selectHospitalByCondition.do",method={RequestMethod.POST})
	@ResponseBody
	public Result selectHospitalByCondition(Condition condition){
		System.out.println("进来了");
		System.out.println(condition.getPageNum());
		Result result = null;
		PageHelper.startPage(condition.getPageNum(), 5);
		List<Hospitalinfor>  hospitalinfor_list = hospitalService.selectHospitalByCondition(condition);
		PageInfo<Hospitalinfor> pageInfo = new PageInfo<>(hospitalinfor_list);
		if(hospitalinfor_list.size()>0){
			result = Result.success(1012, "请求成功",pageInfo);
		}else{
			result =  Result.fail(1011, "没有找到相关信息",pageInfo);
		}
		return result;
	}
	
	//添加
		@RequestMapping(value="/addHospital.do",method={RequestMethod.POST})
		@ResponseBody
		public Result addHospital(Hospitalinfor hospitalinfor){
			System.out.println(111111);
		      Result result = Result.fail(1024, "添加住院信息失败");
		      int i  = hospitalService.insertHospital(hospitalinfor);
		      if(i>0){
					//添加数据成功
					result = Result.success(1025, "添加住院信息成功");
				}
				return result;
		}
		
//		床号是否重复
		@RequestMapping(value="/searchHospitalInfoByhi_bedno.do",method={RequestMethod.POST})
		@ResponseBody
		public Result searchHospitalInfoByhi_bedno(Integer hi_bedno){
			System.out.println(111111);
			Result result = null;
	        Hospitalinfor hospitalinfor  = hospitalService.searchHospitalInfoByhi_bedno(hi_bedno);
	        if(hospitalinfor!=null){
	    	   result = Result.fail(1024, "此床号非空闲状态，请核对后重试");	
		    }else{
			  result = Result.success(1025, "床号空闲，可以使用");
			}
			return result;
	}
		//展示详情
		@RequestMapping(value="/selectHospitalDetail.do",method={RequestMethod.POST})
		@ResponseBody
		public Result selectHospitalDetail(Integer hi_id){
			Result result = Result.fail(1026, "请求失败");
			Hospitalinfor hospitalinfor  = hospitalService.selectHospitalDetail(hi_id);
			if(hospitalinfor!=null){
				result = Result.success(1027, "请求信息成功",hospitalinfor);
			}
			System.out.println(result);
			return result;
		}
		//编辑
		@RequestMapping(value="/editHospital.do",method={RequestMethod.POST})
		@ResponseBody
		public Result editHospital(Hospitalinfor hospitalinfor){
			System.out.println(77777777);
			Result result = Result.fail(1028, "修改信息失败");
			int i = hospitalService.editHospital(hospitalinfor);
			System.out.println(i);
			if(i>0){
				//修改成功
				result = Result.success(1029, "修改信息成功");
			}
			return result;
		}
		//导出excel
		@RequestMapping(value="/exportHospital.do",method={RequestMethod.POST})
		@ResponseBody
		public Result exportHospital(@RequestParam(value="ids[]")Integer[] ids) throws Exception{
			System.out.println(Arrays.toString(ids));
			Result result = Result.fail(1030, "导出失败");
			ArrayList<Integer> idsList = new ArrayList<>();
			Collections.addAll(idsList, ids);
			String[] titles={"序号","病历号","姓名","床位号","联系电话","押金","主治医生","入院时间","科室","状态"};
			List<Hospitalinfor> hospitalinfors = hospitalService.exportHospital(idsList);
			if(hospitalinfors.size()>0){
				//导出成功
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
				OutputStream os = new FileOutputStream(new File("C:\\Users\\admin\\Desktop\\hospitalResource\\hospital"+sdf.format(new Date())+".xls"));
				Workbook wk=ExcelUtils.exportExcel(os, titles);	
				XSSFSheet sheet=(XSSFSheet) wk.getSheet("医生信息");
				System.out.println(sheet);
				for(int i=0;i<hospitalinfors.size();i++){
					XSSFRow row = sheet.createRow(i+1);
					row.createCell(0).setCellValue(i+1);
					row.createCell(1).setCellValue(hospitalinfors.get(i).getRi_id());
					row.createCell(2).setCellValue(hospitalinfors.get(i).getRegistrationinfor().getRi_name());
					row.createCell(3).setCellValue(hospitalinfors.get(i).getHi_bedno());
					row.createCell(4).setCellValue(hospitalinfors.get(i).getRegistrationinfor().getRi_phone());
					row.createCell(5).setCellValue(hospitalinfors.get(i).getHi_cashpledge());
					row.createCell(6).setCellValue(hospitalinfors.get(i).getRegistrationinfor().getDoctor().getD_name());
					SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:dd");
					row.createCell(7).setCellValue(sdf1.format(hospitalinfors.get(i).getHi_date()));
					row.createCell(8).setCellValue(hospitalinfors.get(i).getRegistrationinfor().getDoctor().getDepartment().getDe_name());
					row.createCell(9).setCellValue(hospitalinfors.get(i).getHi_state());
				}
				wk.write(os);
				wk.close();
				result = Result.success(1031, "导出成功");
					}
					return result;
				}
}
