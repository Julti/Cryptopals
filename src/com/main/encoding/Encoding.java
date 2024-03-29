package com.main.encoding;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Map.Entry;

import com.main.base64.Base16;

public class Encoding {
	static char[] baseHex= {'0','1','2','3','4','5','6','7','8','9','a','b','c','d','e','f'};
	static char[] table = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z','A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z','0','1','2','3','4','5','6','7','8','9',' ',':'};
	
	public static byte[] stringAsByteArray(String src) {
		byte[] out = new byte[src.length()];
		for (int i = 0; i < src.length(); i++) {
			out[i]=(byte)src.charAt(i);	
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
	public static byte[]  fixedXORByte(byte[] a,byte b) {
		byte[] c = new byte[a.length];
		for (int i = 0; i < c.length-1; i+=2) {
			c[i]=(byte) (a[i]^b);
		}
		return c;
	}
	public static Control checkXorOverTable(byte[] a) {
		String winner = "";
		char v = ' ';
		double base = Double.MAX_VALUE;
		for (int i = 0; i < table.length; i++) {
			byte[] checked = fixedXOR(a,(byte)table[i]);
			String response=Base16.hexToString(checked);
			double score = Scoring.score(response);
			if(score<=base) {
				base = score;
				winner = response;
				v =table[i];
			}
		}
		return new Control(winner, v, base);
	}
	public static Control checkXorOverTableByte(byte[] a) {
		String winner = "";
		char v = ' ';
		double base = Double.MAX_VALUE;
		for (int i = 0; i < table.length; i++) {
			byte[] checked = fixedXORByte(a,(byte)table[i]);
			String response=new String(checked);
			double score = Scoring.score(response);
			if(score<=base) {
				base = score;
				winner = response;
				v =table[i];
			}
		}
		return new Control(winner, v, base);
	}
	public static byte[] encodeXORFixedKey(byte[]plaintext,byte[]key) {
		int MAXKEYSIZE =key.length;
		int currentKeyIndex = 0;
		byte[] ct = new byte[plaintext.length];
		for (int i = 0; i < plaintext.length; i++) {
			ct[i]=(byte) (plaintext[i]^key[currentKeyIndex]);
			currentKeyIndex++;
			if(currentKeyIndex==MAXKEYSIZE) {
				currentKeyIndex=0;
			}
		}
		return ct;
	}
	public static ArrayList<Entry<Integer,Double>> findKeySize(String in) {
		int MINKEYSIZE =2;
		int MAXKEYSIZE = 40;
		double keysize = 2.0;
		Hashtable<Integer, Double> keySizesMap = new Hashtable<Integer, Double>();
		for (int i = MINKEYSIZE; i <=MAXKEYSIZE; i++) {
			String a =in.substring(0,i);
			String b = in.substring(i,2*i);
			String c =in.substring(2*i,3*i);
			String d = in.substring(3*i,4*i);
			int hd = Utils.computeHammingDistance(a, b)+Utils.computeHammingDistance(a, c)+Utils.computeHammingDistance(a, d)+Utils.computeHammingDistance(b, c)+Utils.computeHammingDistance(b, d)+Utils.computeHammingDistance(c, b);
			double t =hd/keysize;
			//System.out.println("KEYSIZE::"+i+" HD:: "+(t));
			keySizesMap.put(i, t);
			keysize++;
		}
		ArrayList<Entry<Integer,Double>> map=new ArrayList<Entry<Integer,Double>>(keySizesMap.entrySet());
		return map;
	}
	
}