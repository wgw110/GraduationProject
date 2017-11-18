package com.graduationdesign.dao;

import java.util.List;

import com.graduationdesign.po.CPUMessage;

public interface ICPUDao {
	// 向某个用户的cpu信息表中插入cpu数据
	void addCPUMessage(CPUMessage cpuMessage);

	// 查找某个时间点/段的cpu信息
	List<CPUMessage> find(String date, String prefix);

	// 删除某个时间点/段的cpu信息
	void deleteCPUMessage(String date, String prefix);

	// 查询CPU总使用率大于某个数值的记录,即查询表中的异常信息
	/**
	 * 
	 * @param critical
	 *            临界值
	 * @param prefix
	 *            前缀
	 * @return
	 */
	List<CPUMessage> findException(double critical, String prefix);

	// 查询最新的CPU信息(默认用户查询的是表中目前存储的最新的cpu信息)
	CPUMessage findNew(String prefix);

}
