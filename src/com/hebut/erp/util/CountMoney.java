package com.hebut.erp.util;

import java.sql.Date;
import java.util.List;

import com.hebut.erp.model.SalaryService;
import com.hebut.erp.pojo.Salary;
import com.hebut.erp.pojo.SalaryDTO;

public class CountMoney {
	/**
	 * ·¢¹¤×Ê
	 * 
	 * @param empnos
	 * @return
	 */
	public static float faGongzi(int[] empnos) {
		Date lastSalDate = TimeUtil.getSalDate();
		List<SalaryDTO> list = SalaryService.getSalCheckInfo(lastSalDate,empnos);
		float count=0;
		float finalsalary=0;
		Salary salary = new Salary();
		for (SalaryDTO saldto : list) {
			finalsalary=saldto.getMoney()-saldto.getFakuan()+saldto.getQuanqin()+saldto.getOther();
			salary.setEmpno(saldto.getEmpno());
			salary.setOther(saldto.getFakuan());
			salary.setSalary(saldto.getMoney());
			salary.setFinalsalary(finalsalary);
			salary.setSal_date(new Date(System.currentTimeMillis()));
			if (SalaryService.insertSalary(salary)) {
				count+=finalsalary;
				continue;
			}else{
				return -1;
			}
		}
		return count;
	}
}
