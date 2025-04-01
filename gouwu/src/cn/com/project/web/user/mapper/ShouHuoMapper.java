package cn.com.project.web.user.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import cn.com.project.web.user.domain.ShouHuo;
@Repository("shouHuoMapper")
public interface ShouHuoMapper {
	
	List<ShouHuo> selectAdd(Integer id);
	
	void updateNoMr(Integer id);
	
	void updateMr(Integer id);
	
    void deleteByPrimaryKey(Integer id);

    void insert(ShouHuo record);

    void insertSelective(ShouHuo record);

    ShouHuo selectByPrimaryKey(Integer id);

    void updateByPrimaryKeySelective(ShouHuo record);

    void updateByPrimaryKey(ShouHuo record);
}