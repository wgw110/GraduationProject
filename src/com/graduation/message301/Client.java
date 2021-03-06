package com.graduation.message301;

/*
 * 将相关性能信息封装到一个对象之中，使用对象流传送性能数据
 * 
 */
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

import org.hyperic.sigar.CpuInfo;
import org.hyperic.sigar.CpuPerc;
import org.hyperic.sigar.FileSystem;
import org.hyperic.sigar.FileSystemUsage;
import org.hyperic.sigar.Mem;
import org.hyperic.sigar.NetInterfaceConfig;
import org.hyperic.sigar.NetInterfaceStat;
import org.hyperic.sigar.OperatingSystem;
import org.hyperic.sigar.Sigar;
import org.hyperic.sigar.SigarException;
import org.hyperic.sigar.Swap;

public class Client {

	public static void main(String[] args) {
		Client test = new Client();
		try {
			Socket socket = new Socket("localhost", 8080);
			System.out.println("connect success");
			test.new SendMessage(socket).start();

		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	class SendMessage extends Thread {
		private Socket socket;
		private ObjectOutputStream objectOutputStream;

		public SendMessage(Socket socket) {
			this.socket = socket;
		}

		@Override
		public void run() {
			System.out.println("seng message start");
			try {
				objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
				while (true) {
					SendMessage(objectOutputStream);
					try {
						Thread.sleep(10 * 1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}

			} catch (IOException e) {
				e.printStackTrace();
			}

		}

		private void SendMessage(ObjectOutputStream objectOutputStream2) {
			CPUMessage cpuMessage = new CPUMessage();
//			MemoryMessage memoryMessage = new MemoryMessage();
//			List<InterMessage> list = new ArrayList<>();
//			List<FileMessage> listFile = new ArrayList<>();
//			OSMessage osMessage = new OSMessage();
			checkCPU(cpuMessage);
//			checkMemory(memoryMessage);
//			checkOS(osMessage);
//			checkInternet(list);
//			checkFile(listFile);
			Message message = new Message();
			message.setCpuMessage(cpuMessage);
			// message.setMemoryMessage(memoryMessage);
			// message.setOsMessage(osMessage);
			// message.setList(list);
			// message.setFileList(listFile);
			try {
				objectOutputStream.writeObject(message);
				objectOutputStream.flush();
			} catch (IOException e) {
				e.printStackTrace();
			}

		}

		private void checkFile(List<FileMessage> listFile) {
			// TODO Auto-generated method stub
			Sigar sigar = new Sigar();
			FileSystem fslist[] = null;
			try {
				fslist = sigar.getFileSystemList();
			} catch (SigarException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			FileMessage fileMessage = null;
			for (int i = 0; i < fslist.length; i++) {
				fileMessage = new FileMessage();
				FileSystem fs = fslist[i];
				// 盘符名称
				String fileName = fs.getDevName();
				// 盘符路径
				String fileDir = fs.getDirName();
				// 盘符类型
				String fileType = fs.getSysTypeName();
				// 盘符类型名
				String fileTypeName = fs.getTypeName();
				// 盘符总大小
				double fileTotal = 0;
				// 盘符使用大小
				double fileUsed = 0;
				// 盘符剩余大小
				double fileFree = 0;
				// 资源利用率
				double filePercent = 0;
				FileSystemUsage usage = null;
				try {
					usage = sigar.getFileSystemUsage(fs.getDirName());
				} catch (SigarException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				switch (fs.getType()) {
				case 0: // TYPE_UNKNOWN ：未知
					break;
				case 1: // TYPE_NONE
					break;
				case 2: // TYPE_LOCAL_DISK : 本地硬盘
					fileTotal = usage.getTotal() / 1024;
					fileFree = usage.getFree() / 1024;
					fileUsed = usage.getUsed() / 1024;
					filePercent = usage.getUsePercent() * 100D;
					fileMessage.setFileName(fileName);
					fileMessage.setFileDir(fileDir);
					fileMessage.setFileType(fileType);
					fileMessage.setFileTypeName(fileTypeName);
					fileMessage.setFileTotal(fileTotal);
					fileMessage.setFileUsed(fileUsed);
					fileMessage.setFileFree(fileFree);
					fileMessage.setFilePercent(filePercent);
					listFile.add(fileMessage);
					break;
				case 3:// TYPE_NETWORK ：网络
					break;
				case 4:// TYPE_RAM_DISK ：闪存
					break;
				case 5:// TYPE_CDROM ：光驱
					break;
				case 6:// TYPE_SWAP ：页面交换
					break;
				}

			}
		}

		private void checkInternet(List<InterMessage> list) {
			Sigar sigar = new Sigar();
			try {
				String ifNames[] = sigar.getNetInterfaceList();
				InterMessage interMessage;
				for (int i = 0; i < ifNames.length; i++) {
					interMessage = new InterMessage();
					String name = ifNames[i];
					NetInterfaceConfig ifconfig = sigar.getNetInterfaceConfig(name);
					// 网络装置是否正常启用
					if ((ifconfig.getFlags() & 1L) <= 0L) {
						System.out.println("!IFF_UP...skipping getNetInterfaceStat");
						continue;
					}
					NetInterfaceStat ifstat = sigar.getNetInterfaceStat(name);
					double sendPackets = ifstat.getRxPackets();
					double receivePackets = ifstat.getTxPackets();
					double receiveBytes = ifstat.getRxBytes();
					double sendBytes = ifstat.getTxBytes();
					double receiveDroped = ifstat.getRxDropped();
					double sendDroped = ifstat.getTxDropped();
					double receiveErrors = ifstat.getRxErrors();
					double sendErrors = ifstat.getTxErrors();
					interMessage.setName(name);
					interMessage.setSendPackets(sendPackets);
					interMessage.setReceivePackets(receivePackets);
					interMessage.setSendBytes(sendBytes);
					interMessage.setReceiveBytes(receiveBytes);
					interMessage.setSendDroped(sendDroped);
					interMessage.setReceiveDroped(receiveDroped);
					interMessage.setSendErrors(sendErrors);
					interMessage.setReceiveErrors(receiveErrors);
					list.add(interMessage);

				}
			} catch (SigarException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		private void checkOS(OSMessage osMessage) {
			System.out.println("start get OS message");
			OperatingSystem os = OperatingSystem.getInstance();
			String name = os.getName();
			String version = os.getVersion();
			String vendor = os.getVendor();
			String description = os.getDescription();
			String arch = os.getArch();
			String dataModel = os.getDataModel();
			String cpuEndian = os.getCpuEndian();
			osMessage.setName(name);
			osMessage.setVersion(version);
			osMessage.setVendor(vendor);
			osMessage.setDescription(description);
			osMessage.setArch(arch);
			osMessage.setDataModel(dataModel);
			osMessage.setCpuEndian(cpuEndian);

		}

		private void checkMemory(MemoryMessage memoryMessage) {
			System.out.println("start get memory message");
			Sigar sigar = new Sigar();

			try {
				Swap swap = sigar.getSwap();
				double swapTotal = swap.getTotal() / 1024 / 1024;
				double swapUsed = swap.getUsed() / 1024 / 1024;
				double swapFree = swap.getFree() / 1024 / 1024;
				Mem mem = sigar.getMem();
				double countMem = mem.getTotal() / 1024 / 1024;
				double usedMem = mem.getUsed() / 1024 / 1024;
				double freeMem = mem.getFree() / 1024 / 1024;
				double ram = mem.getRam() / 1024 / 1024;

				double actualUsed = mem.getActualUsed() / 1024 / 1024;
				double actualFree = mem.getActualFree() / 1024 / 1024;
				double usedPercent = mem.getUsedPercent();
				double freePercent = mem.getFreePercent();
				memoryMessage.setCountMem(countMem);
				memoryMessage.setUsedMem(usedMem);
				memoryMessage.setFreeMem(freeMem);
				memoryMessage.setRam(ram);
				memoryMessage.setActualUsed(actualUsed);
				memoryMessage.setActualFree(actualFree);
				memoryMessage.setUsedPercent(usedPercent);
				memoryMessage.setFreePercent(freePercent);
				memoryMessage.setSwapTotal(swapTotal);
				memoryMessage.setSwapUsed(swapUsed);
				memoryMessage.setSwapFree(swapFree);

			} catch (SigarException e) {
				e.printStackTrace();
			}

		}

		private void checkCPU(CPUMessage cpuMessage) {
			System.out.println("start get CPUmesssage");
			Sigar sigar = new Sigar();
			try {

				CpuPerc cpuCerc = sigar.getCpuPerc();
				double countPercent = cpuCerc.getCombined() * 100;
				double userPercent = cpuCerc.getUser() * 100;
				double sysPercent = cpuCerc.getSys() * 100;
				double idlePercent = cpuCerc.getIdle() * 100;
				double nicePercent = cpuCerc.getNice() * 100;
				double waitPercent = cpuCerc.getWait() * 100;
				CpuInfo infos[] = sigar.getCpuInfoList();
				double countMhz = 0;
				for (int i = 0; i < infos.length; i++) {
					countMhz = infos[i].getMhz() + countMhz;
				}
				cpuMessage.setCountPercent(countPercent);
				cpuMessage.setUserPercent(userPercent);
				cpuMessage.setSysPercent(sysPercent);
				cpuMessage.setIdlePercent(idlePercent);
				cpuMessage.setNicePercent(nicePercent);
				cpuMessage.setWaitPercent(waitPercent);
				cpuMessage.setCountMhz(countMhz);
			} catch (SigarException e) {
				e.printStackTrace();
			}

		}
	}

}
