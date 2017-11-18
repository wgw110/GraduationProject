package com.graduationdesign.dao;

import java.util.List;

import com.graduationdesign.po.User;

public interface IUserDao {
	// 添加用户
	void adduser(User user);

	// 根据姓名查找相关信息
	User findByName(String name);

	// 根据ip地址查找用户信息
	User findByIPAddress(String ip);

	// 根据表前缀查询信息
	User findByPrefix(String prefix);

	// 查询user表中的所有用户
	List<User> findAll();

	// 更新用户信息
	void updateUser(String name);

	// 删除用户
	void deleteUser(String ip);

}
