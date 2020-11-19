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
	public static byte[] fromAsciiToBase64(byte[] source) {
		ArrayList<Byte> map = new ArrayList<Byte>();
		for (int i = 0; i < source.length; i+=4) {
			map.add((byte)base64Map.charAt((int)(source[i]>>2)));
			map.add((byte)base64Map.charAt((int)(source[i]<<4&0x30)|(int)(source[i+1]>>4&0x0F)));
			map.add((byte)base64Map.charAt((int)(source[i+1]<<2&0x3C)|(int)(source[i+2]>>6&0x03)));
			map.add((byte)base64Map.charAt((int)(source[i+2]&0x3F)));
		}
		byte[] s =new byte[map.size()];
		for (int i = 0; i < s.length; i++) {
			s[i]=map.get(i);
		}
		return s;
	}
	public static byte[] fromBase64ToAscii(String base64source) {
		ArrayList<Byte> output = new ArrayList<Byte>();
		for (int i = 0; i <= base64source.length()-4; i+=4) {
			byte a = (byte) (base64Map.indexOf(base64source.charAt(i))<<2&0x3F);
			byte b = (byte) (base64Map.indexOf(base64source.charAt(i+1))>>6&0x3F);
			byte n = (byte) (a|b);
			output.add(n);
			byte c = (byte) (base64Map.indexOf(base64source.charAt(i+1))<<4&0x3F);
			byte d = (byte) (base64Map.indexOf(base64source.charAt(i+2))>>4&0x3F);
			n = (byte) (c|d);
			output.add(n);
			byte e = (byte) (base64Map.indexOf(base64source.charAt(i+2))<<2&0x3F);
			byte f = (byte) (base64Map.indexOf(base64source.charAt(i+3))&0x3F);
			n = (byte) (e|f);
			output.add(n);
		}
		byte[] resp = new byte[output.size()];
		for (int i = 0; i < resp.length; i++) {
			resp[i]=output.get(i);
		}
		return resp;
	}
	public static String byteArrayToString(ArrayList<Byte> source) {
		String x = "";
		for (int i = 0; i < source.size(); i++) {
			x=x+getFromTable(source.get(i));
		}
		return x;
	}
	public static String byteArrayToString(byte[] source) {
		String x = "";
		for (int i = 0; i < source.length; i++) {
			x=x+getFromTable(source[i]);
		}
		return x;
	}
	public static char getFromTable(int t) {
		return base64Map.charAt(t);
	}
}
