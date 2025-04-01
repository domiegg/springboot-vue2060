package cn.com.project.web.operation.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.com.project.web.operation.domain.Collect;
import cn.com.project.web.operation.domain.Gwc;
import cn.com.project.web.operation.mapper.CollectMapper;
import cn.com.project.web.operation.mapper.GwcMapper;
import cn.com.project.web.operation.service.OperationService;
@Service("operationService")
public class OperationServiceImpl implements OperationService {
	@Autowired
	private GwcMapper gwcMapper;
	@Autowired
	private CollectMapper collectMapper;
	
	public void insert(Gwc gwc) throws Exception {
		gwcMapper.insert(gwc);
	}

	public  List<Gwc> selectByPrimaryKey(Integer id) throws Exception {
		 List<Gwc> gwcList = gwcMapper.selectByPrimaryKey(id);
		return gwcList;
	}

	public String selectCount(Integer id) throws Exception {
		String count = gwcMapper.selectCount(id);
		return count;
	}

	public void deleteByPrimaryKey(Integer id) throws Exception {
		gwcMapper.deleteByPrimaryKey(id);
	}

	public void emptyGwc(Integer id) throws Exception {
		gwcMapper.emptyGwc(id);		
	}

	public List<Collect> collectList(Integer id) {
		List<Collect> collectList = collectMapper.selectByPrimaryKey(id);
		return collectList;
	}

	public void insert(Collect record) {
		collectMapper.insert(record);
	}

	public void deleteCollect(Integer id) {
		collectMapper.deleteByPrimaryKey(id);
	}

}
