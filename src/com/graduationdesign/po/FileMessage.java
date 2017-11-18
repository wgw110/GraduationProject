package com.graduationdesign.po;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * @author 王国伟 这个类是用来描述硬盘系统信息的类 包括盘符，类型，大小等等
 *
 */
public abstract class FileMessage implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// id记录的是哪条记录
	int id;
	
	String date;
	// 盘符名称
	String fileName;
	// 盘符路径
	String fileDir;
	// 盘符类型
	String fileType;
	// 盘符类型名
	String fileTypeName;
	// 盘符总大小
	double fileTotal;
	// 盘符使用大小
	double fileUsed;
	// 盘符剩余大小
	double fileFree;
	// 资源利用率
	double filePercent;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

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

		return "盘符名称：" + fileName + ",盘符路径：" + fileDir + ",盘符类型：" + fileType + ",盘符类型名" + fileTypeName + ",盘符总大小："
				+ fileTotal + ",盘符使用大小：" + fileUsed + ",盘符剩余大小：" + fileFree + ",盘符利用率：" + filePercent;
	}

}
