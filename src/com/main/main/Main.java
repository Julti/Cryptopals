package com.main.main;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import com.main.base64.Base16;
import com.main.base64.Base64;
import com.main.encoding.Control;
import com.main.encoding.Encoding;
import com.main.encoding.Utils;

public class Main {

	public static void main(String[] args) {
		set1Challenge1();
		set1Challenge2();
		set1Challenge3();
		System.out.println("Set 1 Challenge 4");
		set1Challenge4();
		set1Challenge5();
		set1Challenge6();
		//System.out.println(Scoring.score("Yesterday I saw a red point on the base"));
	}
	public static void set1Challenge1() {
		String a = "49276d206b696c6c696e6720796f757220627261696e206c696b65206120706f69736f6e6f7573206d757368726f6f6d";
		byte [] bytesFromSource = Base16.stringAsByteArrayHex16(a);
		System.out.println(Base64.fromHexToBase64(bytesFromSource));
	}
	public static void set1Challenge2() {
		String a = "1c0111001f010100061a024b53535009181c";
		String b = "686974207468652062756c6c277320657965";
		System.out.println(Base16.byteArrayToString(Encoding.fixedXOR(Base16.stringAsByteArrayHex16(a), Base16.stringAsByteArrayHex16(b))));
	}
	public static void set1Challenge3() {
		String a ="1b37373331363f78151b7f2b783431333d78397828372d363c78373e783a393b3736";
		Control c =Encoding.checkXorOverTable(Base16.stringAsByteArrayHex16(a));
		System.out.println(c.s+" "+c.c);
	}
	public static void set1Challenge4() {
		try {
			Scanner s = new Scanner(new File("./rsc/4.txt"));
			ArrayList<Control> c = new ArrayList<Control>();
			while(s.hasNext()) {
				String x = s.nextLine();
				c.add(Encoding.checkXorOverTable(Base16.stringAsByteArrayHex16(x)));
			}
			s.close();
			String ans ="";
			double min = Double.MAX_VALUE;
			for (int i = 0; i < c.size(); i++) {
				if(c.get(i).score<=min) {
					ans=c.get(i).s;
					min = c.get(i).score;
				}
			}
			System.out.println(ans);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void set1Challenge5() {
		String s = "Burning 'em, if you ain't quick and nimble I go crazy when I hear a cymbal";
		String key = "ICE";
		byte[] ct = Encoding.encodeXORFixedKey(Encoding.stringAsByteArray(s), Encoding.stringAsByteArray(key));
		System.out.println(Base16.byteAsciiArrayToString(ct));
	}
	public static void set1Challenge6() {
	
		try {
			Scanner s = new Scanner(new File("./rsc/6.txt"));
			String in = "";
			while(s.hasNext()) {
				in+= s.nextLine();
			}
			Encoding.findKeySize(in);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			}
}
