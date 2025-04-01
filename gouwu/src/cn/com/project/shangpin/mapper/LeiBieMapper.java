package cn.com.project.shangpin.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import cn.com.project.shangpin.domain.LeiBie;

@Repository("leiBieMapper")
public interface LeiBieMapper {
	
	public List<LeiBie> selectLb(LeiBie lb)throws Exception;
	
	public List<LeiBie> selectAllLb()throws Exception;
	
    void deleteByPrimaryKey(Integer id);

    void insert(LeiBie record);

    void insertSelective(LeiBie record);

    LeiBie selectByPrimaryKey(Integer id);

    void updateByPrimaryKeySelective(LeiBie record);

    void updateByPrimaryKey(LeiBie record);
}