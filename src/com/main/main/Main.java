package com.main.main;

import com.main.base64.Base64;
import com.main.encoding.Encoding;

public class Main {

	public static void main(String[] args) {
		set1Challenge1();

	}
	public static void set1Challenge1() {
		String a = "49276d206b696c6c696e6720796f757220627261696e206c696b65206120706f69736f6e6f7573206d757368726f6f6d";
		byte [] bytesFromSource = Encoding.stringAsByteArray(a.toUpperCase());
		System.out.println(Base64.fromHexToBase64(bytesFromSource));
	}

}
