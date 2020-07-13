package com.main.encoding;

import com.main.base64.Base16;

public class Encoding {
	static char[] baseHex= {'0','1','2','3','4','5','6','7','8','9','a','b','c','d','e','f'};
	static char[] table = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z','A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
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
	public static byte[]  fixedXOR(byte[] a,byte b) {
		byte[] c = new byte[a.length];
		for (int i = 0; i < c.length-1; i+=2) {
			c[i]=(byte) ((a[i]<<4|a[i+1])^b);
		}
		return c;
	}
	public static void checkXorOverTable(byte[] a) {
		String winner = "";
		char v = ' ';
		double base = Double.MAX_VALUE;
		for (int i = 0; i < table.length; i++) {
			byte[] checked = fixedXOR(a,(byte)table[i]);
			String response=Base16.hexToString(checked);
			double score = Scoring.score(response);
			System.out.println(response+" "+score);
			if(score<=base) {
				base = score;
				winner = response;
				v =table[i];
			}
		}
		System.out.println(winner+"::"+v);
	}
}
