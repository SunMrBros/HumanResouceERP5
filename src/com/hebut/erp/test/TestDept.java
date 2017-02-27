package com.hebut.erp.test;

import java.util.List;

import junit.framework.TestCase;

import com.hebut.erp.model.DeptService;
import com.hebut.erp.pojo.Dept;

public class TestDept extends TestCase{
	public void testListDept(){
		
		List<Dept> list=DeptService.listDept();
		for(Dept d:list){
			System.out.println(d);
		}
	}

}
