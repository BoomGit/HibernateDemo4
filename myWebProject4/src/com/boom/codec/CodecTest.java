package com.boom.codec;

import java.io.UnsupportedEncodingException;

import org.apache.commons.codec.binary.Base64;

public class CodecTest {
	//1.Base64����
	public static String encodeTest(String str) {
	
		Base64 base64=new Base64();
		try {
			str=base64.encodeToString(str.getBytes("UTF-8"));
		} catch (UnsupportedEncodingException e) {
		e.printStackTrace();	
		}
		System.out.println("Base64�����"+str);
		return str;
	}
	
	//2.Base64����
	public static void decodeTest(String str) {
		Base64 base64=new Base64();
		str=new String(base64.decode(str));
		System.out.println("Base64�����"+str);
	}
}
