package com.graduationdesign.po;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * @author ����ΰ ���������������Ӳ��ϵͳ��Ϣ���� �����̷������ͣ���С�ȵ�
 *
 */
public abstract class FileMessage implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// id��¼����������¼
	int id;
	
	String date;
	// �̷�����
	String fileName;
	// �̷�·��
	String fileDir;
	// �̷�����
	String fileType;
	// �̷�������
	String fileTypeName;
	// �̷��ܴ�С
	double fileTotal;
	// �̷�ʹ�ô�С
	double fileUsed;
	// �̷�ʣ���С
	double fileFree;
	// ��Դ������
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

		return "�̷����ƣ�" + fileName + ",�̷�·����" + fileDir + ",�̷����ͣ�" + fileType + ",�̷�������" + fileTypeName + ",�̷��ܴ�С��"
				+ fileTotal + ",�̷�ʹ�ô�С��" + fileUsed + ",�̷�ʣ���С��" + fileFree + ",�̷������ʣ�" + filePercent;
	}

}
