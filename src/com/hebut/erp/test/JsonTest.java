package com.hebut.erp.test;

import java.util.List;

import junit.framework.TestCase;

import com.hebut.erp.model.DeptService;
import com.hebut.erp.pojo.Dept;

public class JsonTest extends TestCase {
	public void testJson(){
		
		List<Dept> list=DeptService.listDept();
		for(Dept d:list){
			System.out.println(d);
		}
		System.out.println("-----------------------");
		
	
		
	}
}
