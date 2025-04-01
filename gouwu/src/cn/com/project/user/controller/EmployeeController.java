package cn.com.project.user.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import cn.com.project.shangpin.domain.GongGao;
import cn.com.project.shangpin.domain.LeiBie;
import cn.com.project.shangpin.domain.ShangPin;
import cn.com.project.shangpin.service.ShangpinService;
import cn.com.project.user.domain.Admin;
import cn.com.project.user.service.LoginService;

/**
 * 
 * @描述:登陆操作
 * @作者:
 * @时间 2018年3月14日 下午1:42:56
 * @获取一个: login
 * @返回值:ModelAndView
 */
@Controller
@RequestMapping("employee")
public class EmployeeController {
	@Autowired
	private LoginService loginService;
	/**
	 * 
	 * @描述:添加员工
	 * @作者:
	 * @时间 2018年3月15日 下午5:39:37
	 * @获取一个: toadd
	 * @返回值:ModelAndView
	 */
	@RequestMapping(value="/saveEm")
	public String saveEm(Admin a)throws Exception{
		a.setRole("2");
		loginService.insert(a);
		return "redirect:/employee/selEm";
	}
	/**
	 * 
	 * @描述:查看员工
	 * @作者:
	 * @时间 2018年3月15日 下午5:39:37
	 * @获取一个: toadd
	 * @返回值:ModelAndView
	 */
	@RequestMapping(value="/selEm")
	public ModelAndView selEm(Integer page,Admin a)throws Exception{
		ModelAndView mav = new ModelAndView();
		a.setRole("2");
		List<Admin> adminList = loginService.select(a);
		//分页
		if (page == null) {
			page = 1;
		}
		//分页		
		PageHelper.startPage(page,8,true);
		PageInfo<Admin> pageInfo = new PageInfo<Admin>(adminList); 
	  
		mav.addObject("adminList",adminList);
		mav.addObject("page", new PageInfo(adminList));
		mav.addObject("count", pageInfo.getTotal());
		mav.addObject("countPage", pageInfo.getPages());
		mav.addObject("lastPage", pageInfo.getLastPage());
		mav.setViewName("admin/employee/selEm");
		return mav;
	}
	/**
	 * 
	 * @描述:删除员工
	 * @作者:
	 * @时间 2018年3月15日 下午5:39:37
	 * @获取一个: toadd
	 * @返回值:ModelAndView
	 */
	@RequestMapping(value="/deleteEm")
	public String deleteEm(Integer id)throws Exception{
		loginService.deleteByPrimaryKey(id);
		return "redirect:/employee/selEm";
	}
}