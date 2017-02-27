package com.hebut.erp.test;

import java.util.List;

import junit.framework.TestCase;

import com.hebut.erp.model.QueryService;
import com.hebut.erp.model.impl.HumanServiceImpl;
import com.hebut.erp.pojo.HumanDTO;
import com.hebut.erp.pojo.HumanShow;

public class HumanInfoQueryTest extends TestCase {
	public void testQueryById() {

		List<HumanDTO> list = QueryService.queryById(2);
		for (HumanDTO human : list) {

			System.out.println(human);
		}
	}

	public void testQueryByName() {

		List<HumanDTO> list = QueryService.queryByName("�Űٺ�");
		for (HumanDTO human : list) {

			System.out.println(human);
		}
	}

	public void testDetail() {
		HumanShow human = HumanServiceImpl.listDetail(1);
		System.out.println(human);
	}

	public void testQueryByJobId() {

		List<HumanDTO> list = QueryService.queryByJobId(4);
		for (HumanDTO human : list) {

			System.out.println(human);
		}
	}
}
