package com.hebut.erp.test;

import java.sql.Time;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import junit.framework.TestCase;

import com.hebut.erp.model.CheckService;
import com.hebut.erp.util.TimeUtil;

public class TestTime extends TestCase {
	public void testTime(){
		
		Time ti =CheckService.getTime();
		long ti3=ti.getTime();
		SimpleDateFormat sdf=new SimpleDateFormat("HH:mm:ss");
		Date date=new Date();
		long ti2=date.getTime();
		System.out.println(ti2);
		System.out.println(ti3);
		Time tii=Time.valueOf(sdf.format(date));
		
		System.out.println(sdf.format(date));
		System.out.println(tii+"----Time");
		System.out.println(ti+"--------Time");
		if(ti.getHours()< tii.getHours()){
			System.out.println("you late");
		}
		System.out.println("--------");
		Calendar c=Calendar.getInstance();
		int hour=c.HOUR+2;
		int min=c.MINUTE;
		int a=date.getHours();
		int aa=date.getMinutes();
		System.out.println(hour+":"+min);
		System.out.println(a+":"+aa);
		System.out.println("---------------->");
		Timestamp st=new Timestamp(System.currentTimeMillis());
		Date date1=new Date();
		
		System.out.println(date1.getMonth());
		Date today=new Date();
		System.out.println(today);
	}
	public void testLateTimes() throws ParseException{
		String strdate="2015-05-25";
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		Date date=sdf.parse(strdate);
		java.sql.Date date2=new java.sql.Date(date.getTime());
		System.out.println(date2);
		System.out.println(TimeUtil.getLateTimes(7, date2));
		System.out.println("上次发工资时间"+TimeUtil.getSalDate());
	}
}
