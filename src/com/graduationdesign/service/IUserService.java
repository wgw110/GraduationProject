package com.graduationdesign.service;

import com.graduationdesign.po.CPUMessage;
import com.graduationdesign.po.MemoryMessage;
/**
 * 
 * @author 王国伟
 *用户性能信息表中常用逻辑业务
 *通过这个接口与dao中对数据库的相应操作可以添加更多的逻辑业务方法
 */
public interface IUserService {
	// 根据IP地址查询表前缀
	String findPrefix(String ip);

	// 统计某段时间内cpu信息的平均值
	CPUMessage find(String date, String prefix);

	// 统计某段时间内MEM信息的平均值
	MemoryMessage findMem(String date, String prefix);
	//负责分页的类
	

	// 删除某段时间内cpu信息
	void deleteCPUMessage(String date, String prefix);

	// 删除某段时间内Mem信息
	void deleteMemMessage(String date, String prefix);
}
