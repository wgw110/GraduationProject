package com.graduation.message301;
/*
 * 操作系统相关信息
 */
import java.io.Serializable;

public class OSMessage implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//OS名称
	private String name;
	//OS版本号
	private String version;
	//OS卖家
	private String vendor;
	//OS描述
	private String description;
	//OS内核
	private String arch;
	//OS数据模式
	private String dataModel;
	//OS cpuEndian
	private String cpuEndian;
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
		return "OS名称:"+name+",OS版本号:"+version+",OS卖家:"+vendor+",OS描述:"+description+",OS内核:"+arch+",OS数据模式:"+dataModel+",OS cpuEndian:"+cpuEndian;
	}
	

}
