package com.main.main;

import com.main.base64.Base16;
import com.main.base64.Base64;
import com.main.encoding.Encoding;

public class Main {

	public static void main(String[] args) {
		set1Challenge1();
		set1Challenge2();
	}
	public static void set1Challenge1() {
		String a = "49276d206b696c6c696e6720796f757220627261696e206c696b65206120706f69736f6e6f7573206d757368726f6f6d";
		byte [] bytesFromSource = Encoding.stringAsByteArray(a);
		System.out.println(Base64.fromHexToBase64(bytesFromSource));
	}
	public static void set1Challenge2() {
		String a = "1c0111001f010100061a024b53535009181c";
		String b = "686974207468652062756c6c277320657965";
		System.out.println(Base16.byteArrayToString(Encoding.fixedXOR(Encoding.stringAsByteArray(a), Encoding.stringAsByteArray(b))));
	}
}
