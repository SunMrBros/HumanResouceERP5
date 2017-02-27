package com.hebut.erp.test;

import java.io.File;
import java.sql.Connection;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import junit.framework.TestCase;

import com.hebut.erp.model.DeptService;
import com.hebut.erp.model.JobService;
import com.hebut.erp.model.ListAllHumanInfo;
import com.hebut.erp.model.LoginModel;
import com.hebut.erp.pojo.Dept;
import com.hebut.erp.pojo.DeptDTO;
import com.hebut.erp.pojo.HumanDTO;
import com.hebut.erp.util.ChangePass;
import com.hebut.erp.util.DbUtil;
import com.hebut.erp.util.GetPrivilege;
import com.hebut.erp.util.SaveFile;

public class ActionTest extends TestCase {
	
	//测试listDept\
	
	public void testJobadd(){
		
		System.out.println(JobService.addJob(1, "销售组长"));
	}
	
public void testListDept() {
	
	
		List<Dept> list=new ArrayList<Dept>();

		list=DeptService.listDept();
		for(Dept dept:list){
			
			System.out.println(dept);
		}
	}
	public void testAddDept() {
		

		DeptService.addDept(new DeptDTO("人事部","北京"));
	}

	public void testUpload() {

		File f = new File("E:/Tel.txt");
		System.out.println(SaveFile.save("G:/a", f));
	}

	public void testLogin() {

		System.out.println(LoginModel.checkUser("admin", "admin"));
	}

	public void testUtil() {

		Connection conn = DbUtil.getConn();
		System.out.println(conn);
	}

	public void testListEmp() {
		int pageNow = 1;
		List<HumanDTO> list = ListAllHumanInfo.listEmp(pageNow);
		if (list != null) {
			for (HumanDTO human : list) {
				System.out.println(human);
			}

		} else {
			System.out.println("error");
		}

	}

	public void testAdd() throws ParseException {

	}

	public void testChagepass() {

		if (ChangePass.changePass(1, "whathappend")) {
			
			
			System.out.println("succ");
		} else {
			System.out.println("error");
		}
	}

	public void testGetPrivilege() {

		GetPrivilege getp = new GetPrivilege();
		System.out.println(getp.getPrivilege(14));
	}

}
