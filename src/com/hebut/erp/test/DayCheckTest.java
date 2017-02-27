package com.hebut.erp.test;

import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.List;

import junit.framework.TestCase;

import com.hebut.erp.model.CheckService;
import com.hebut.erp.pojo.TodayCheck;

public class DayCheckTest extends TestCase {
	public void testGetTime(){
		Time ti=CheckService.getTime();
		System.out.println(ti);
	}
	public void testIsCheck(){
		String ti=CheckService.isChecked(4);
		System.out.println(ti);
	}
	public void testTodayCheck(){
		Date to=new Date(System.currentTimeMillis());
		System.out.println(to);
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		
		Timestamp today=new Timestamp(to.getTime());
		System.out.println(today);
		List<TodayCheck> list=CheckService.getTodays(to);
		for(TodayCheck tod:list){
			System.out.println(tod);
		}
	}
}
