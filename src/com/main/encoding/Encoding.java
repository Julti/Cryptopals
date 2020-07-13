package com.main.encoding;

public class Encoding {
	static char[] baseHex= {'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};
	
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
}
