package com.graduationdesign.po;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * @author ����ΰ �������������CPU��Ϣ���� ����ʹ���ʣ��ȴ��ʵȵ�
 *
 */
public abstract class CPUMessage implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	int id;
	String date;
	// CPU��ʹ����
	double countPercent;
	// CPU�û�ʹ����
	double userPercent;
	// CPUϵͳʹ����
	double sysPercent;
	// CPU������
	double idlePercent;
	// CPU������
	double nicePercent;
	// CPU�ȴ���
	double waitPercent;
	// ��ȡCPU������MHZ
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
		return "CPU��ʹ����:" + countPercent + ",CPU�û�ʹ���ʣ�" + userPercent + ",CPUϵͳʹ���ʣ�" + sysPercent + ",CPU�����ʣ�"
				+ idlePercent + ",CPU�����ʣ�" + nicePercent + ",CPU�ȴ���:" + waitPercent + "CPU������MHZ:" + countMhz;
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
