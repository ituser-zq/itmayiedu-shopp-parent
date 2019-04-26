package com.itmayiedu.controller;

import java.net.URL;
import java.net.URLDecoder;
import java.net.URLEncoder;

public class UrlTest {

	 public static void main(String[] args) {
		String userName="http://www.itmayiedu.com/userName=12345+6444";
		String userNameEncode = URLEncoder.encode(userName);
		System.out.println("userNameEncode:"+userNameEncode);
		String userNamedeCode=URLDecoder.decode(userNameEncode);
		System.out.println("userNamedeCode:"+userNamedeCode);
	}
	
}
