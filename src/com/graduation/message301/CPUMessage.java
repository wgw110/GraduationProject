package com.graduation.message301;

/*
 * 获取CPU的相关信息
 */
import java.io.Serializable;

public class CPUMessage implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// CPU总使用率
	private double countPercent;
	// CPU用户使用率
	private double userPercent;
	// CPU系统使用率
	private double sysPercent;
	// CPU空闲率
	private double idlePercent;
	// CPU错误率
	private double nicePercent;
	// CPU等待率
	private double waitPercent;
	// 获取CPU的总量MHZ
	private double countMhz;

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

}
