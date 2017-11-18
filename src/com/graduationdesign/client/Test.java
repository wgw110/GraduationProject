package com.graduationdesign.client;

import java.math.BigDecimal;

public class Test {
	public static void main(String[] args) {
		double   f   =   111231.5585;  
		BigDecimal   b   =   new   BigDecimal(f);  
		double   f1   =   b.setScale(2,   BigDecimal.ROUND_HALF_UP).doubleValue();
		double f2=new BigDecimal(f).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
		System.out.println(f2);
	}

}
