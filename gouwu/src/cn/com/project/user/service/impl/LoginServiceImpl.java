package cn.com.project.user.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.com.project.user.domain.Admin;
import cn.com.project.user.mapper.AdminMapper;
import cn.com.project.user.service.LoginService;
@Service("loginService")
public class LoginServiceImpl implements LoginService {
	@Autowired
	private AdminMapper adminMapper;
	
	public Admin login(String account,String password)   {
		Map<String , String> map = new HashMap<String,String>();
		map.put("account", account);
		map.put("password", password);
		Admin admin = null;
		try {
			admin = adminMapper.login(map);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return admin;
	}

	public void updatePassword(Admin record) {
		adminMapper.updatePassword(record);
	}

	public void deleteByPrimaryKey(Integer id) {
		adminMapper.deleteByPrimaryKey(id);
	}

	public void insert(Admin record) {
		adminMapper.insert(record);
	}

	public List<Admin> select(Admin record) {
		List<Admin> adminList = adminMapper.select(record);
		return adminList;
	}
}
