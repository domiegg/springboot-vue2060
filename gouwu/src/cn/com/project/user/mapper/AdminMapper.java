package cn.com.project.user.mapper;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import cn.com.project.user.domain.Admin;
@Repository("adminMapper")
public interface AdminMapper {
	
    void deleteByPrimaryKey(Integer id);

    void insert(Admin record);

    void insertSelective(Admin record);
    public List<Admin> select(Admin record); 
    public Admin login(Map<String , String> map) throws Exception;

    void updateByPrimaryKeySelective(Admin record);

    void updateByPrimaryKey(Admin record);
    
    void updatePassword(Admin record);
}