package com.graduation.message301;
/*
 * 获取内存相关信息
 */
import java.io.Serializable;

public class MemoryMessage implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//总大小
	private double countMem;
	//已使用
	private double usedMem;
	//可用
	private double freeMem;
	//Ram区大小
	private double ram;
	//真实的大小Used
	private double actualUsed;
	//真实的大小UsedFree
	private double actualFree;
	//使用的百分比
	private double usedPercent;
	//剩余的百分比
	private double freePercent;
	//交换区总大小
	private double swapTotal;
	//交换区已使用大小
	private double swapUsed;
	//交换区剩余大小
	private double swapFree;
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
		return "总大小:"+countMem+",已使用"+usedMem+",可用"+freeMem+",Ram区大小:"+ram+",真实的大小Used:"+actualUsed+",真实的大小UsedFree:"+actualFree+
				",使用的百分比:"+usedPercent+",剩余的百分比:"+freePercent+",交换区总大小："+swapTotal+",交换区已使用大小："+swapUsed+",交换区剩余大小："+swapFree;
	}

}
