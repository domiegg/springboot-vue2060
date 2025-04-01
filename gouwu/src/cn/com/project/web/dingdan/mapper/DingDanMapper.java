package cn.com.project.web.dingdan.mapper;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import cn.com.project.web.dingdan.domain.DingDan;
@Repository("dingDanMapper")
public interface DingDanMapper {
	
	List<DingDan> selectByPrimaryKey(Integer id);
	
	DingDan selectById(Integer id);
	
	List<DingDan> selectByState(Map<String,Integer> paramMap);
	
	List<DingDan> select(DingDan dd);
	
	int selectCountDfh(Integer id);
	
	int selectCountDsh(Integer id);
	
	int selectCountDpj(Integer id);
	
	void deleteByPrimaryKey(Integer id);

    void insert(DingDan record);

    void insertSelective(DingDan record);

    void updateByPrimaryKeySelective(DingDan record);

    void updateState(DingDan record);
}