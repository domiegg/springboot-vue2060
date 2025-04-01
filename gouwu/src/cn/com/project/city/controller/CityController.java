package cn.com.project.city.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import cn.com.project.city.domain.City;
import cn.com.project.city.service.CityService;
import cn.com.project.web.user.domain.User;

@Controller
@RequestMapping("city")
public class CityController {
	@Autowired
	private CityService cityService;
	
	/**
	 * 
	 * @描述:跳转到添加收货地址页面
	 * @作者:
	 * @时间 2018年3月15日 下午5:39:37
	 * @获取一个: toadd
	 * @返回值:ModelAndView
	 */
	@RequestMapping(value="/addDd")
	public ModelAndView addDd()throws Exception{
		ModelAndView mav = new ModelAndView();
		List<City> listSheng = cityService.selSheng();
	  
		mav.addObject("listSheng",listSheng);
		mav.setViewName("temp/address/addDz");
		return mav;
	}
	/**
	 * 
	 * @描述:查看市
	 * @作者:
	 * @时间 2018年3月15日 下午5:39:37
	 * @获取一个: toadd
	 * @返回值:ModelAndView
	 */
	@RequestMapping(value="/shi")
	@ResponseBody
	public List<City> shi(Integer sid)throws Exception{
		List<City> listShi = cityService.selShi(sid);
	    return listShi;
	}
	/**
	 * 
	 * @描述:查看县
	 * @作者:
	 * @时间 2018年3月15日 下午5:39:37
	 * @获取一个: toadd
	 * @返回值:ModelAndView
	 */
	@RequestMapping(value="/xian")
	@ResponseBody
	public List<City> xian(Integer sid)throws Exception{
		List<City> listXian = cityService.selXian(sid);
		return listXian;
	}
}
