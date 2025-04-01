package cn.com.project.web.operation.service;

import java.util.List;

import cn.com.project.web.operation.domain.Collect;
import cn.com.project.web.operation.domain.Gwc;


public interface OperationService {
	
	void insert(Gwc gwc)throws Exception;
    
	List<Gwc> selectByPrimaryKey(Integer id)throws Exception;
	
	public String selectCount(Integer id)throws Exception;
	
	void deleteByPrimaryKey(Integer id)throws Exception;
	
	void emptyGwc(Integer id)throws Exception;
	
	 void insert(Collect record);
	 List<Collect> collectList(Integer id);
	 void deleteCollect(Integer id);
}
