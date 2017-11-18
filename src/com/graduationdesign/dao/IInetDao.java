package com.graduationdesign.dao;

import java.util.List;

import com.graduationdesign.po.InterMessage;

public interface IInetDao {
	// 向某个用户的inet信息表中插入mem数据
	void addInetMessage(InterMessage inetMessage);

	// 查找某个时间点的inet信息
	List<InterMessage> find(String date, String prefix);

	// 删除某个时间点的inet信息
	void deleteInetMessage(String date, String prefix);

	// 查找最新的inet信息
	List<InterMessage> findNew(String prefix);
}
