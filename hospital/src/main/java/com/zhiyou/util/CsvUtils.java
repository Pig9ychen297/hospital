package com.zhiyou.util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;

/**
 * CSV 导出工具类
 * 
 * @author yulisao
 * @createDate 2019-3-15
 */
public class CsvUtils {
	
	/**
	 * 生成csv文件
	 * 
	 * @author yulisao
	 * @date 2018年9月4日 下午2:31:17
	 * 
	 * @param header
	 *            表头
	 * @param dataList
	 *            数据列表
	 * @param outPath
	 *            写入路径
	 * @param fileName
	 *            文件名称
	 * @param lineSeparator
	 *            各记录列表分隔符
	 * @param recordSeparator
	 *            各数据项分隔符
	 * @return
	 */
	public static String writecsvFile(Object[] header, List<List<Object>> dataList, String outPath, String fileName,
			String lineSeparator, char recordSeparator) {
		makeDir(outPath);
		FileWriter fileWriter = null;
		CSVPrinter csvFilePrinter = null;
		String path = outPath + File.separator + fileName + ".csv";
		long start = System.currentTimeMillis();
		// 创建 CSVFormat
		CSVFormat csvFileFormat = CSVFormat.DEFAULT.withRecordSeparator(lineSeparator).withDelimiter(recordSeparator);
		try {
			System.out.println("CSV文件创建开始");
			// 初始化FileWriter
			fileWriter = new FileWriter(path);
			// 初始化 CSVPrinter
			csvFilePrinter = new CSVPrinter(fileWriter, csvFileFormat);
			// 创建CSV文件头
			if (header != null && header.length > 0) {
				csvFilePrinter.printRecord(header);
			}
			// 遍历List写入CSV
			for (List<Object> dataRecord : dataList) {
				csvFilePrinter.printRecord(dataRecord);
				
			}
			long end = System.currentTimeMillis();

			System.out.println("CSV文件创建成功,用时" + (end - start) + "ms,路径:" + path);
			return path;
		} catch (Exception e) {
			System.out.println("CSV文件创建失败");
			e.printStackTrace();
		} finally {
			try {
				fileWriter.flush();
				fileWriter.close();
				csvFilePrinter.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return lineSeparator;
	}

	/**
	 * 生成 txt文件
	 * 
	 * @author yulisao
	 * @date 2018年9月4日 下午2:32:26
	 * 
	 * @param dataList
	 *            数据列表
	 * @param outPath
	 *            写入路径
	 * @param fileName
	 *            文件名称
	 * @param lineSeparator
	 *            各记录列表分隔符
	 * @param recordSeparator
	 *            各数据项分隔符
	 * @return
	 */
	public static String writetxtFile(List<List<Object>> dataList, String outPath, String fileName,
		String lineSeparator, String recordSeparator) {
		makeDir(outPath);
		FileWriter fw = null;
		String path = outPath + File.separator + fileName + ".txt";
		long start = System.currentTimeMillis();
		try {
			System.out.println("txt文件创建开始");
			File file = new File(path);
			if (file.exists()) {
				System.out.println("已存在文件");
			}
			fw = new FileWriter(file);
			BufferedWriter bw = new BufferedWriter(fw);
			for (List<Object> list : dataList) {
				for (int i = 0; i < list.size(); i++) {
					Object o = list.get(i);
					if (o == null) {
						bw.write("");
					} else {
						bw.write(String.valueOf(o));
					}
					if (i < list.size() - 1) {
						bw.write(recordSeparator);
					}
				}
				bw.write(lineSeparator);
			}
			bw.flush();
			bw.close();
			long length = file.length();
			long end = System.currentTimeMillis();
			System.out.println("txt文件创建成功,用时" + (end - start) + "ms,length=" + length + " byte,路径:" + path);
			return path;
		} catch (IOException e) {
			System.out.println("txt文件创建失败");
			e.printStackTrace();
		}
		return path;
	}


	/**
	 * 创建文件目录
	 * 
	 * @param outPath   
	 * @return void  
	 * @author yulisao
	 * @createDate 2019-3-15
	 */
	public static void makeDir(String outPath){
		File file = new File(outPath);
		if (!file.exists()) {
			file.mkdirs();
		}
	}

}


