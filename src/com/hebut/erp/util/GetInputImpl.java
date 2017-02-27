package com.hebut.erp.util;

import java.util.InputMismatchException;
import java.util.Scanner;

public class GetInputImpl extends GetInput {

	//��input ��ɵ���ģʽ.
	private static GetInputImpl instance=null;
	
	//˽�й��췽��
	
	private GetInputImpl(){}
	
	//���нӿ�
	public static GetInputImpl getInstance(){
		
		if(instance==null){
			return instance=new GetInputImpl();
		}else{
			return instance;
		}
		
	}
	
	@Override
	public String getString() {
		Scanner sc = getScanner();
		return sc.next();

	}

	
	private Scanner getScanner() {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		return sc;
	}

	public Long getLong() {
		// TODO Auto-generated method stub
		Scanner sc = getScanner();
		return sc.nextLong();
	}

	@Override
	public int getInt() {
		Scanner sc = getScanner();
		int num = -1;
		do {
			try {
				num = sc.nextInt();
			} catch (InputMismatchException e) {

				System.out.println("Age must be a number");
				return num;
			}
			return num;
		} while (num < 0);
	}
}
