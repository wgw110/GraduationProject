package com.graduationdesign.po;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * @author ����ΰ �����������������ϵͳ��Ӳ����Ϣ
 *
 */
public abstract class OSMessage implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	int id;
	String date;
	// OS����
	String name;
	// OS�汾��
	String version;
	// OS����
	String vendor;
	// OS����
	String description;
	// OS�ں�
	String arch;
	// OS����ģʽ
	String dataModel;
	// OS cpuEndian
	String cpuEndian;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public String getVendor() {
		return vendor;
	}

	public void setVendor(String vendor) {
		this.vendor = vendor;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getArch() {
		return arch;
	}

	public void setArch(String arch) {
		this.arch = arch;
	}

	public String getDataModel() {
		return dataModel;
	}

	public void setDataModel(String dataModel) {
		this.dataModel = dataModel;
	}

	public String getCpuEndian() {
		return cpuEndian;
	}

	public void setCpuEndian(String cpuEndian) {
		this.cpuEndian = cpuEndian;
	}

	@Override
	public String toString() {
		return "OS����:" + name + ",OS�汾��:" + version + ",OS����:" + vendor + ",OS����:" + description + ",OS�ں�:" + arch
				+ ",OS����ģʽ:" + dataModel + ",OS cpuEndian:" + cpuEndian;
	}

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

}
