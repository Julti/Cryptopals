package com.main.encoding;

public class Encoding {
	static char[] baseHex= {'0','1','2','3','4','5','6','7','8','9','a','b','c','d','e','f'};
	
	public static byte[] stringAsByteArray(String src) {
		byte[] out = new byte[src.length()];
		for (int i = 0; i < src.length(); i++) {
			for (int j = 0; j < baseHex.length; j++) {
				if(src.charAt(i)==baseHex[j]) {
					out[i]=(byte)j;
				}
			}
		}
		return out;
	}
	public static byte[]  fixedXOR(byte[] a,byte[] b) {
		byte[] c = new byte[a.length];
		for (int i = 0; i < c.length; i++) {
			c[i]=(byte) (a[i]^b[i]);
		}
		return c;
	}
}
