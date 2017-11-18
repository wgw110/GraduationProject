package com.graduationdesign.dao;

import com.graduationdesign.po.OSMessage;

public interface IOSDao {
	// 向某个用户的os信息表中插入mem数据
	void addOSMessage(OSMessage osMessage);

	// 查找某个时间点的OS信息
	OSMessage find(String date, String prefix);

	// 删除某个时间点/段的OS信息
	void deleteOSMessage(String date, String prefix);

	// 查询数据库中存储的最新的OS信息
	OSMessage findNew(String prefix);

}
