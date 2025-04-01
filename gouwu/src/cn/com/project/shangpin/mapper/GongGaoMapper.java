package cn.com.project.shangpin.mapper;

import java.util.List;

import cn.com.project.shangpin.domain.GongGao;

public interface GongGaoMapper {
	void deleteByPrimaryKey(Integer id);

    void insert(GongGao record);

    void insertSelective(GongGao record);

    GongGao selectByPrimaryKey(Integer id);
    
    List<GongGao> selectGgList(GongGao record);

    void updateByPrimaryKeySelective(GongGao record);

    void updateByPrimaryKey(GongGao record);
}