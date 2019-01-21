package com.wajahat.hackerrank.learn.functional.lamda;

public class SampleLambdaUsage {
	
	public static void main(String[] args) {
		System.out.println(process("Hello World", str->str.toLowerCase()));
	}
	
	private static String process(String str, Processor processor) {
		return processor.process(str);
	}
}
