package cn.com.project.web.user.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.com.project.web.user.domain.Liuyan;
import cn.com.project.web.user.domain.PingJia;
import cn.com.project.web.user.domain.ShouHuo;
import cn.com.project.web.user.domain.UsedBook;
import cn.com.project.web.user.domain.User;
import cn.com.project.web.user.mapper.LiuyanMapper;
import cn.com.project.web.user.mapper.PingJiaMapper;
import cn.com.project.web.user.mapper.ShouHuoMapper;
import cn.com.project.web.user.mapper.UsedBookMapper;
import cn.com.project.web.user.mapper.UserMapper;
import cn.com.project.web.user.service.UserService;

@Service("userService")
public class UserServiceImpl implements UserService {
	@Autowired
	private UserMapper userMapper;
	@Autowired
	private ShouHuoMapper shouHuoMapper;
	@Autowired
	private PingJiaMapper pingJiaMapper;
	@Autowired
	private UsedBookMapper usedBookMapper;
	@Autowired
	private LiuyanMapper liuyanMapper;
	public void insert(User u) throws Exception {
		userMapper.insert(u);
	}
	public User login(String name, String password)
			throws Exception {
		Map<String , String> map = new HashMap<String,String>();
		map.put("name", name);
		map.put("password", password);
		User user = null;
		try {
			user = userMapper.login(map);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return user;
	}
	public List<User> selectUserList(User u) throws Exception {
		List<User> userList = userMapper.selectUserList(u);
		return userList;
	}
	public void deleteByPrimaryKey(Integer id) throws Exception {
		userMapper.deleteByPrimaryKey(id);
	}
	public User selectByPrimaryKey(Integer id) throws Exception {
		User user = userMapper.selectByPrimaryKey(id);
		return user;
	}
	public void updateByPrimaryKey(User record) throws Exception {
		userMapper.updateByPrimaryKey(record);
	}
	public void insert(ShouHuo sh) throws Exception {
		shouHuoMapper.insert(sh);
	}
	public List<ShouHuo> selectAdd(Integer id) throws Exception {
		List<ShouHuo> addList = shouHuoMapper.selectAdd(id);
		return addList;
	}
	public ShouHuo selectByIdAdd(Integer id) {
		ShouHuo  sh = shouHuoMapper.selectByPrimaryKey(id);
		return sh;
	}
	public void updateAdd(ShouHuo record) {
		shouHuoMapper.updateByPrimaryKey(record);
	}
	public void deleteAdd(Integer id) throws Exception {
		shouHuoMapper.deleteByPrimaryKey(id);
	}
	public void updateMr(Integer dId,Integer uId) {
		Map<String,Integer> paramMap = new HashMap<String,Integer>();
		paramMap.put("dId", dId);
		paramMap.put("uId", uId);
		userMapper.updateMr(paramMap);
	}
	public void updateShMr(Integer id) {
		shouHuoMapper.updateMr(id);
		
	}
	public void updateShNoMr(Integer id) {
		shouHuoMapper.updateNoMr(id);		
	}
	public void insert(PingJia record) {
		pingJiaMapper.insert(record);
	}
	public List<PingJia> selectByIdPj(Integer id) {
		List<PingJia> pjList = pingJiaMapper.selectByPrimaryKey(id);
		return pjList;
	}
	public void deleteMyBook(Integer id) {
		usedBookMapper.deleteByPrimaryKey(id);
	}
	public void insert(UsedBook record) {
		usedBookMapper.insert(record);		
	}
	public List<UsedBook> selectList() {
		List<UsedBook> selectList = usedBookMapper.selectList();
		return selectList;
	}
	public List<UsedBook> selectMyBook(Integer id) {
		List<UsedBook> selectMyBook = usedBookMapper.selectByPrimaryKey(id);
		return selectMyBook;
	}
	public void deleteLy(Integer id) {
		liuyanMapper.deleteLy(id);
	}
	public void insertLy(Liuyan record) {
		liuyanMapper.insertLy(record);
	}
	public List<Liuyan> selectListLy(Liuyan record) {
		List<Liuyan> selectLy = liuyanMapper.selectListLy(record);
		return selectLy;
	}
}
