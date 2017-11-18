package com.graduation.draw303;

import java.util.List;

import com.graduation.message301.CPUMessage;
import com.graduation.message301.InterMessage;
import com.graduation.message301.MemoryMessage;
import com.graduation.message301.Message;

public class DrawMain {
	private Message message;

	public DrawMain(Message message) {
		this.message = message;
	}

	public void Draw() {
		CPUMessage cpuMessage = message.getCpuMessage();
		DrawCPU drawCPU = new DrawCPU(cpuMessage);
		drawCPU.DrawBarChart();
		drawCPU.drawPieChart();
		// MemoryMessage memoryMessage = message.getMemoryMessage();
		// DrawMemory drawMemory = new DrawMemory(memoryMessage);
		// List<InterMessage> list = message.getList();
		// DrawInternet drawInternet = new DrawInternet(list);
	}

}
