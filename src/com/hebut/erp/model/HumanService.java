package com.hebut.erp.model;

import java.util.List;

import com.hebut.erp.pojo.HumInfo;
import com.hebut.erp.pojo.HumanInsert;
import com.hebut.erp.pojo.HumanShow;

public interface HumanService {

	public boolean addHuman(HumanInsert human) throws Exception;

	public List<HumInfo> getHumInfo(int[] ids) throws Exception;

	public boolean isExists(String name, String pass) throws Exception;

	public HumanShow listDetail(int id) throws Exception;

	public boolean upHuman(HumanShow humanShow) throws Exception;

	public boolean delHuman(int id) throws Exception;

	public List<HumInfo> getHumInfo() throws Exception;

}
