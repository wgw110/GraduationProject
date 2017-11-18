package com.graduationdesign.po;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * @author 王国伟 这个类用来描述操作系统等硬件信息
 *
 */
public abstract class OSMessage implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	int id;
	String date;
	// OS名称
	String name;
	// OS版本号
	String version;
	// OS卖家
	String vendor;
	// OS描述
	String description;
	// OS内核
	String arch;
	// OS数据模式
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
		return "OS名称:" + name + ",OS版本号:" + version + ",OS卖家:" + vendor + ",OS描述:" + description + ",OS内核:" + arch
				+ ",OS数据模式:" + dataModel + ",OS cpuEndian:" + cpuEndian;
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
