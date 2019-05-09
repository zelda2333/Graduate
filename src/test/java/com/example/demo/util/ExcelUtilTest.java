package com.example.demo.util;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletOutputStream;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.dao.UserDao;
import com.example.demo.entity.User;
import com.example.demo.provider.GithubProvider;
@RunWith(SpringRunner.class)
@SpringBootTest
public class ExcelUtilTest {
	@Autowired
	private UserDao userDao;
	
	
	/**
     * 将用户的信息导入到excel文件中去
     * @param userList 用户列表
     * @param out 输出表
     */
	@Test
	public void outputExcel(List<User> list) throws IOException {
		 list = userDao.userList();
		
        // 1. 创建工作簿
        HSSFWorkbook workbook = new HSSFWorkbook();

        // 2. 创建工作类
        HSSFSheet sheet = workbook.createSheet("hello world");

        // 3. 创建行 , 第三行 注意:从0开始
        HSSFRow row = sheet.createRow(0);
        row.createCell(0).setCellValue("省");
        row.createCell(1).setCellValue("市");
        row.createCell(2).setCellValue("区");
        row.createCell(3).setCellValue("县");     
       for(User user:list){
        int lastRowNum = sheet.getLastRowNum();
        HSSFRow dataRow = sheet.createRow(lastRowNum + 1);
        dataRow.createCell(0).setCellValue(user.getuId());
        dataRow.createCell(1).setCellValue(user.getuName());
        dataRow.createCell(2).setCellValue(user.getPassword());
        dataRow.createCell(3).setCellValue(user.getAuthorId());
       }
        
        // 4. 创建单元格, 第三行第三列 注意:从0开始
       /* HSSFCell cell = row.createCell(2);
        cell.setCellValue("Hello World");
*/
        String fileName = "D:\\test.xls";
        FileOutputStream fileOutputSteam = new FileOutputStream(fileName);

        workbook.write(fileOutputSteam);
        workbook.close();

        fileOutputSteam.close();
    }
	
}	

