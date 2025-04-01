package cn.com.project.web.dingdan.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import cn.com.project.shangpin.domain.ShangPin;
import cn.com.project.util.Comm;
import cn.com.project.web.dingdan.domain.DingDan;
import cn.com.project.web.dingdan.service.DingDanService;
import cn.com.project.web.user.domain.User;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Controller
@RequestMapping("dingdan")
public class DingDanController {
	@Autowired
	private DingDanService dingDanService;
	/**
	 * 
	 * @描述:后台查看订单
	 * @作者:
	 * @时间 2018年3月15日 下午5:39:37
	 * @获取一个: toadd
	 * @返回值:ModelAndView
	 */
	@RequestMapping(value="/selDd")
	public ModelAndView selSp(Integer page,DingDan dd)throws Exception{
		ModelAndView mav = new ModelAndView();
		List<DingDan> ddList = dingDanService.select(dd);
		//分页
		if (page == null) {
			page = 1;
		}
		//分页		
		PageHelper.startPage(page,8,true);
		PageInfo<DingDan> pageInfo = new PageInfo<DingDan>(ddList); 
	  
		mav.addObject("ddList",ddList);
		mav.addObject("page", new PageInfo(ddList));
		mav.addObject("count", pageInfo.getTotal());
		mav.addObject("countPage", pageInfo.getPages());
		mav.addObject("lastPage", pageInfo.getLastPage());
		mav.setViewName("admin/dingdan/selDd");
		return mav;
	}
	/**
	 * 
	 * @描述:发货
	 * @作者:
	 * @时间 2018年3月15日 下午5:39:37
	 * @获取一个: toadd
	 * @返回值:ModelAndView
	 */
	@RequestMapping(value="/fahuo")
	public String fahuo(DingDan dd,HttpServletRequest request)throws Exception{
		String state = "1";
		dd.setState(state);
		dingDanService.updateState(dd);
	    return "redirect:/dingdan/selDd";
	}
}
