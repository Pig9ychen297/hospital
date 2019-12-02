package com.zhiyou.util;

import java.io.OutputStream;


import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {
	public static Workbook exportExcel(OutputStream outputStream,String[] titles) throws Exception{

		// 新建工作簿对象
		XSSFWorkbook workBook = new XSSFWorkbook();
		// 创建sheet对象
		XSSFSheet sheet = workBook.createSheet("医生信息");
		// 创建行,标题行
		XSSFRow row = sheet.createRow(0);
		for(int i = 0; i < titles.length; i++){
			// 创建单元格
			XSSFCell cell = row.createCell(i);
			// 设置单元格内容
			cell.setCellValue(titles[i]);
		}

		return workBook;
		//根据list集合存储的数据来完成对应的创建
		/*for(int i = 0; i < list.size(); i++){
			XSSFRow row2 = sheet.createRow(i + 1);
			row2.createCell(0).setCellValue(list.get(i));
			row2.createCell(1).setCellValue((Integer)list.get(i).get("age"));
			row2.createCell(2).setCellValue((String)list.get(i).get("tel"));
		}

		workBook.write(outputStream);

		workBook.close();*/
	}
}
