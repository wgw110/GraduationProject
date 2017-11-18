package com.graduationdesign.dao;

import java.util.Date;
import java.util.List;

import com.graduationdesign.po.MemoryMessage;

public interface IMemDao {
	// 向某个用户的mem信息表中插入mem数据
	void addMemMessage(MemoryMessage memMessage);

	// 查找某个时间点的mem信息
	List<MemoryMessage> find(String date, String prefix);

	// 删除某个时间点/段的mem信息
	void deleteMemMessage(String date, String prefix);

	// 寻找表中异常记录
	List<MemoryMessage> findException(double critical, String prefix);

	// 查询表中最新的mem信息
	MemoryMessage findNew(String prefix);

}
