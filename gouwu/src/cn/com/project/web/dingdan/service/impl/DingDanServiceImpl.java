package cn.com.project.web.dingdan.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.com.project.web.dingdan.domain.DingDan;
import cn.com.project.web.dingdan.mapper.DingDanMapper;
import cn.com.project.web.dingdan.service.DingDanService;
@Service("dingDanService")
public class DingDanServiceImpl implements DingDanService {
	@Autowired
	private DingDanMapper dingDanMapper;
	
	public void insert(DingDan dd) throws Exception {
		dingDanMapper.insert(dd);
	}

	public List<DingDan> selectByPrimaryKey(Integer id) throws Exception {
		List<DingDan> selDdList = dingDanMapper.selectByPrimaryKey(id);
		return selDdList;
	}

	public int selectCountDfh(Integer id) throws Exception {
		int countDfh = dingDanMapper.selectCountDfh(id);
		return countDfh;
	}

	public int selectCountDsh(Integer id) throws Exception {
		int countDsh = dingDanMapper.selectCountDsh(id);
		return countDsh;
	}

	public int selectCountDpj(Integer id) throws Exception {
		int countDpj = dingDanMapper.selectCountDpj(id);
		return countDpj;
	}

	public List<DingDan> selectByState(Integer id,Integer state)throws Exception {
		Map<String,Integer> paramMap = new HashMap<String,Integer>();
		paramMap.put("id", id);
		paramMap.put("state", state);
		List<DingDan> selDdList = dingDanMapper.selectByState(paramMap);
		return selDdList;
	}

	public List<DingDan> select(DingDan dd) throws Exception {
		List<DingDan> ddList = dingDanMapper.select(dd);
		return ddList;
	}

	public DingDan selectById(Integer id) {
		DingDan dd = dingDanMapper.selectById(id);
		return dd;
	}

	public void updateState(DingDan record) {
		dingDanMapper.updateState(record);
	}

	public void deleteByPrimaryKey(Integer id) {
		dingDanMapper.deleteByPrimaryKey(id);
	}

}
