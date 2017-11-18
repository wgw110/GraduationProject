package com.graduationdesign.po;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * @author ����ΰ ������������������豸�����Ϣ
 *
 */
public abstract class InterMessage implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	int id;
	String date;
	// �豸��
	String name;
	// ���ܵİ���
	double receivePackets;
	// ���͵İ���
	double sendPackets;
	// ���ܵ��ֽ���
	double receiveBytes;
	// ���͵��ֽ���
	double sendBytes;
	// ����ʱ�����İ���
	double receiveDroped;
	// ����ʱ�����İ���
	double sendDroped;
	// �������ݰ�ʱ�Ĵ�����
	double receiveErrors;
	// �������ݰ�ʱ�Ĵ�����
	double sendErrors;

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
				+ receiveBytes + ",sendbytes:" + sendBytes + ",receivedrop:" + receiveDroped + ",senddrop:" + sendDroped
				+ ",receiveerrors:" + receiveErrors + ",senderrors:" + sendErrors;
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
