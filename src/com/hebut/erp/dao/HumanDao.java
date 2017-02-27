package com.hebut.erp.dao;

import java.util.List;

import com.hebut.erp.pojo.HumInfo;
import com.hebut.erp.pojo.HumanInsert;

public interface HumanDao {

	List<HumInfo> getHumanInfo(int[] empnos);

	/**
	 * 判断员工是否存在
	 * @param name
	 * @param pass
	 * @return
	 */
	boolean isEmpExists(String name, String pass);

	/**
	 * 根据用户编号删除用户
	 * @param empno
	 * @return
	 */
	boolean delHuman(int empno);

	/**
	 * 添加员工信息
	 * @param human
	 * @return 
	 */
	boolean addHuman(HumanInsert human);

}
