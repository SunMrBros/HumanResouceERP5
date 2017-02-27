package com.hebut.erp.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class SaveFile {
	public static boolean save(String path, File file) {
		FileOutputStream fos = null;
		FileInputStream fis = null;
		boolean flag = false;
		try {
			fos = new FileOutputStream(path);

			fis = new FileInputStream(file);

			byte[] bytes = new byte[1024];
			int len = 0;
			while ((len = fis.read(bytes)) != -1) {
				fos.write(bytes, 0, len);
			}
			flag = true;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			flag = false;
			e.printStackTrace();
		} finally {
			try {
				if (fos != null) {
					fos.flush();
					fos.close();
				}
				if (fis != null) {
					fis.close();
				}

			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return flag;
	}

}
