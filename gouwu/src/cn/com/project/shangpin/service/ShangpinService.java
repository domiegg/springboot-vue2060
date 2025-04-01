package cn.com.project.shangpin.service;

import java.util.List;

import cn.com.project.shangpin.domain.GongGao;
import cn.com.project.shangpin.domain.LeiBie;
import cn.com.project.shangpin.domain.ShangPin;
import cn.com.project.web.user.domain.PingJia;

public interface ShangpinService {
	public void insert(ShangPin sp)throws Exception;
	public ShangPin selectByPrimaryKey(Integer id)throws Exception;
	public List<ShangPin> select(ShangPin sp)throws Exception;
	public List<LeiBie> selectLb(LeiBie lb)throws Exception;
	public List<LeiBie> selectAllLb()throws Exception;
	public void updateByPrimaryKey(ShangPin record)throws Exception;
	void deleteByPrimaryKey(Integer id);
	public void insertLb(LeiBie lb)throws Exception;
	void deleteLb(Integer id);
	public List<ShangPin> selectByMid(Integer id)throws Exception;
	List<PingJia> select(PingJia pj);
	void deletePl(Integer id);
	void insert(GongGao record);
	
	GongGao selectByGg(Integer id);
	 void updateGg(GongGao record);
    List<GongGao> selectGgList(GongGao record);
    void deleteByGg(Integer id);
    List<ShangPin> selectCount(ShangPin record);
}
