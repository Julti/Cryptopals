package com.main.base64;

import java.util.ArrayList;

public class Base16 {
	static String base16Map ="0123456789abcdef";
	public static String byteArrayToString(byte[] source) {
		String x = "";
		for (int i = 0; i < source.length; i++) {
			x=x+getFromTable(source[i]);
		}
		return x;
	}
	public static char getFromTable(int t) {
		return base16Map.charAt(t);
	}
}
