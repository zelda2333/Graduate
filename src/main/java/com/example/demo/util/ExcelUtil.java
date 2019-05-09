package com.example.demo.util;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.dao.ScoresDao;
import com.example.demo.entity.ScoresAndInfo;
@Component
public class ExcelUtil {
	@Autowired
	private ScoresDao scoreDao;
	
	public String outputExcel() throws IOException {
		List<ScoresAndInfo> list = scoreDao.ListScoresAndInfo();
		 try {
       // 1. 创建工作簿
       HSSFWorkbook workbook = new HSSFWorkbook();

       // 2. 创建工作类
       HSSFSheet sheet = workbook.createSheet("学生成绩");

       // 3. 创建行 , 第三行 注意:从0开始
       HSSFRow row = sheet.createRow(0);
       row.createCell(0).setCellValue("姓名");
       row.createCell(1).setCellValue("学号");
       row.createCell(2).setCellValue("成绩");
       row.createCell(3).setCellValue("第几次成绩");     
      for(ScoresAndInfo scores:list){
       int lastRowNum = sheet.getLastRowNum();
       HSSFRow dataRow = sheet.createRow(lastRowNum + 1);
       dataRow.createCell(0).setCellValue(scores.getStuinfo().getsName());
       dataRow.createCell(1).setCellValue(scores.getStuinfo().getsNumber());
       dataRow.createCell(2).setCellValue(scores.getScore());
       dataRow.createCell(3).setCellValue(scores.getNumber());
      }
       
       // 4. 创建单元格, 第三行第三列 注意:从0开始
      /* HSSFCell cell = row.createCell(2);
       cell.setCellValue("Hello World");
*/
       String fileName = "F:\\gitSome_workspace\\HomeWork\\scores.xls";
       FileOutputStream fileOutputSteam = new FileOutputStream(fileName);

       workbook.write(fileOutputSteam);
       workbook.close();

       fileOutputSteam.close();
       
       return "success";
	        } catch (Exception e) {
	            e.printStackTrace();
	            return "error";
	        }
	}
}
