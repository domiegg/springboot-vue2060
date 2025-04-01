package cn.com.project.web.user.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import cn.com.project.city.domain.City;
import cn.com.project.city.service.CityService;
import cn.com.project.shangpin.domain.LeiBie;
import cn.com.project.shangpin.domain.ShangPin;
import cn.com.project.shangpin.service.ShangpinService;
import cn.com.project.util.Comm;
import cn.com.project.web.dingdan.domain.DingDan;
import cn.com.project.web.dingdan.service.DingDanService;
import cn.com.project.web.user.domain.Liuyan;
import cn.com.project.web.user.domain.PingJia;
import cn.com.project.web.user.domain.ShouHuo;
import cn.com.project.web.user.domain.UsedBook;
import cn.com.project.web.user.domain.User;
import cn.com.project.web.user.service.UserService;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

/**
 * 
 * @描述:用户操作
 * @作者:
 * @时间 2018年3月14日 下午1:42:56
 * @获取一个: login
 * @返回值:ModelAndView
 */
@Controller
@RequestMapping("web/user")
public class UserController {
	@Autowired
	private UserService userService;
	@Autowired
	private CityService cityService;
	@Autowired
	private DingDanService dingDanService;
	@Autowired
	private ShangpinService shangpinService;
	
	
	/**
	 * 
	 * @描述:用户注册
	 * @作者:
	 * @时间 2018年3月15日 下午5:39:37
	 * @获取一个: toadd
	 * @返回值:ModelAndView
	 */
	@RequestMapping(value="/saveUser")
	public ModelAndView saveUser(LeiBie lb ,User u)throws Exception{
		/*//第一步：判断文件是否为空 ,MultipartFile photo
		if(photo!=null){
			InputStream is = photo.getInputStream();
			ByteArrayOutputStream os = new ByteArrayOutputStream();
			byte[] b = new byte[1024];
			int length = -1;
			while ((length=is.read(b))!=-1){
				os.write(b,0,length);
			}
			sp.setPhoto(os.toByteArray());
			//优化
			shangpinService.insert(sp);
			is.close();
			os.flush();
			os.close();
		}*/
		ModelAndView mav = new ModelAndView();
		userService.insert(u);
		//分页		
		PageHelper.startPage(1,7,true);
		List<LeiBie> lbList = shangpinService.selectLb(lb);
		mav.addObject("lbList", lbList);
		mav.setViewName("temp/main");
		return mav;
	}
	/**
	 * 
	 * @描述:查看用户
	 * @作者:
	 * @时间 2018年3月15日 下午5:39:37
	 * @获取一个: toadd
	 * @返回值:ModelAndView
	 */
	@RequestMapping(value="/selUser")
	public ModelAndView selUser(Integer page,User u)throws Exception{
		ModelAndView mav = new ModelAndView();
		List<User> userList = userService.selectUserList(u);
		//分页
		if (page == null) {
			page = 1;
		}
		//分页		
		PageHelper.startPage(page,8,true);
		PageInfo<User> pageInfo = new PageInfo<User>(userList); 
	  
		mav.addObject("userList",userList);
		mav.addObject("page", new PageInfo(userList));
		mav.addObject("count", pageInfo.getTotal());
		mav.addObject("countPage", pageInfo.getPages());
		mav.addObject("lastPage", pageInfo.getLastPage());
		mav.setViewName("admin/user/selUser");
		return mav;
	}
	/**
	 * 
	 * @描述:删除用户
	 * @作者:
	 * @时间 2018年3月15日 下午5:39:37
	 * @获取一个: toadd
	 * @返回值:String
	 */
	@RequestMapping(value="/deleteUser")
	public String deleteUser(Integer id)throws Exception{
		
		userService.deleteByPrimaryKey(id);
		
		return "redirect:/web/user/selUser";
	}
	/**
	 * 
	 * @描述:查看我的收货地址
	 * @作者:
	 * @时间 2018年3月15日 下午5:39:37
	 * @获取一个: toadd
	 * @返回值:ModelAndView
	 */
	@RequestMapping(value="/selMyAdd")
	public ModelAndView selMyAdd(HttpServletRequest request)throws Exception{
		Integer id = Comm.getUserInfoId(request);
		ModelAndView mav = new ModelAndView();
		List<ShouHuo> addList = userService.selectAdd(id);
		//分页		
		PageHelper.startPage(1,30,true);
	  
		mav.addObject("addList",addList);
		mav.setViewName("temp/address/address");
		return mav;
	}
	/**
	 * 
	 * @描述:保存收货地址
	 * @作者:
	 * @时间 2018年3月15日 下午5:39:37
	 * @获取一个: toadd
	 * @返回值:String
	 */
	@RequestMapping(value="/saveAdd")
	public String saveAdd(ShouHuo sh,HttpServletRequest request)throws Exception{
		Integer id = Comm.getUserInfoId(request);
		sh.setuId(id);
		userService.insert(sh);
		
		return "redirect:/web/user/selMyAdd";
	}
	/**
	 * 
	 * @描述:跳转到编辑收货地址
	 * @作者:
	 * @时间 2018年3月15日 下午5:39:37
	 * @获取一个: toadd
	 * @返回值:String
	 */
	@RequestMapping(value="/showAdd")
	public ModelAndView showAdd(Integer id,HttpServletRequest request)throws Exception{
		ModelAndView mav = new ModelAndView();
		ShouHuo sh = userService.selectByIdAdd(id);
		List<City> listSheng = cityService.selSheng();
		  
		mav.addObject("listSheng",listSheng);
		mav.addObject("sh",sh);
		mav.setViewName("temp/address/updateDz");
		return mav;
	}
	/**
	 * 
	 * @描述:保存编辑收货地址
	 * @作者:
	 * @时间 2018年3月15日 下午5:39:37
	 * @获取一个: toadd
	 * @返回值:String
	 */
	@RequestMapping(value="/saveUpdateAdd")
	public String saveUpdateAdd(ShouHuo sh,HttpServletRequest request)throws Exception{
		userService.updateAdd(sh);
		
		return "redirect:/web/user/selMyAdd";
	}
	/**
	 * 
	 * @描述:删除收货地址
	 * @作者:
	 * @时间 2018年3月15日 下午5:39:37
	 * @获取一个: toadd
	 * @返回值:String
	 */
	@RequestMapping(value="/deleteAdd")
	public String deleteAdd(Integer id,HttpServletRequest request)throws Exception{
		userService.deleteAdd(id);
		
		return "redirect:/web/user/selMyAdd";
	}
	/**
	 * 
	 * @描述:设置默认收货地址
	 * @作者:
	 * @时间 2018年3月15日 下午5:39:37
	 * @获取一个: toadd
	 * @返回值:String
	 */
	@RequestMapping(value="/mrAdd")
	public String mrAdd(Integer dId,HttpServletRequest request)throws Exception{
		Integer uId = Comm.getUserInfoId(request);
		userService.updateMr(dId,uId);
		userService.updateShNoMr(uId);
		userService.updateShMr(dId);
		
		return "redirect:/web/user/selMyAdd";
	}
	/**
	 * 
	 * @描述:跳转到评价页面
	 * @作者:
	 * @时间 2018年3月15日 下午5:39:37
	 * @获取一个: toadd
	 * @返回值:String
	 */
	@RequestMapping(value="/showPj")
	public ModelAndView showPj(Integer id,HttpServletRequest request)throws Exception{
		ModelAndView mav = new ModelAndView();
		DingDan dd = dingDanService.selectById(id);
		  
		mav.addObject("dd",dd);
		mav.setViewName("temp/pingjia");
		return mav;
	}
	/**
	 * 
	 * @描述:保存评价
	 * @作者:
	 * @时间 2018年3月15日 下午5:39:37
	 * @获取一个: toadd
	 * @返回值:String
	 */
	@RequestMapping(value="/savePj")
	public String savePj(PingJia pj,HttpServletRequest request)throws Exception{
		Integer uId = Comm.getUserInfoId(request);
		String name = Comm.getUserInfoName(request); 
		pj.setuId(uId);
		pj.setName(name);
		pj.setDate(new Date());
		userService.insert(pj);
		
		DingDan dd = new DingDan();
		String state = "3";
		dd.setState(state);
		dd.setId(pj.getId());
		dingDanService.updateState(dd);
		
		return "redirect:/web/oper/selMyDd";
	}
	/**
	 * 
	 * @描述:收货
	 * @作者:
	 * @时间 2018年3月15日 下午5:39:37
	 * @获取一个: toadd
	 * @返回值:ModelAndView
	 */
	@RequestMapping(value="/shouhuo")
	public String shouhuo(DingDan dd,HttpServletRequest request)throws Exception{
		String state = "2";
		dd.setState(state);
		dingDanService.updateState(dd);
	    return "redirect:/web/oper/selMyDd";
	}
	/**
	 * 
	 * @描述:取消订单
	 * @作者:
	 * @时间 2018年3月15日 下午5:39:37
	 * @获取一个: toadd
	 * @返回值:ModelAndView
	 */
	@RequestMapping(value="/deleteDd")
	public String deleteDd(Integer id,HttpServletRequest request)throws Exception{
		dingDanService.deleteByPrimaryKey(id);
	    return "redirect:/web/oper/selMyDd";
	}
	
	/**
	 * 
	 * @描述:保存留言
	 * @作者:
	 * @时间 2018年3月15日 下午5:39:37
	 * @获取一个: toadd
	 * @返回值:ModelAndView
	 */
	@RequestMapping(value="/addLy")
	public String addLy(Liuyan ly,HttpServletRequest request)throws Exception{
		Integer id = Comm.getUserInfoId(request);
		ly.setuId(id);
		ly.setDate(new Date());
		ly.setAccount(Comm.getUserInfoName(request));
	    userService.insertLy(ly);
	    return "redirect:/web/goods/home";
	}
	/**
	 * 
	 * @描述:查看留言
	 * @作者:
	 * @时间 2018年3月15日 下午5:39:37
	 * @获取一个: toadd
	 * @返回值:ModelAndView
	 */
	@RequestMapping(value="/selLy")
	public ModelAndView selLy(Integer page,Liuyan ly)throws Exception{
		ModelAndView mav = new ModelAndView();
		List<Liuyan> lyList = userService.selectListLy(ly);
		//分页
		if (page == null) {
			page = 1;
		}
		//分页		
		PageHelper.startPage(page,8,true);
		PageInfo<Liuyan> pageInfo = new PageInfo<Liuyan>(lyList); 
	  
		mav.addObject("lyList",lyList);
		mav.addObject("page", new PageInfo(lyList));
		mav.addObject("count", pageInfo.getTotal());
		mav.addObject("countPage", pageInfo.getPages());
		mav.addObject("lastPage", pageInfo.getLastPage());
		mav.setViewName("admin/liuyan/selLy");
		return mav;
	}
	/**
	 * 
	 * @描述:删除留言
	 * @作者:
	 * @时间 2018年3月15日 下午5:39:37
	 * @获取一个: toadd
	 * @返回值:ModelAndView
	 */
	@RequestMapping(value="/deleteLy")
	public String deleteLy(Integer id,HttpServletRequest request)throws Exception{
		userService.deleteLy(id);
		 return "redirect:/web/user/selLy";
	}
}