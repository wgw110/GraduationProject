package com.graduationdesign.support;

import java.io.Serializable;
import java.util.List;

import com.graduationdesign.po.CPUMessage;
import com.graduationdesign.po.FileMessage;
import com.graduationdesign.po.InterMessage;
import com.graduationdesign.po.MemoryMessage;
import com.graduationdesign.po.OSMessage;

public class Message implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private CPUMessage cpuMessage;
	private MemoryMessage memoryMessage;
	private OSMessage osMessage;
	private List<InterMessage> list;
	private List<FileMessage> fileList;

	public CPUMessage getCpuMessage() {
		return cpuMessage;
	}

	public void setCpuMessage(CPUMessage cpuMessage) {
		this.cpuMessage = cpuMessage;
	}

	public MemoryMessage getMemoryMessage() {
		return memoryMessage;
	}

	public void setMemoryMessage(MemoryMessage memoryMessage) {
		this.memoryMessage = memoryMessage;
	}

	public OSMessage getOsMessage() {
		return osMessage;
	}

	public void setOsMessage(OSMessage osMessage) {
		this.osMessage = osMessage;
	}

	public List<InterMessage> getList() {
		return list;
	}

	public void setList(List<InterMessage> list) {
		this.list = list;
	}

	public List<FileMessage> getFileList() {
		return fileList;
	}

	public void setFileList(List<FileMessage> fileList) {
		this.fileList = fileList;
	}

}
