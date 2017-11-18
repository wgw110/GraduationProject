package com.graduation.excel;

import java.io.File;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;

public class ReadExcel {
	public static void main(String[] args) {
		try {
			Workbook book = Workbook.getWorkbook(new File("测试.xls"));
			// 获得第一个工作表对象
			Sheet sheet = book.getSheet(0);
			// 得到第二列第一行的单元格,getCell(列，行)，下标均从0开始
			Cell cell1 = sheet.getCell(1, 0);
			String result = cell1.getContents();
			System.out.println(result);
			book.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
