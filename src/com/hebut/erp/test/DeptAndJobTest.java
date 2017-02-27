package com.hebut.erp.test;

import java.util.List;

import junit.framework.TestCase;

import com.hebut.erp.model.DeptService;
import com.hebut.erp.pojo.DeptAndJob;

public class DeptAndJobTest extends TestCase {
	public void testInfo(){
		
		List<DeptAndJob> list=DeptService.listDeptAndJob();
		for(DeptAndJob daj:list){
			System.out.println(daj);
		}
	}
}
