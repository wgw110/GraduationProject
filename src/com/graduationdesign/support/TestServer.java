package com.graduationdesign.support;

import com.graduationdesign.service.ServerServiceImpl;

public class TestServer {
	public static void main(String[] args) {
		ServerServiceImpl serverServiceImpl = new ServerServiceImpl();
		serverServiceImpl.startServer();
	}

}
