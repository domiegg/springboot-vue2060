package cn.com.project.shangpin.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import cn.com.project.shangpin.domain.ShangPin;
@Repository("shangPinMapper")
public interface ShangPinMapper {
	public List<ShangPin> select(ShangPin sp);
	
	void deleteByPrimaryKey(Integer id);

	void insert(ShangPin record);

	void insertSelective(ShangPin record);

    ShangPin selectByPrimaryKey(Integer id);
    
    List<ShangPin> selectByMid(Integer id);
    
    List<ShangPin> selectCount(ShangPin record);

    void updateByPrimaryKeySelective(ShangPin record);

    void updateByPrimaryKey(ShangPin record);
}