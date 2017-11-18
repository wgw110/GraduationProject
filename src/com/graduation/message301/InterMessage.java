package com.graduation.message301;
/*
 * 网络相关信息
 */
import java.io.Serializable;

public class InterMessage implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// 设备名
	private String name;
	// 接受的包数
	private double receivePackets;
	// 发送的包数
	private double sendPackets;
	// 接受的字节数
	private double receiveBytes;
	// 发送的字节数
	private double sendBytes;
	// 接收时丢弃的包数
	private double receiveDroped;
	// 发送时丢弃的包数
	private double sendDroped;
    //接受数据包时的错误数
	private double receiveErrors;
	//发送数据包时的错误数
	private double sendErrors;
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getReceivePackets() {
		return receivePackets;
	}

	public void setReceivePackets(double receivePackets) {
		this.receivePackets = receivePackets;
	}

	public double getSendPackets() {
		return sendPackets;
	}

	public void setSendPackets(double sendPackets) {
		this.sendPackets = sendPackets;
	}

	public double getReceiveBytes() {
		return receiveBytes;
	}

	public void setReceiveBytes(double receiveBytes) {
		this.receiveBytes = receiveBytes;
	}

	public double getSendBytes() {
		return sendBytes;
	}

	public void setSendBytes(double sendBytes) {
		this.sendBytes = sendBytes;
	}

	public double getReceiveDroped() {
		return receiveDroped;
	}

	public void setReceiveDroped(double receiveDroped) {
		this.receiveDroped = receiveDroped;
	}

	public double getSendDroped() {
		return sendDroped;
	}

	public void setSendDroped(double sendDroped) {
		this.sendDroped = sendDroped;
	}

	
	public double getReceiveErrors() {
		return receiveErrors;
	}

	public void setReceiveErrors(double receiveErrors) {
		this.receiveErrors = receiveErrors;
	}

	public double getSendErrors() {
		return sendErrors;
	}

	public void setSendErrors(double sendErrors) {
		this.sendErrors = sendErrors;
	}
	@Override
	public String toString() {
		return "name: " + name + ",receivepacks:" + receivePackets + ",sendpacks:" + sendPackets + ",receivebytes:"
				+ receiveBytes + ",sendbytes:" + sendBytes + ",receivedrop:" + receiveDroped + ",senddrop:"
				+ sendDroped+",receiveerrors:"+receiveErrors+",senderrors:"+sendErrors;
	}


}
