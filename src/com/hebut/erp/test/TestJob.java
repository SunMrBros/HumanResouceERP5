package com.hebut.erp.test;

import com.hebut.erp.model.JobService;

import junit.framework.TestCase;

public class TestJob extends TestCase {
	public  void testDoinJob(){
		System.out.println(JobService.dnoInJob(15));
		
	}
	public void testJobids(){
		
		System.out.println(JobService.getJobIds());
	}
public void testJobid(){
		
		System.out.println(JobService.getJobId());
	}
}
