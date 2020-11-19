package com.main.encoding;

public class Control {
	@Override
	public String toString() {
		return "Control [s=" + s + ", c=" + c + ", score=" + score + "]";
	}
	public String s;
	public char c;
	public double score;
	public Control(String s, char c, double score) {
		super();
		this.s = s;
		this.c = c;
		this.score = score;
	}
}
