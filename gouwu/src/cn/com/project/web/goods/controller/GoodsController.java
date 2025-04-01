package cn.com.project.web.goods.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import cn.com.project.shangpin.domain.GongGao;
import cn.com.project.shangpin.domain.LeiBie;
import cn.com.project.shangpin.domain.ShangPin;
import cn.com.project.shangpin.service.ShangpinService;
import cn.com.project.util.Comm;
import cn.com.project.web.user.domain.PingJia;
import cn.com.project.web.user.domain.UsedBook;
import cn.com.project.web.user.service.UserService;

import com.github.pagehelper.PageHelper;

@Controller
@RequestMapping("web/goods")
class GoodsController {
	@Autowired
	private ShangpinService shangpinService;
	@Autowired
	private UserService userService;
	/**
	 * 
	 * @描述:前台首页
	 * @作者:
	 * @时间 2018年3月15日 下午5:39:37
	 * @获取一个: toadd
	 * @返回值:ModelAndView
	 */
	@RequestMapping(value="/home")
	public ModelAndView home(GongGao gg,LeiBie lb,ShangPin record)throws Exception{
		ModelAndView mav = new ModelAndView();
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
	/**
	 * 
	 * @描述:前台根据id显示新闻
	 * @作者:
	 * @时间 2018年3月15日 下午5:39:37
	 * @获取一个: toadd
	 * @返回值:ModelAndView
	 */
	@RequestMapping(value="/selGg")
	public ModelAndView selGg(Integer id)throws Exception{
		ModelAndView mav = new ModelAndView();
		GongGao gg = shangpinService.selectByGg(id);
		mav.addObject("gg", gg);
		mav.setViewName("temp/news");
		return mav;
	}
	/**
	 * 
	 * @描述:查看类别
	 * @作者:
	 * @时间 2018年3月15日 下午5:39:37
	 * @获取一个: toadd
	 * @返回值:ModelAndView
	 */
	@RequestMapping(value="/selLb")
	public ModelAndView selLb(LeiBie lb)throws Exception{
		ModelAndView mav = new ModelAndView();
		List<LeiBie> lbList = shangpinService.selectAllLb();
		
		mav.addObject("lbList",lbList);
		//分页		
		PageHelper.startPage(1,7,true);
		mav.setViewName("temp/main");
		return mav;
	}
	/**
	 * 
	 * @描述:前台根据id显示商品
	 * @作者:
	 * @时间 2018年3月15日 下午5:39:37
	 * @获取一个: toadd
	 * @返回值:ModelAndView
	 */
	@RequestMapping(value="/selWebSp")
	public ModelAndView selWebSp(Integer id,LeiBie lb)throws Exception{
		ModelAndView mav = new ModelAndView();
		List<ShangPin> spList = shangpinService.selectByMid(id);
		List<LeiBie> lbList = shangpinService.selectAllLb();
		//分页		
		PageHelper.startPage(1,6,true);
	  
		mav.addObject("lbList",lbList);
		mav.addObject("spList", spList);
		mav.setViewName("temp/rx");
		return mav;
	}
	/**
	 * 
	 * @描述:前台根据id显示商品
	 * @作者:
	 * @时间 2018年3月15日 下午5:39:37
	 * @获取一个: toadd
	 * @返回值:ModelAndView
	 */
	@RequestMapping(value="/selSpDetail")
	public ModelAndView selSpDetail(Integer id)throws Exception{
		ModelAndView mav = new ModelAndView();
		ShangPin sp = shangpinService.selectByPrimaryKey(id);
		List<PingJia> pjList = userService.selectByIdPj(id);
		
		List<LeiBie> lbList = shangpinService.selectAllLb();
		//分页		
		PageHelper.startPage(1,7,true);
		
		mav.addObject("sp", sp);
		mav.addObject("pjList", pjList);
		mav.addObject("lbList", lbList);
		mav.setViewName("temp/sp");
		return mav;
	}
	/**
	 * 
	 * @描述:搜索商品
	 * @作者:
	 * @时间 2018年3月15日 下午5:39:37
	 * @获取一个: toadd
	 * @返回值:ModelAndView
	 */
	@RequestMapping(value="/search")
	public ModelAndView search(String sname, ShangPin sp)throws Exception{
		ModelAndView mav = new ModelAndView();
		sp.setSname(sname);
		LeiBie lb = new LeiBie();
		List<ShangPin> spList = shangpinService.select(sp);
		List<LeiBie> lbList = shangpinService.selectAllLb();
		mav.addObject("spList", spList);
		mav.addObject("lbList",lbList);
		mav.setViewName("temp/rx");
		return mav;
	}
	/**
	 * 
	 * @描述:查看
	 * @作者:
	 * @时间 2018年3月15日 下午5:39:37
	 * @获取一个: toadd
	 * @返回值:String
	 */
	@RequestMapping(value="/selUsedBook")
	public ModelAndView selUsedBook(LeiBie lb,HttpServletRequest request)throws Exception{
		ModelAndView mav = new ModelAndView();
		List<UsedBook> spList = userService.selectList();
		List<LeiBie> lbList = shangpinService.selectAllLb();
		//分页		
		PageHelper.startPage(1,6,true);
		mav.addObject("lbList",lbList);
		mav.addObject("spList",spList);
		mav.setViewName("temp/rx");
		return mav;
	}
}
