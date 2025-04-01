package cn.com.project.web.user.service;

import java.util.List;
import java.util.Map;

import cn.com.project.web.user.domain.Liuyan;
import cn.com.project.web.user.domain.PingJia;
import cn.com.project.web.user.domain.ShouHuo;
import cn.com.project.web.user.domain.UsedBook;
import cn.com.project.web.user.domain.User;

public interface UserService {
	public List<User> selectUserList(User u)throws Exception;
	void insert(User u)throws Exception;
	public User login(String name,String password)throws Exception;
	void deleteByPrimaryKey(Integer id)throws Exception;
	User selectByPrimaryKey(Integer id)throws Exception;
	void updateByPrimaryKey(User record)throws Exception;
	void insert(ShouHuo sh)throws Exception;
	public List<ShouHuo> selectAdd(Integer id)throws Exception;
	void deleteAdd(Integer id)throws Exception;
	ShouHuo selectByIdAdd(Integer id);
	void updateAdd(ShouHuo record);
	void updateMr(Integer id,Integer uId);
	void updateShNoMr(Integer id);
	void updateShMr(Integer id);
	void insert(PingJia record);
	List<PingJia> selectByIdPj(Integer id);
	
	void deleteMyBook(Integer id);

    void insert(UsedBook record);
    List<UsedBook> selectList();
    
    List<UsedBook> selectMyBook(Integer id);
    void deleteLy(Integer id);

    void insertLy(Liuyan record);


    List<Liuyan> selectListLy(Liuyan record);
}
