package com.graduation.message301;

import java.util.Random;

public class DataUtils {
	private static Random random = new Random();
	private static final int MAX_NUMBER = 100;

	/**
	 * 	�����0��100��ȡ��
	 * @return 
	 */
	public static int getRandomData() {
		return random.nextInt(MAX_NUMBER);
	}

}
