package com.main.base64;

import java.util.ArrayList;

public class Base64 {
	static String base64Map = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/";
	public static String fromHexToBase64(byte[] source) {
		ArrayList<Byte> output = new ArrayList<Byte>();
		for (int i = 0; i <= source.length-3; i+=3) {
			byte a = (byte) (source[i]<<2&0x3F);
			byte b = (byte) (source[i+1]>>2&0x3F);
			byte n = (byte) (a|b);
			output.add(n);
			byte c = (byte) (source[i+1]<<4&0x3F);
			byte d = (byte) (source[i+2]&0x3F);
			n = (byte) (c|d);
			output.add(n);
		}
		return byteArrayToString(output);
	}
	public static String byteArrayToString(ArrayList<Byte> source) {
		String x = "";
		for (int i = 0; i < source.size(); i++) {
			x=x+getFromTable(source.get(i));
		}
		return x;
	}
	public static char getFromTable(int t) {
		return base64Map.charAt(t);
	}
}
