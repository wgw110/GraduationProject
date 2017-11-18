package com.graduation.message301;

import java.io.Serializable;

public class FileMessage implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// 盘符名称
	private String fileName;
	//盘符路径
	private String fileDir;
	//盘符类型
	private String fileType;
	//盘符类型名
	private String fileTypeName;
	//盘符总大小
	private double fileTotal;
	//盘符使用大小
	private double fileUsed;
	//盘符剩余大小
	private double fileFree;
	//资源利用率
	private double filePercent;
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getFileDir() {
		return fileDir;
	}
	public void setFileDir(String fileDir) {
		this.fileDir = fileDir;
	}
	public String getFileType() {
		return fileType;
	}
	public void setFileType(String fileType) {
		this.fileType = fileType;
	}
	public String getFileTypeName() {
		return fileTypeName;
	}
	public void setFileTypeName(String fileTypeName) {
		this.fileTypeName = fileTypeName;
	}
	public double getFileTotal() {
		return fileTotal;
	}
	public void setFileTotal(double fileTotal) {
		this.fileTotal = fileTotal;
	}
	public double getFileUsed() {
		return fileUsed;
	}
	public void setFileUsed(double fileUsed) {
		this.fileUsed = fileUsed;
	}
	public double getFileFree() {
		return fileFree;
	}
	public void setFileFree(double fileFree) {
		this.fileFree = fileFree;
	}
	public double getFilePercent() {
		return filePercent;
	}
	public void setFilePercent(double filePercent) {
		this.filePercent = filePercent;
	}
	@Override
	public String toString() {
		
		return "盘符名称："+fileName+",盘符路径："+fileDir+",盘符类型："+fileType+",盘符类型名"+
		fileTypeName+",盘符总大小："+fileTotal+",盘符使用大小："+fileUsed+",盘符剩余大小："+fileFree+
		",盘符利用率："+filePercent;
	}

}
