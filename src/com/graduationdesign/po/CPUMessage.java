package com.graduationdesign.po;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * @author 王国伟 这个类用来描述CPU信息的类 包括使用率，等待率等等
 *
 */
public abstract class CPUMessage implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	int id;
	String date;
	// CPU总使用率
	double countPercent;
	// CPU用户使用率
	double userPercent;
	// CPU系统使用率
	double sysPercent;
	// CPU空闲率
	double idlePercent;
	// CPU错误率
	double nicePercent;
	// CPU等待率
	double waitPercent;
	// 获取CPU的总量MHZ
	double countMhz;

	public double getCountPercent() {
		return countPercent;
	}

	public void setCountPercent(double countPercent) {
		this.countPercent = countPercent;
	}

	public double getUserPercent() {
		return userPercent;
	}

	public void setUserPercent(double userPercent) {
		this.userPercent = userPercent;
	}

	public double getSysPercent() {
		return sysPercent;
	}

	public void setSysPercent(double sysPercent) {
		this.sysPercent = sysPercent;
	}

	public double getIdlePercent() {
		return idlePercent;
	}

	public void setIdlePercent(double idlePercent) {
		this.idlePercent = idlePercent;
	}

	public double getNicePercent() {
		return nicePercent;
	}

	public void setNicePercent(double nicePercent) {
		this.nicePercent = nicePercent;
	}

	public double getWaitPercent() {
		return waitPercent;
	}

	public void setWaitPercent(double waitPercent) {
		this.waitPercent = waitPercent;
	}

	public double getCountMhz() {
		return countMhz;
	}

	public void setCountMhz(double countMhz) {
		this.countMhz = countMhz;
	}

	@Override
	public String toString() {
		return "CPU总使用率:" + countPercent + ",CPU用户使用率：" + userPercent + ",CPU系统使用率：" + sysPercent + ",CPU空闲率："
				+ idlePercent + ",CPU错误率：" + nicePercent + ",CPU等待率:" + waitPercent + "CPU的总量MHZ:" + countMhz;
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
