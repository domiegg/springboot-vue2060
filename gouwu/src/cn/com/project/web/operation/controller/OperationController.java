package cn.com.project.web.operation.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageHelper;

import cn.com.project.shangpin.domain.LeiBie;
import cn.com.project.shangpin.domain.ShangPin;
import cn.com.project.shangpin.service.ShangpinService;
import cn.com.project.util.Comm;
import cn.com.project.web.dingdan.domain.DingDan;
import cn.com.project.web.dingdan.service.DingDanService;
import cn.com.project.web.operation.domain.Collect;
import cn.com.project.web.operation.domain.Gwc;
import cn.com.project.web.operation.service.OperationService;
import cn.com.project.web.user.domain.UsedBook;
import cn.com.project.web.user.domain.User;
import cn.com.project.web.user.service.UserService;

@Controller
@RequestMapping("web/oper")
public class OperationController {
	@Autowired
	private UserService userService;
	@Autowired
	private OperationService operationService;
	@Autowired
	private ShangpinService shangpinService;
	@Autowired
	private DingDanService dingDanService;
	/**
	 * 
	 * @描述:跳转到个人主页
	 * @作者:
	 * @时间 2018年3月15日 下午5:39:37
	 * @获取一个: toadd
	 * @返回值:ModelAndView
	 */
	@RequestMapping(value="/showUser")
	public ModelAndView showUser(HttpServletRequest request)throws Exception{
		Integer id = Comm.getUserInfoId(request);
		ModelAndView mav = new ModelAndView();
		User user= userService.selectByPrimaryKey(id);
		//待发货
		int countDfh = dingDanService.selectCountDfh(id);
		//待收货
		int countDsh = dingDanService.selectCountDsh(id);
		//待评价
		int countDpj = dingDanService.selectCountDpj(id);
		mav.addObject("user",user);
		mav.addObject("countDfh",countDfh);
		mav.addObject("countDsh",countDsh);
		mav.addObject("countDpj",countDpj);
		mav.setViewName("temp/grzy");
		return mav;
	}
	/**
	 * 
	 * @描述:跳转到我的信息
	 * @作者:
	 * @时间 2018年3月15日 下午5:39:37
	 * @获取一个: toadd
	 * @返回值:ModelAndView
	 */
	@RequestMapping(value="/selMyInfo")
	public ModelAndView selMyInfo(HttpServletRequest request)throws Exception{
		Integer id = Comm.getUserInfoId(request);
		ModelAndView mav = new ModelAndView();
		User user= userService.selectByPrimaryKey(id);
		mav.addObject("user",user);
		mav.setViewName("temp/xiugai");
		return mav;
	}
	/**
	 * 
	 * @描述:加入购物车
	 * @作者:
	 * @时间 2018年3月15日 下午5:39:37
	 * @获取一个: toadd
	 * @返回值:ModelAndView
	 */
	@RequestMapping(value="/addGwc")
	public String addGwc(Gwc gwc,String price,HttpServletRequest request)throws Exception{
		//当前登录用户id
		Integer id = Comm.getUserInfoId(request);
		gwc.setuId(id);
		Integer sId = gwc.getsId(); 
		//购买数量
		String number = gwc.getNumber();
		//总价格
		String tPrice = String.valueOf(Integer.parseInt(number)*Integer.parseInt(price));
		gwc.settPrice(tPrice);
		//插入购物车信息表
		operationService.insert(gwc);
		
		//商品信息表
		ShangPin sp = shangpinService.selectByPrimaryKey(sId);
		String sNumber = String.valueOf(Integer.parseInt(sp.getNumber())-Integer.parseInt(number));
		sp.setNumber(sNumber);
		//更新商品数量
		shangpinService.updateByPrimaryKey(sp);
		return "redirect:/web/oper/selMyGwc";
	}
	/**
	 * 
	 * @描述:查询个人购物车
	 * @作者:
	 * @时间 2018年3月15日 下午5:39:37
	 * @获取一个: toadd
	 * @返回值:ModelAndView
	 */
	@RequestMapping(value="/selMyGwc")
	public ModelAndView selMyGwc(HttpServletRequest request)throws Exception{
		Integer id = Comm.getUserInfoId(request);
		ModelAndView mav = new ModelAndView();
		List<Gwc> gwcList = operationService.selectByPrimaryKey(id);
		
		String count = operationService.selectCount(id);
		mav.addObject("gwcList",gwcList);
		mav.addObject("count",count);
		mav.setViewName("temp/gwc");
		return mav;
	}
	/**
	 * 
	 * @描述:删除购物车
	 * @作者:
	 * @时间 2018年3月15日 下午5:39:37
	 * @获取一个: toadd
	 * @返回值:ModelAndView
	 */
	@RequestMapping(value="/deleteGwc")
	public String deleteGwc(Integer id,HttpServletRequest request)throws Exception{
		operationService.deleteByPrimaryKey(id);
	    return "redirect:/web/oper/selMyGwc";
	}
	/**
	 * 
	 * @描述:清空购物车
	 * @作者:
	 * @时间 2018年3月15日 下午5:39:37
	 * @获取一个: toadd
	 * @返回值:ModelAndView
	 */
	@RequestMapping(value="/emptyGwc")
	public String emptyGwc(HttpServletRequest request)throws Exception{
		Integer id = Comm.getUserInfoId(request);
		operationService.emptyGwc(id);
	    return "redirect:/web/oper/selMyGwc";
	}
	/**
	 * 
	 * @描述:结算购物车
	 * @作者:
	 * @时间 2018年3月15日 下午5:39:37
	 * @获取一个: toadd
	 * @返回值:ModelAndView
	 */
	@RequestMapping(value="/jsGwc")
	public String jsGwc(HttpServletRequest request)throws Exception{
		Integer id = Comm.getUserInfoId(request);
		List<Gwc> gwcList = operationService.selectByPrimaryKey(id);
		DingDan dd = new DingDan();
		if(gwcList != null && gwcList.size() >0 ){
			for (int i = 0; i < gwcList.size(); i++) {
				dd.setsId(gwcList.get(i).getsId());
				dd.setuId(gwcList.get(i).getuId());
				dd.setNumber(gwcList.get(i).getNumber());
				dd.settPrice(gwcList.get(i).gettPrice());
				dd.setState("0");
				dd.setDate(new Date());
				dingDanService.insert(dd);
			}
		}
	    return "redirect:/web/oper/emptyGwc";
	}
	/**
	 * 
	 * @描述:查询个人订单
	 * @作者:
	 * @时间 2018年3月15日 下午5:39:37
	 * @获取一个: toadd
	 * @返回值:ModelAndView
	 */
	@RequestMapping(value="/selMyDd")
	public ModelAndView selMyDd(HttpServletRequest request)throws Exception{
		Integer id = Comm.getUserInfoId(request);
		ModelAndView mav = new ModelAndView();
		List<DingDan> ddList = dingDanService.selectByPrimaryKey(id);
		
		mav.addObject("ddList",ddList);
		mav.setViewName("temp/dingdan");
		return mav;
	}
	/**
	 * 
	 * @描述:根据发货状态查询个人订单
	 * @作者:
	 * @时间 2018年3月15日 下午5:39:37
	 * @获取一个: toadd
	 * @返回值:ModelAndView
	 */
	@RequestMapping(value="/selMyDdXx")
	public ModelAndView selMyDdXx(Integer state,HttpServletRequest request)throws Exception{
		Integer id = Comm.getUserInfoId(request);
		ModelAndView mav = new ModelAndView();
		List<DingDan> ddList = dingDanService.selectByState(id, state);
		
		mav.addObject("ddList",ddList);
		mav.setViewName("temp/dingdan");
		return mav;
	}
	/**
	 * 
	 * @描述:购买商品
	 * @作者:
	 * @时间 2018年3月15日 下午5:39:37
	 * @获取一个: toadd
	 * @返回值:ModelAndView
	 */
	@RequestMapping(value="/buy")
	@ResponseBody
	public Map<String,Object> buy(String number,String price,Integer sId,DingDan dd,HttpServletRequest request)throws Exception{
		//当前登录用户id
		Integer id = Comm.getUserInfoId(request);
		dd.setuId(id);
		//总价格
		String tPrice = String.valueOf(Integer.parseInt(number)*Integer.parseInt(price));
		dd.settPrice(tPrice);
		dd.setsId(sId);
		dd.setNumber(number);
		dd.setState("0");
		dd.setDate(new Date());
		//插入订单信息表
		dingDanService.insert(dd);
		
		//商品信息表
		ShangPin sp = shangpinService.selectByPrimaryKey(sId);
		String sNumber = String.valueOf(Integer.parseInt(sp.getNumber())-Integer.parseInt(number));
		sp.setNumber(sNumber);
		//更新商品数量
		shangpinService.updateByPrimaryKey(sp);
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("flag", "1");
		return map;
	}
	/**
	 * 
	 * @描述:添加收藏
	 * @作者:
	 * @时间 2018年3月15日 下午5:39:37
	 * @获取一个: toadd
	 * @返回值:ModelAndView
	 */
	@RequestMapping(value="/collect")
	public String collect(Integer sid,Collect c,HttpServletRequest request)throws Exception{
		Integer id = Comm.getUserInfoId(request);
		c.setuId(id);
		c.setsId(sid);
		operationService.insert(c);
		return "redirect:/web/oper/selMyCollect";
	}
	/**
	 * 
	 * @描述:查看个人收藏
	 * @作者:
	 * @时间 2018年3月15日 下午5:39:37
	 * @获取一个: toadd
	 * @返回值:String
	 */
	@RequestMapping(value="/selMyCollect")
	public ModelAndView selMyCollect(HttpServletRequest request)throws Exception{
		Integer id = Comm.getUserInfoId(request);
		ModelAndView mav = new ModelAndView();
		List<Collect> collectList = operationService.collectList(id);
		List<LeiBie> lbList = shangpinService.selectAllLb();
		//分页		
		PageHelper.startPage(1,7,true);
		mav.addObject("collectList",collectList);
		mav.addObject("lbList", lbList);
		mav.setViewName("temp/collect");
		return mav;
	}
	/**
	 * 
	 * @描述:删除收藏
	 * @作者:
	 * @时间 2018年3月15日 下午5:39:37
	 * @获取一个: toadd
	 * @返回值:ModelAndView
	 */
	@RequestMapping(value="/deleteCollect")
	public String deleteCollect(Integer id,HttpServletRequest request)throws Exception{
		operationService.deleteCollect(id);
	    return "redirect:/web/oper/selMyCollect";
	}
}
