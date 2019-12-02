package com.zhiyou.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.IOUtils;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zhiyou.pojo.Condition;
import com.zhiyou.pojo.Medicine;
import com.zhiyou.pojo.Result;
import com.zhiyou.service.MedicineService;
import com.zhiyou.util.CsvUtils;
import com.zhiyou.util.ExcelUtils;

@Controller
@RequestMapping
public class MedicineController {
	
	@Autowired
	private  MedicineService  medicineService;
	
	@RequestMapping(value="/selectMedicineByCondition.do",method={RequestMethod.POST})
	@ResponseBody
	public Result selectMedicineByCondition(Condition condition){
		System.out.println("进来了");
		System.out.println(condition.getPageNum());
		Result result =null;
		PageHelper.startPage(condition.getPageNum(), 5);
		List<Medicine> medicine_list = medicineService.selectMedicineByCondition(condition);
		PageInfo<Medicine> pageInfo = new PageInfo<>(medicine_list);
		if(medicine_list.size()>0){
			result = Result.success(1012, "请求成功",pageInfo);
		}else{
			result =  Result.fail(1011, "没有找到相关信息",pageInfo);
		}
		return result;
	}
	
	//添加
		@RequestMapping(value="/addMedicine.do",method={RequestMethod.POST})
		@ResponseBody
		public Result addDoctor(Medicine medicine){
			System.out.println(111111);
		      Result result = Result.fail(1015, "添加药品信息失败");
		      int i  = medicineService.insertMedicine(medicine);
		      if(i>0){
					//添加数据成功
					result = Result.success(1016, "添加药品信息成功");
				}
				return result;
		}
		
	public String getFileName(String fileName){
		//使用工具类获取文件的后缀名
		String extension=FilenameUtils.getExtension(fileName);
		//使用uuid和当前日期的毫秒数来作为文件的名字
		String finalname = UUID.randomUUID().toString()+new Date().getTime()+"."+extension;
		return finalname;
	}
	@RequestMapping(value="/imageUpLoad.do",method={RequestMethod.POST,RequestMethod.GET})
	@ResponseBody
	public Result upload(MultipartFile imageFileObj,HttpServletRequest request) throws IOException{
//		创建一个图片文件的输入流
		Result result = Result.fail(1013,"上传图片失败");
		InputStream is=imageFileObj.getInputStream();
//		获得文件的名字
		String filename=imageFileObj.getOriginalFilename();
		//生成随机文件名
		String finalname =  getFileName(filename);
		/*System.out.println(filename);*/
//		获取文件的路径
		String localPath=request.getSession().getServletContext().getRealPath("/Images");
		/*System.out.println(images);*/
//		获取最终的路径加文件名
		String finalPath=localPath+"\\"+finalname;
		
//		创建一个输出流 写入图像文件
		OutputStream os = new FileOutputStream(new File(localPath, finalname));
		IOUtils.copy(is, os);
		result = Result.success(1014, "图片上传成功", finalPath);
		System.out.println(finalPath);
		os.flush();
		os.close();
		is.close();
		return result;
	}
	
	
	//展示详情
		@RequestMapping(value="/selectMedicineDetail.do",method={RequestMethod.POST})
		@ResponseBody
		public Result selectMedicineDetail(Integer m_id){
			Result result = Result.fail(1017, "请求信息失败");
			Medicine medicine  = medicineService.selectMedicineDetail(m_id);
			if(medicine!=null){
				result = Result.success(1018, "请求信息成功",medicine);
			}
			System.out.println(result);
			return result;
		}
		
		
		//导出excel
		@RequestMapping(value="/exportMedicine.do",method={RequestMethod.POST})
		@ResponseBody
		public Result exportDoctor(@RequestParam(value="ids[]")Integer[] ids) throws Exception{
			System.out.println(Arrays.toString(ids));
			Result result = Result.fail(1009, "导出失败");
			ArrayList<Integer> idsList = new ArrayList<>();
			Collections.addAll(idsList, ids);
			String[] titles={"序号","药品编号","药品名称","药品类型","简单描述","状态","剩余量"};
			List<Medicine> medicines = medicineService.exportMedicine(idsList);
			if(medicines.size()>0){
				//导出成功
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
				OutputStream os = new FileOutputStream(new File("C:\\Users\\admin\\Desktop\\hospitalResource\\medicine"+sdf.format(new Date())+".xls"));
				Workbook wk=ExcelUtils.exportExcel(os, titles);	
				XSSFSheet sheet=(XSSFSheet) wk.getSheet("医生信息");
				System.out.println(sheet);
				for(int i=0;i<medicines.size();i++){
					XSSFRow row = sheet.createRow(i+1);
					row.createCell(0).setCellValue(i+1);
					row.createCell(1).setCellValue(medicines.get(i).getM_number());
					row.createCell(2).setCellValue(medicines.get(i).getM_name());
					row.createCell(3).setCellValue(medicines.get(i).getM_type());
					row.createCell(4).setCellValue(medicines.get(i).getM_description());
					row.createCell(5).setCellValue(medicines.get(i).getM_state());
					row.createCell(6).setCellValue(medicines.get(i).getM_residue());
				}
				wk.write(os);
				wk.close();
				result = Result.success(1010, "导出成功");
			}
			return result;
		}
		
		//导出txt
		@RequestMapping(value="/exportMedicineAsTxt.do",method={RequestMethod.POST})
		@ResponseBody
		public Result exportMedicineAsTxt(@RequestParam(value="ids[]")Integer[] ids) throws Exception{
			System.out.println(Arrays.toString(ids));
			Result result = Result.fail(1019, "导出失败");
			ArrayList<Integer> idsList = new ArrayList<>();
			Collections.addAll(idsList, ids);
			final String NEW_LINE_SEPARATOR = "\r\n";
			final String separator = "\t"; // 分隔符

				//输出路径
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
				String fileName="medicine"+sdf.format(new Date());	
				String path ="C:/Users/admin/Desktop/hospitalResource/";
								
				//查询
				List<Medicine> medicines = medicineService.exportMedicine(idsList);
				if(medicines.size()>0){
					List<List<Object>> dataList = new ArrayList<>();
					List<Object> list1 = new ArrayList<Object>();
					list1.add("序号");
					list1.add("药品编号");
					list1.add("药品名称");
					list1.add("药品类型");
					list1.add("简单描述");
					list1.add("状态");
					list1.add("剩余量");
					dataList.add(list1);
					for(int i=0; i<medicines.size();i++){
						//用于存储一行数据
						List<Object> list = new ArrayList<Object>();
						//添加第一行第一个元素
						list.add(i+1);
						list.add(medicines.get(i).getM_number());
						list.add(medicines.get(i).getM_name());
						list.add(medicines.get(i).getM_type());
						//.....添加第N个元素
						list.add(medicines.get(i).getM_description());
						list.add(medicines.get(i).getM_state());
						list.add(medicines.get(i).getM_residue());
						//将这一行添加	到大list里面		
						dataList.add(list);
					}
					//导出
					CsvUtils.writetxtFile(dataList, path, fileName, NEW_LINE_SEPARATOR, separator);
					result = Result.success(1010, "导出成功");
				}
				return result;
		}		
}
