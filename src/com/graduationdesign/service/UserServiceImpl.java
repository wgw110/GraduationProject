package com.graduationdesign.service;

import java.util.List;

import com.graduationdesign.dao.CPUDaoImpl;
import com.graduationdesign.dao.MemDaoImpl;
import com.graduationdesign.dao.UserDaoImpl;
import com.graduationdesign.po.CPUMessage;
import com.graduationdesign.po.MemoryMessage;
import com.graduationdesign.po.User;
import com.graduationdesign.user.User1CPU;
import com.graduationdesign.user.User1Mem;
import com.graduationdesign.user.User2CPU;
import com.graduationdesign.user.User2Mem;

public class UserServiceImpl implements IUserService {

	@Override
	public String findPrefix(String ip) {
		User user = new UserDaoImpl().findByIPAddress(ip);
		return user.getPrefix();
	}

	@Override
	public CPUMessage find(String date, String prefix) {
		CPUDaoImpl cpuDaoImpl = new CPUDaoImpl();
		List<CPUMessage> cpuMessages = cpuDaoImpl.find(date, prefix);
		double countPercent = 0, userPercent = 0, sysPercent = 0, idlePercent = 0, nicePercent = 0, waitPercent = 0,
				countMhz = 0;
		for (CPUMessage cpuMessage : cpuMessages) {
			countPercent = countPercent + cpuMessage.getCountPercent();
			userPercent = userPercent + cpuMessage.getUserPercent();
			sysPercent = sysPercent + cpuMessage.getSysPercent();
			idlePercent = idlePercent + cpuMessage.getIdlePercent();
			nicePercent = nicePercent + cpuMessage.getNicePercent();
			waitPercent = waitPercent + cpuMessage.getWaitPercent();
			countMhz = countMhz + cpuMessage.getCountMhz();
		}
		CPUMessage cpuMessage = null;
		switch (prefix) {
		case "wgw":
			cpuMessage = new User1CPU();
			break;
		case "lsq":
			cpuMessage = new User2CPU();
		default:
			break;
		}
		int size = cpuMessages.size();
		System.out.println("获得的记录有：" + size + "条");
		cpuMessage.setDate(date);
		cpuMessage.setCountPercent(countPercent / size);
		cpuMessage.setCountMhz(countMhz / size);
		cpuMessage.setIdlePercent(idlePercent / size);
		cpuMessage.setNicePercent(nicePercent / size);
		cpuMessage.setSysPercent(sysPercent / size);
		cpuMessage.setUserPercent(userPercent / size);
		cpuMessage.setWaitPercent(waitPercent / size);
		return cpuMessage;
	}

	@Override
	public MemoryMessage findMem(String date, String prefix) {
		MemDaoImpl memDaoImpl = new MemDaoImpl();
		List<MemoryMessage> memoryMessages = memDaoImpl.find(date, prefix);
		double countMem = 0, usedMem = 0, freeMem = 0, ram = 0, actualUsed = 0, actualFree = 0, usedPercent = 0,
				freePercent = 0, swapTotal = 0, swapUsed = 0, swapFree = 0;
		int size = memoryMessages.size();
		for (MemoryMessage memoryMessage : memoryMessages) {
			countMem = countMem + memoryMessage.getCountMem();
			usedMem = usedMem + memoryMessage.getUsedMem();
			freeMem = freeMem + memoryMessage.getFreeMem();
			ram = ram + memoryMessage.getRam();
			actualFree = actualFree + memoryMessage.getActualFree();
			actualUsed = actualUsed + memoryMessage.getActualUsed();
			usedPercent = usedPercent + memoryMessage.getUsedPercent();
			freePercent = freePercent + memoryMessage.getFreePercent();
			swapTotal = swapTotal + memoryMessage.getSwapTotal();
			swapUsed = swapUsed + memoryMessage.getSwapUsed();
			swapFree = swapFree + memoryMessage.getSwapFree();
		}
		MemoryMessage memoryMessage = null;
		switch (prefix) {
		case "wgw":
			memoryMessage = new User1Mem();
			break;
		case "lsq":
			memoryMessage = new User2Mem();
			break;
		default:
			break;
		}
		memoryMessage.setDate(date);
		memoryMessage.setCountMem(countMem / size);
		memoryMessage.setUsedMem(usedMem / size);
		memoryMessage.setActualUsed(actualUsed / size);
		memoryMessage.setFreeMem(freeMem / size);
		memoryMessage.setFreePercent(freePercent / size);
		memoryMessage.setRam(ram / ram);
		memoryMessage.setSwapFree(swapFree / size);
		memoryMessage.setSwapTotal(swapTotal / size);
		memoryMessage.setSwapUsed(swapUsed / size);
		memoryMessage.setUsedMem(usedMem / size);
		memoryMessage.setUsedPercent(usedPercent / size);
		memoryMessage.setActualFree(actualFree / size);
		return memoryMessage;
	}

	@Override
	public void deleteCPUMessage(String date, String prefix) {
		// TODO Auto-generated method stub
		new CPUDaoImpl().deleteCPUMessage(date, prefix);

	}

	@Override
	public void deleteMemMessage(String date, String prefix) {
		new MemDaoImpl().deleteMemMessage(date, prefix);

	}

}
