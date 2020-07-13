package com.main.encoding;

import java.util.HashSet;
import java.util.Hashtable;
import java.util.Set;

public class Scoring {
	static Hashtable<Character, Double> frequency = new Hashtable<Character, Double>();
	
	public static  double score(String v) {
		double score = 0.0;
		buildFrequencyTable();
		v = v.toLowerCase().replaceAll(" ", "");
		Hashtable<Character, Integer> freqOnString = new Hashtable<Character, Integer>();
		for (int i = 0; i < v.length(); i++) {
			if(freqOnString.containsKey(v.charAt(i))) {
				freqOnString.put(v.charAt(i), freqOnString.get(v.charAt(i))+1);
			}else {
				freqOnString.put(v.charAt(i),1);
			}
		}
		Set<Character> set = freqOnString.keySet();
		for(Character c:set) {
			if(frequency.containsKey(c)) {
				double freqONStr = (double)freqOnString.get(c)/(double)v.length();
				score+= Math.pow(frequency.get(c)-freqONStr, 2);
			}else {
				score+=1;
			}
		}
		return score;
	}
	public static void buildFrequencyTable() {
		frequency.put('e',0.1202);
		frequency.put('t',0.0910);
		frequency.put('a',0.0812);
		frequency.put('o',0.0768);
		frequency.put('i',0.0731);
		frequency.put('n',0.0695);
		frequency.put('s',0.0628);
		frequency.put('r',0.0602);
		frequency.put('h',0.0592);
		frequency.put('d',0.0432);
		frequency.put('l',0.0398);
		frequency.put('u',0.0288);
		frequency.put('c',0.0271);
		frequency.put('m',0.0261);
		frequency.put('f',0.0230);
		frequency.put('y',0.0211);
		frequency.put('w',0.0209);
		frequency.put('g',0.0203);
		frequency.put('p',0.0182);
		frequency.put('b',0.0149);
		frequency.put('v',0.0111);
		frequency.put('k',0.0069);
		frequency.put('x',0.0017);
		frequency.put('q',0.0011);
		frequency.put('j',0.0010);
		frequency.put('z',0.0007);
	}
	
}
