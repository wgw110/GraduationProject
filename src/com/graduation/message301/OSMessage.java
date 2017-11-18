package com.graduation.message301;
/*
 * ����ϵͳ�����Ϣ
 */
import java.io.Serializable;

public class OSMessage implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//OS����
	private String name;
	//OS�汾��
	private String version;
	//OS����
	private String vendor;
	//OS����
	private String description;
	//OS�ں�
	private String arch;
	//OS����ģʽ
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
		return "OS����:"+name+",OS�汾��:"+version+",OS����:"+vendor+",OS����:"+description+",OS�ں�:"+arch+",OS����ģʽ:"+dataModel+",OS cpuEndian:"+cpuEndian;
	}
	

}
