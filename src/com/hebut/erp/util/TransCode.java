package com.hebut.erp.util;

import java.io.UnsupportedEncodingException;

public class TransCode {
	public static String transCoding(String str) {  
        try {  
            return new String(str.getBytes(""), "utf-8");  
        } catch (UnsupportedEncodingException e) {  
            e.printStackTrace();  
        }  
        return str;  
    } 
}
