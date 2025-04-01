package cn.com.project.web.user.mapper;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import cn.com.project.web.user.domain.User;

@Repository("userMapper")
public interface UserMapper {
	void updateMr(Map<String,Integer> paramMap);
	
	public List<User> selectUserList(User u);
	
	public User login(Map<String,String> map);
	
    void deleteByPrimaryKey(Integer id);

    void insert(User record);

    void insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    void updateByPrimaryKeySelective(User record);

    void updateByPrimaryKey(User record);
}