package com.graduationdesign.service;

import com.graduationdesign.po.User;
/**
 * 
 * @author 王国伟
 *登录以及注册的业务逻辑接口，该业务逻辑接口通过与数据库的dao层交流从未实现关于登录与注册的业务逻辑
 *
 */
public interface ILoginService {
	// 判断登录是否成功
	boolean isSuccessLogin(String name, String password);

	// 用户注册信息加入到user表之中
	void register(User user);

	// 用户是否已经注册
	boolean isUserRegister(String ip);

	// 用户昵称是否被占用
	boolean isNameUsed(String name);

	// IP地址是否有效
	boolean isValid(String ip);

}
