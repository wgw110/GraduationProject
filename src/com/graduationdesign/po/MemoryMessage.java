package com.graduationdesign.po;

import java.io.Serializable;

public abstract class MemoryMessage implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	int id;
	String date;
	// �ܴ�С
	double countMem;
	// ��ʹ��
	double usedMem;
	// ����
	double freeMem;
	// Ram����С
	double ram;
	// ��ʵ�Ĵ�СUsed
	double actualUsed;
	// ��ʵ�Ĵ�СUsedFree
	double actualFree;
	// ʹ�õİٷֱ�
	double usedPercent;
	// ʣ��İٷֱ�
	double freePercent;
	// �������ܴ�С
	double swapTotal;
	// ��������ʹ�ô�С
	double swapUsed;
	// ������ʣ���С
	double swapFree;

	public double getCountMem() {
		return countMem;
	}

	public void setCountMem(double countMem) {
		this.countMem = countMem;
	}

	public double getUsedMem() {
		return usedMem;
	}

	public void setUsedMem(double usedMem) {
		this.usedMem = usedMem;
	}

	public double getFreeMem() {
		return freeMem;
	}

	public void setFreeMem(double freeMem) {
		this.freeMem = freeMem;
	}

	public double getRam() {
		return ram;
	}

	public void setRam(double ram) {
		this.ram = ram;
	}

	public double getActualUsed() {
		return actualUsed;
	}

	public void setActualUsed(double actualUsed) {
		this.actualUsed = actualUsed;
	}

	public double getUsedPercent() {
		return usedPercent;
	}

	public void setUsedPercent(double usedPercent) {
		this.usedPercent = usedPercent;
	}

	public double getActualFree() {
		return actualFree;
	}

	public void setActualFree(double actualFree) {
		this.actualFree = actualFree;
	}

	public double getFreePercent() {
		return freePercent;
	}

	public void setFreePercent(double freePercent) {
		this.freePercent = freePercent;
	}

	public double getSwapTotal() {
		return swapTotal;
	}

	public void setSwapTotal(double swapTotal) {
		this.swapTotal = swapTotal;
	}

	public double getSwapUsed() {
		return swapUsed;
	}

	public void setSwapUsed(double swapUsed) {
		this.swapUsed = swapUsed;
	}

	public double getSwapFree() {
		return swapFree;
	}

	public void setSwapFree(double swapFree) {
		this.swapFree = swapFree;
	}

	@Override
	public String toString() {
		return "�ܴ�С:" + countMem + ",��ʹ��" + usedMem + ",����" + freeMem + ",Ram����С:" + ram + ",��ʵ�Ĵ�СUsed:" + actualUsed
				+ ",��ʵ�Ĵ�СUsedFree:" + actualFree + ",ʹ�õİٷֱ�:" + usedPercent + ",ʣ��İٷֱ�:" + freePercent + ",�������ܴ�С��"
				+ swapTotal + ",��������ʹ�ô�С��" + swapUsed + ",������ʣ���С��" + swapFree;
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
