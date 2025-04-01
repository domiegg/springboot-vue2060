package cn.com.project.shangpin.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.com.project.shangpin.domain.GongGao;
import cn.com.project.shangpin.domain.LeiBie;
import cn.com.project.shangpin.domain.ShangPin;
import cn.com.project.shangpin.mapper.GongGaoMapper;
import cn.com.project.shangpin.mapper.LeiBieMapper;
import cn.com.project.shangpin.mapper.ShangPinMapper;
import cn.com.project.shangpin.service.ShangpinService;
import cn.com.project.web.user.domain.PingJia;
import cn.com.project.web.user.mapper.PingJiaMapper;
@Service("shangpinService")
public class ShangpinServiceImpl implements ShangpinService {
	@Autowired
	private ShangPinMapper shangPinMapper;
	
	@Autowired
	private PingJiaMapper pingJiaMapper;
	@Autowired
	private LeiBieMapper leiBieMapper;
	@Autowired
	private GongGaoMapper gongGaoMapper;
	
	public List<ShangPin> select(ShangPin sp) throws Exception {
		List<ShangPin> spList = shangPinMapper.select(sp);
		return spList;
	}
	public List<LeiBie> selectLb(LeiBie lb) throws Exception {
		List<LeiBie> lbList = leiBieMapper.selectLb(lb);
		return lbList;
	}
	public void insert(ShangPin sp) throws Exception {
		shangPinMapper.insert(sp);
	}
	public ShangPin selectByPrimaryKey(Integer id) throws Exception {
		ShangPin sp = shangPinMapper.selectByPrimaryKey(id);
		return sp;
	}
	public void updateByPrimaryKey(ShangPin record) throws Exception {
		shangPinMapper.updateByPrimaryKey(record);
	}
	public void deleteByPrimaryKey(Integer id) {
		shangPinMapper.deleteByPrimaryKey(id);
	}
	public void deleteLb(Integer id) {
		leiBieMapper.deleteByPrimaryKey(id);
	}
	public void insertLb(LeiBie lb) throws Exception {
		leiBieMapper.insert(lb);
	}
	public List<ShangPin> selectByMid(Integer id) throws Exception {
		List<ShangPin> spList = shangPinMapper.selectByMid(id);
		return spList;
	}
	public List<PingJia> select(PingJia pj) {
		List<PingJia> plList = pingJiaMapper.select(pj);
		return plList;
	}
	public void deletePl(Integer id) {
		pingJiaMapper.deleteByPrimaryKey(id);
	}
	public List<LeiBie> selectAllLb() throws Exception {
		List<LeiBie> lbList = leiBieMapper.selectAllLb();
		return lbList;
	}
	public void deleteByGg(Integer id) {
		gongGaoMapper.deleteByPrimaryKey(id);
	}
	public void insert(GongGao record) {
		gongGaoMapper.insert(record);
	}
	public GongGao selectByGg(Integer id) {
		GongGao gg = null;
		gg = gongGaoMapper.selectByPrimaryKey(id);
		return gg;
	}
	public List<GongGao> selectGgList(GongGao record) {
		List<GongGao> ggList = gongGaoMapper.selectGgList(record);
		return ggList;
	}
	public void updateGg(GongGao record) {
		gongGaoMapper.updateByPrimaryKey(record);
	}
	public List<ShangPin> selectCount(ShangPin record) {
		List<ShangPin> countList = shangPinMapper.selectCount(record);
		return countList;
	}

}
