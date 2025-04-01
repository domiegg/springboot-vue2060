package cn.com.project.user.service;

import java.util.List;

import org.springframework.stereotype.Service;

import cn.com.project.user.domain.Admin;


public interface LoginService {
   public Admin login(String account,String password) throws Exception;
   void updatePassword(Admin record);
   void insert(Admin record);
   void deleteByPrimaryKey(Integer id);
   public List<Admin> select(Admin record); 
}
