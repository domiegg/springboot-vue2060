package cn.com.project.web.operation.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import cn.com.project.web.operation.domain.Gwc;

@Repository("gwcMapper")
public interface GwcMapper {
	
	public String selectCount(Integer id);
	
    void deleteByPrimaryKey(Integer id);
    
    void emptyGwc(Integer id);
    
    void insert(Gwc record);
    
    List<Gwc> selectByPrimaryKey(Integer id);

    void insertSelective(Gwc record);
    
    void updateByPrimaryKeySelective(Gwc record);

    void updateByPrimaryKey(Gwc record);
}