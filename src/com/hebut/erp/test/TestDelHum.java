package com.hebut.erp.test;

import java.util.List;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.hebut.erp.model.HumanService;
import com.hebut.erp.pojo.HumInfo;
import com.hebut.erp.pojo.HumanInsert;

import junit.framework.TestCase;

public class TestDelHum extends TestCase {
	
	private BeanFactory factory;
	
	protected void setUp() throws Exception {
		factory = new ClassPathXmlApplicationContext("applicationContext.xml");
	}
	protected void tearDown() throws Exception {
	}
	
	public void testHumInfo() throws Exception{
		
//		List<HumInfo> list=HumanService.getHumInfo();
//		for(HumInfo hum:list){
//			System.out.println(hum);
//		}
//		System.out.println("----------");
		int[] aa={3,4,5};
		HumanService human=(HumanService) factory.getBean("humanService");
		
		List<HumInfo> list2=human.getHumInfo(aa);
		for(HumInfo hum:list2){
			System.out.println(hum);
		}
	}
	
	/**
	 * 测试员工信息添加
	 * @throws Exception 
	 */
	public void testAddHuman() throws Exception{
		
		HumanService humanService=(HumanService) factory.getBean("humanService");
		HumanInsert human=new HumanInsert();
		human.setName("aaaa");
		human.setSex("女");
		human.setPhone("123456");
		human.setDeptno(1);
		human.setJobid(1);
		System.out.println(humanService.addHuman(human));
	}
}
