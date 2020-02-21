package com.newdao;

import java.io.InputStream;

import com.alibaba.fastjson.JSONReader;
import com.alibaba.fastjson.JSONWriter;

public class JsonConfing {
	static String jsonpath="D:\\Eclipse\\workspaces_1\\windows222\\src/config.json";
	
	
	
	public static void main(String[] args) {
//		InputStream input = jsonobject.class.getResourceAsStream(tempFilePath);
		
		InputStream input=JSONReader.class.getResourceAsStream(jsonpath);
		
		
		System.out.println(input.toString());
		
	}
	
	
	
}
