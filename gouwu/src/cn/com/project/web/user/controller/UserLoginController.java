package cn.com.project.web.user.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageHelper;

import cn.com.project.shangpin.domain.GongGao;
import cn.com.project.shangpin.domain.LeiBie;
import cn.com.project.shangpin.domain.ShangPin;
import cn.com.project.shangpin.service.ShangpinService;
import cn.com.project.user.domain.Admin;
import cn.com.project.web.user.domain.User;
import cn.com.project.web.user.service.UserService;

/**
 * 
 * @描述:登陆操作
 * @作者:
 * @时间 2018年3月14日 下午1:42:56
 * @获取一个: login
 * @返回值:ModelAndView
 */
@Controller
@RequestMapping("web/user")
public class UserLoginController {
	@Autowired
	private UserService userService;
	@Autowired
	private ShangpinService shangpinService;
	/**
	 * 
	 * @描述:前台用户登录
	 * @作者:
	 * @时间 2018年3月14日 下午1:42:56
	 * @获取一个: login
	 * @返回值:ModelAndView
	 */
	@RequestMapping(value="/userLogin")
	public ModelAndView userLogin(String name,String password,GongGao gg,LeiBie lb,ShangPin record,HttpServletRequest request)throws Exception{
		ModelAndView mav = new ModelAndView();
		User user = userService.login(name, password);
		//获取session
		HttpSession session = request.getSession();
		if(user == null){//登陆失败
			mav.addObject("message","用户名或密码错误");
			mav.setViewName("temp/login");
		}else {
			List<LeiBie> lbList = shangpinService.selectAllLb();
			//分页		
			PageHelper.startPage(1,7,true);
			
			List<GongGao> ggList = shangpinService.selectGgList(gg);
			PageHelper.startPage(1,5,true);
			Integer id = 50;
			List<ShangPin> spList = shangpinService.selectByMid(id);
			PageHelper.startPage(1,8,true);
			
			List<ShangPin> countList = shangpinService.selectCount(record);
			PageHelper.startPage(1,5,true);
			
			mav.addObject("lbList",lbList);
			mav.addObject("ggList",ggList);
			mav.addObject("spList",spList);
			mav.addObject("countList",countList);
			
			session.setAttribute("id",user.getId());
			session.setAttribute("name", user.getName());
			session.setAttribute("number", user.getNumber());
			mav.setViewName("temp/main");
		}
		return mav;
	}
	/**
	 * 
	 * @throws Exception 
	 * @描述:退出登录
	 * @作者:
	 * @时间 2018年3月14日 下午1:42:56
	 * @获取一个: userZx
	 * @返回值:ModelAndView
	 */
	@RequestMapping("/userZx")
	public ModelAndView userZx(GongGao gg,LeiBie lb,ShangPin record,HttpServletRequest request) throws Exception{
		ModelAndView mav = new ModelAndView();
		HttpSession session = request.getSession();
		session.invalidate();
		List<LeiBie> lbList = shangpinService.selectAllLb();
		//分页		
		PageHelper.startPage(1,7,true);
		
		List<GongGao> ggList = shangpinService.selectGgList(gg);
		PageHelper.startPage(1,5,true);
		Integer id = 50;
		List<ShangPin> spList = shangpinService.selectByMid(id);
		PageHelper.startPage(1,8,true);
		
		List<ShangPin> countList = shangpinService.selectCount(record);
		PageHelper.startPage(1,5,true);
		
		mav.addObject("lbList",lbList);
		mav.addObject("ggList",ggList);
		mav.addObject("spList",spList);
		mav.addObject("countList",countList);
		mav.setViewName("temp/main");
		return mav;
	}
}