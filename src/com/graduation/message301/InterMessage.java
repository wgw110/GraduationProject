package com.graduation.message301;
/*
 * ���������Ϣ
 */
import java.io.Serializable;

public class InterMessage implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// �豸��
	private String name;
	// ���ܵİ���
	private double receivePackets;
	// ���͵İ���
	private double sendPackets;
	// ���ܵ��ֽ���
	private double receiveBytes;
	// ���͵��ֽ���
	private double sendBytes;
	// ����ʱ�����İ���
	private double receiveDroped;
	// ����ʱ�����İ���
	private double sendDroped;
    //�������ݰ�ʱ�Ĵ�����
	private double receiveErrors;
	//�������ݰ�ʱ�Ĵ�����
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
