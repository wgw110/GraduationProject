package com.graduation.excel;

import java.io.File;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;

public class ReadExcel {
	public static void main(String[] args) {
		try {
			Workbook book = Workbook.getWorkbook(new File("����.xls"));
			// ��õ�һ�����������
			Sheet sheet = book.getSheet(0);
			// �õ��ڶ��е�һ�еĵ�Ԫ��,getCell(�У���)���±����0��ʼ
			Cell cell1 = sheet.getCell(1, 0);
			String result = cell1.getContents();
			System.out.println(result);
			book.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
