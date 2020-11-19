package com.main.encoding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Hashtable;
import java.util.Map;

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
	public static ArrayList<Map.Entry<Integer, Double>> sortDict(Hashtable<Integer,Double> map){
		ArrayList<Map.Entry<Integer, Double>> l = new ArrayList(map.entrySet());
	       Collections.sort(l, new Comparator<Map.Entry<Integer, Double>>(){
	         public int compare(Map.Entry<Integer, Double> a, Map.Entry<Integer, Double> b) {
	            return a.getValue().compareTo(b.getValue());
	        }});
	    return l;
	}
	public static byte[][] generateMatrix(byte[] input,int size){
		byte [][] broken = new byte[input.length/size][size];
		for (int i = 0; i < broken.length; i++) {
			for (int j = 0; j < broken[i].length; j++) {
				broken[i][j] = input[j+(size*i)];
			}
		}
		return broken;
	}
	public static byte[][] transposeMatrix(byte[][] input){
		byte [][] transpose = new byte[input[0].length][input.length];
		for (int i = 0; i < transpose.length; i++) {
			for (int j = 0; j < transpose[i].length; j++) {
				transpose[i][j] = input[j][i];
			}
		}
		return transpose;
	}
}
