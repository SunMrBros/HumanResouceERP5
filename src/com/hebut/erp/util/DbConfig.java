package com.hebut.erp.util;


import java.io.InputStream;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class DbConfig {
	//这里采用单例模式
	private JdbcConfig jdbcConfig=new JdbcConfig();
	private static DbConfig instance=null;
	public static synchronized DbConfig getInstance(){
		
		if(instance==null){
			instance= new DbConfig();
		}
		return instance;
	}
	
	private DbConfig () {
		
		SAXReader reader=new SAXReader();
		InputStream in=null;
		in = Thread.currentThread().getContextClassLoader().getResourceAsStream("DBConfig.xml");
		Document doc=null;
		try {
			doc=reader.read(in);
			Element root=doc.getRootElement();
			jdbcConfig.setDriver(root.element("driver").getText());
			jdbcConfig.setUrl(root.element("url").getText());
			jdbcConfig.setName(root.element("name").getText());
			jdbcConfig.setPass(root.element("pass").getText());
			
		
		} catch (DocumentException e) {
			System.out.println("读取xml文件错误!");
			e.printStackTrace();
		}
		
	}
	public JdbcConfig getConfig(){
		return jdbcConfig;
	}
	

}
