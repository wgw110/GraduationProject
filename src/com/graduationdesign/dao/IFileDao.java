package com.graduationdesign.dao;

import java.util.Date;
import java.util.List;

import com.graduationdesign.po.FileMessage;

public interface IFileDao {
	// 向表中插入文件系统信息
	void addFileMessage(FileMessage fileMessage);

	// 查找某个时间文件系统信息
	List<FileMessage> find(String date, String prefix);

	// 删除某个时间的文件信息
	void deleteFileMessage(String date, String prefix);

	// 查找表中最新的记录
	List<FileMessage> findNew(String prefix);
	
	//查找表中C盘占有率过高的的记录
	List<FileMessage> findOver(String prefix);


}
