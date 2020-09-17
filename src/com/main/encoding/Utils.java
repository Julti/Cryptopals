package com.main.encoding;

public class Utils {
	public static int computeHammingDistance(String a, String b) {
		byte[] abytes = Encoding.stringAsByteArray(a);
		byte[] bbytes = Encoding.stringAsByteArray(b);
		int hammDistance =0;
		for (int i = 0; i < bbytes.length; i++) {
			int x = (abytes[i]^bbytes[i]);
			if(x%2!=0) {
				hammDistance+=1;
				x--;
			}
			while(x>0) {
				x=x-((int)Math.pow(2, (int)(Math.log10(x)/Math.log10(2))));
				hammDistance+=1;
			}
		}
		return hammDistance;
	}
}
