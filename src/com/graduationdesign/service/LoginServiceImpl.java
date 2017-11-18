package com.graduationdesign.service;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

import com.graduationdesign.dao.UserDaoImpl;
import com.graduationdesign.po.User;

public class LoginServiceImpl implements ILoginService {

	@Override
	public boolean isSuccessLogin(String name, String password) {
		UserDaoImpl userDaoImpl = new UserDaoImpl();
		User user = userDaoImpl.findByName(name);
		if (user == null) {
			System.out.println("user is null");
			return false;
		} else {
			if (user.getPassword().equals(password)) {
				return true;
			} else {
				System.out.println("user password error");
				return false;
			}
		}

	}

	@Override
	public void register(User user) {
		UserDaoImpl userDaoImpl = new UserDaoImpl();
		userDaoImpl.adduser(user);

	}

	@Override
	public boolean isUserRegister(String ip) {
		UserDaoImpl userDaoImpl = new UserDaoImpl();
		User user = userDaoImpl.findByIPAddress(ip);
		if (user != null) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean isNameUsed(String name) {
		UserDaoImpl userDaoImpl = new UserDaoImpl();
		User user = userDaoImpl.findByName(name);
		if (user == null) {
			return false;
		} else {
			return true;
		}
	}

	@Override
	public boolean isValid(String ip) {
		boolean judge = false;
		try {
			judge = InetAddress.getByName(ip).isReachable(3000);
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return judge;
	}

}
