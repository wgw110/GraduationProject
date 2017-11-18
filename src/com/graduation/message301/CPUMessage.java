package com.graduation.message301;

/*
 * ��ȡCPU�������Ϣ
 */
import java.io.Serializable;

public class CPUMessage implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// CPU��ʹ����
	private double countPercent;
	// CPU�û�ʹ����
	private double userPercent;
	// CPUϵͳʹ����
	private double sysPercent;
	// CPU������
	private double idlePercent;
	// CPU������
	private double nicePercent;
	// CPU�ȴ���
	private double waitPercent;
	// ��ȡCPU������MHZ
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
		return "CPU��ʹ����:" + countPercent + ",CPU�û�ʹ���ʣ�" + userPercent + ",CPUϵͳʹ���ʣ�" + sysPercent + ",CPU�����ʣ�"
				+ idlePercent + ",CPU�����ʣ�" + nicePercent + ",CPU�ȴ���:" + waitPercent + "CPU������MHZ:" + countMhz;
	}

}
