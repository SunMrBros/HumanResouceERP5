package com.hebut.erp.test;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import junit.framework.TestCase;

import com.hebut.erp.model.SalaryService;
import com.hebut.erp.pojo.Salary;
import com.hebut.erp.pojo.SalaryInfo;
import com.hebut.erp.pojo.Setting;

public class SalaryTest extends TestCase{
	public void testQuerySalary() throws ParseException{
		String strstart="2015-3-25";
		String strend="2015-4-25";
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		Date start=new Date(sdf.parse(strstart).getTime());
		Date end=new Date(sdf.parse(strend).getTime());
		List<Salary> list=SalaryService.querySal(1);
		if(list==null)System.out.println("error");
		for(Salary sal:list){
			System.out.println(sal);
		}
		System.out.println("-------------");
		List<Salary> list2=SalaryService.querySal(3,start,end);
		if(list2==null)System.out.println("error");
		for(Salary sal:list2){
			System.out.println(sal);
		}
		System.out.println("end");
	}
	
	public void testSalinfo(){
		List<SalaryInfo> list2=SalaryService.getSalInfo();
		for(SalaryInfo info:list2){
			System.out.println(info);
		}
		
	}
	public void testSalarySetting(){
		
		Setting set=SalaryService.initSal();
		System.out.println(set);
		
	}
public void testSalaryInit(){
		
		String set=SalaryService.salInitJson();
		System.out.println(set);
		
	}
}
