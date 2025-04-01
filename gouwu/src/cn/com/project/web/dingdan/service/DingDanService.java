package cn.com.project.web.dingdan.service;

import java.util.List;
import java.util.Map;

import cn.com.project.web.dingdan.domain.DingDan;

public interface DingDanService {
	 void insert(DingDan dd)throws Exception;
	 
	 List<DingDan> select(DingDan dd)throws Exception;
	 
	 List<DingDan> selectByPrimaryKey(Integer id)throws Exception;
	 
	 List<DingDan> selectByState(Integer id,Integer state)throws Exception;
	 
	 int selectCountDfh(Integer id)throws Exception;
		
	 int selectCountDsh(Integer id)throws Exception;
		
	 int selectCountDpj(Integer id)throws Exception;
	 
	 DingDan selectById(Integer id);
	 void updateState(DingDan record);
	 void deleteByPrimaryKey(Integer id);
}
