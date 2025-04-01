package cn.com.project.upload.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import cn.com.project.shangpin.domain.ShangPin;
import cn.com.project.util.DB;
import cn.com.project.web.user.domain.User;


public class UploadService {
	/**
	 * 
	 * @描述:添加商品
	 * @作者:
	 * @时间:2016-3-12 下午08:57:14
	 * @参数:@param sp 
	 * @返回值：void
	 */
	public void addSp(ShangPin sp){
		String sql = "insert into shangpin (m_id,sname,price,sx,photo,miaoshu,number,color)values(?,?,?,?,?,?,?,?)";
		new DB().update(sql,new String[]{sp.getmId(),sp.getSname(),sp.getPrice(),sp.getSx(),sp.getPhoto(),sp.getMiaoshu(),sp.getNumber(),sp.getColor()});
	}
	/**
	 * 
	 * @描述:修改商品
	 * @作者:
	 * @时间:2016-3-12 下午08:57:49
	 * @参数:@param id 
	 * @返回值：void
	 */
	public void updateSp(ShangPin sp){
		String sql ="update shangpin set sname=?,price=?,sx=?,photo=?,miaoshu=?,number=?,color=? where id = ?";
		new DB().update(sql,new String[]{sp.getSname(),sp.getPrice(),sp.getSx(),sp.getPhoto(),sp.getMiaoshu(),sp.getNumber(),sp.getColor(),sp.getId()});
	}
	/**
	 * 
	 * @描述:添加用户
	 * @作者:
	 * @时间:2016-3-12 下午08:57:14
	 * @参数:@param sp 
	 * @返回值：void
	 */
	public void saveUser(User u){
		String sql = "insert into user (u_name,u_password,email,u_photo,number)values(?,?,?,?,?)";
		new DB().update(sql,new String[]{u.getName(),u.getPassword(),u.getEmail(),u.getPhoto(),u.getNumber()});
	}
	/**
	 * 
	 * @描述:修改用户
	 * @作者:
	 * @时间:2016-3-12 下午08:57:49
	 * @参数:@param id 
	 * @返回值：void
	 */
	public void saveUpdateUser(User u){
		String sql ="update user set u_name=?,u_password=?,email=?,u_photo=? where number = ?";
		new DB().update(sql,new String[]{u.getName(),u.getPassword(),u.getEmail(),u.getPhoto(),u.getNumber()});
	}
}
