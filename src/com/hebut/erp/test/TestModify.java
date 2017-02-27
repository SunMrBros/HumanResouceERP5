package com.hebut.erp.test;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import junit.framework.TestCase;

import com.hebut.erp.model.impl.HumanServiceImpl;
import com.hebut.erp.pojo.HumanShow;

public class TestModify extends TestCase {
	public void testModify(){
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		String strdate= "2009-2-2";
		HumanShow human=null;
		try {
			 human =new HumanShow( 1, "������", "��","9999999999",
					"2345678@qq.com", "����", "Ⱥ��", "ר��",
					"����","��", "������������", "��ע����",
					4, 3,new Date(sdf.parse(strdate).getTime()));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HumanServiceImpl.upHuman(human);
	}
}
