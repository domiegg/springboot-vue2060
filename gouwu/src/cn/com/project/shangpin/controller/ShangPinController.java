package cn.com.project.shangpin.controller;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.output.ByteArrayOutputStream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import cn.com.project.shangpin.domain.GongGao;
import cn.com.project.shangpin.domain.LeiBie;
import cn.com.project.shangpin.domain.ShangPin;
import cn.com.project.shangpin.service.ShangpinService;
import cn.com.project.util.Comm;
import cn.com.project.util.ExcelExport;
import cn.com.project.util.FileUploadTool;
import cn.com.project.web.user.domain.PingJia;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

/**
 * 
 * @描述:商品操作
 * @作者:
 * @时间 2018年3月14日 下午1:42:56
 * @获取一个: shangpin
 * @返回值:ModelAndView
 */
@Controller
@RequestMapping("shangpin")
public class ShangPinController {
	@Autowired
	private ShangpinService shangpinService;
	/**
	 * 
	 * @描述:添加商品
	 * @作者:
	 * @时间 2018年3月15日 下午5:39:37
	 * @获取一个: toadd
	 * @返回值:ModelAndView
	 */
	@RequestMapping(value="/addSp")
	public ModelAndView addSp(LeiBie lb)throws Exception{
		ModelAndView mav = new ModelAndView();
		List<LeiBie> lbList = shangpinService.selectLb(lb);
		mav.addObject("lbList", lbList);
		mav.setViewName("admin/shangpin/addSp");
		return mav;
	}
	/**
	 * 
	 * @描述:查看商品
	 * @作者:
	 * @时间 2018年3月15日 下午5:39:37
	 * @获取一个: toadd
	 * @返回值:ModelAndView
	 */
	@RequestMapping(value="/selSp")
	public ModelAndView selSp(Integer page,ShangPin sp)throws Exception{
		ModelAndView mav = new ModelAndView();
		List<ShangPin> spList = shangpinService.select(sp);
		//分页
		if (page == null) {
			page = 1;
		}
		//分页		
		PageHelper.startPage(page,8,true);
		PageInfo<ShangPin> pageInfo = new PageInfo<ShangPin>(spList); 
	  
		mav.addObject("shangPinList",spList);
		mav.addObject("page", new PageInfo(spList));
		mav.addObject("count", pageInfo.getTotal());
		mav.addObject("countPage", pageInfo.getPages());
		mav.addObject("lastPage", pageInfo.getLastPage());
		mav.setViewName("admin/shangpin/selSp");
		return mav;
	}
	
	/**
	 * 
	 * @描述:根据id显示商品
	 * @作者:
	 * @时间 2018年3月15日 下午5:39:37
	 * @获取一个: toadd
	 * @返回值:ModelAndView
	 */
	@RequestMapping(value="/showSp")
	public ModelAndView showSp(Integer id)throws Exception{
		ModelAndView mav = new ModelAndView();
		ShangPin sp = shangpinService.selectByPrimaryKey(id);
		mav.addObject("sp", sp);
		mav.setViewName("admin/shangpin/updateSp");
		return mav;
	}
	/**
	 * 
	 * @描述:保存更新商品
	 * @作者:
	 * @时间 2018年3月15日 下午5:39:37
	 * @获取一个: toadd
	 * @返回值:ModelAndView
	 */
	@RequestMapping(value="/saveUpdateSp")
	public String saveUpdateSp(ShangPin sp)throws Exception{
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
		shangpinService.updateByPrimaryKey(sp);
		
		return "redirect:/shangpin/selSp";
	}
	/**
	 * 
	 * @描述:添加商品
	 * @作者:
	 * @时间 2018年3月15日 下午5:39:37
	 * @获取一个: toadd
	 * @返回值:ModelAndView
	 */
	@RequestMapping(value="/deleteSp")
	public String deleteSp(Integer id)throws Exception{
		
		shangpinService.deleteByPrimaryKey(id);
		
		return "redirect:/shangpin/selSp";
	}
	/**
	 * 
	 * @描述:跳转到添加类别页面
	 * @作者:
	 * @时间 2018年3月15日 下午5:39:37
	 * @获取一个: toadd
	 * @返回值:ModelAndView
	 */
	@RequestMapping(value="/addLb")
	public ModelAndView addLb()throws Exception{
		ModelAndView mav = new ModelAndView();
		mav.setViewName("admin/leibie/addLb");
		return mav;
	}
	/**
	 * 
	 * @描述:保存类别
	 * @作者:
	 * @时间 2018年3月15日 下午5:39:37
	 * @获取一个: toadd
	 * @返回值:ModelAndView
	 */
	@RequestMapping(value="/saveLb")
	public String saveLb(LeiBie lb)throws Exception{
		
		shangpinService.insertLb(lb);
		
		return "redirect:/shangpin/selLb";
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
	public ModelAndView selLb(Integer page,LeiBie lb)throws Exception{
		ModelAndView mav = new ModelAndView();
		List<LeiBie> lbList = shangpinService.selectLb(lb);
		//分页
		if (page == null) {
			page = 1;
		}
		//分页		
		PageHelper.startPage(page,10,true);
		PageInfo<LeiBie> pageInfo = new PageInfo<LeiBie>(lbList); 
	  
		mav.addObject("lbList",lbList);
		mav.addObject("page", new PageInfo(lbList));
		mav.addObject("count", pageInfo.getTotal());
		mav.addObject("countPage", pageInfo.getPages());
		mav.addObject("lastPage", pageInfo.getLastPage());
		mav.setViewName("admin/leibie/selLb");
		return mav;
	}
	/**
	 * 
	 * @描述:删除类别
	 * @作者:
	 * @时间 2018年3月15日 下午5:39:37
	 * @获取一个: toadd
	 * @返回值:ModelAndView
	 */
	@RequestMapping(value="/deleteLb")
	public String deleteLb(Integer id)throws Exception{
		
		shangpinService.deleteLb(id);
		
		return "redirect:/shangpin/selLb";
	}
	/**
	 * 
	 * @描述:添加商品
	 * @作者:
	 * @时间 2018年3月15日 下午5:39:37
	 * @获取一个: toadd
	 * @返回值:ModelAndView
	 */
	@RequestMapping(value="/selLbById")
	public ModelAndView selLbById()throws Exception{
		ModelAndView mav = new ModelAndView();
		mav.setViewName("admin/shangpin/addSp");
		return mav;
	}
	/**
	 * 
	 * @描述:查看评价
	 * @作者:
	 * @时间 2018年3月15日 下午5:39:37
	 * @获取一个: toadd
	 * @返回值:ModelAndView
	 */
	@RequestMapping(value="/selPl")
	public ModelAndView selPl(Integer page,PingJia pj)throws Exception{
		ModelAndView mav = new ModelAndView();
		List<PingJia> plList = shangpinService.select(pj);
		//分页
		if (page == null) {
			page = 1;
		}
		//分页		
		PageHelper.startPage(page,10,true);
		PageInfo<PingJia> pageInfo = new PageInfo<PingJia>(plList); 
	  
		mav.addObject("plList",plList);
		mav.addObject("page", new PageInfo(plList));
		mav.addObject("count", pageInfo.getTotal());
		mav.addObject("countPage", pageInfo.getPages());
		mav.addObject("lastPage", pageInfo.getLastPage());
		mav.setViewName("admin/pinglun/selPl");
		return mav;
	}
	/**
	 * 
	 * @描述:删除评价
	 * @作者:
	 * @时间 2018年3月15日 下午5:39:37
	 * @获取一个: toadd
	 * @返回值:ModelAndView
	 */
	@RequestMapping(value="/deletePl")
	public String deletePl(Integer id)throws Exception{
		
		shangpinService.deletePl(id);
		
		return "redirect:/shangpin/selPl";
	}
	/**
	 * 
	 * @描述:保存新闻
	 * @作者:
	 * @时间 2018年3月15日 下午5:39:37
	 * @获取一个: toadd
	 * @返回值:ModelAndView
	 */
	@RequestMapping(value="/saveGg")
	public String saveGg(GongGao gg,HttpServletRequest request )throws Exception{
		gg.setDate(new Date());
		gg.setFname("admin");
		shangpinService.insert(gg);
		
		return "redirect:/shangpin/selGg";
	}
	/**
	 * 
	 * @描述:查看新闻
	 * @作者:
	 * @时间 2018年3月15日 下午5:39:37
	 * @获取一个: toadd
	 * @返回值:ModelAndView
	 */
	@RequestMapping(value="/selGg")
	public ModelAndView selGg(Integer page,GongGao gg)throws Exception{
		ModelAndView mav = new ModelAndView();
		List<GongGao> ggList = shangpinService.selectGgList(gg);
		//分页
		if (page == null) {
			page = 1;
		}
		//分页		
		PageHelper.startPage(page,10,true);
		PageInfo<GongGao> pageInfo = new PageInfo<GongGao>(ggList); 
	  
		mav.addObject("lbList",ggList);
		mav.addObject("page", new PageInfo(ggList));
		mav.addObject("count", pageInfo.getTotal());
		mav.addObject("countPage", pageInfo.getPages());
		mav.addObject("lastPage", pageInfo.getLastPage());
		mav.setViewName("admin/gonggao/selGg");
		return mav;
	}
	/**
	 * 
	 * @描述:根据id显示新闻信息
	 * @作者:
	 * @时间 2018年3月15日 下午5:39:37
	 * @获取一个: toadd
	 * @返回值:ModelAndView
	 */
	@RequestMapping(value="/showGg")
	public ModelAndView showGg(Integer id)throws Exception{
		ModelAndView mav = new ModelAndView();
		GongGao gg = shangpinService.selectByGg(id);
		mav.addObject("gg", gg);
		mav.setViewName("admin/gonggao/updateGg");
		return mav;
	}
	/**
	 * 
	 * @描述:保存修改新闻
	 * @作者:
	 * @时间 2018年3月15日 下午5:39:37
	 * @获取一个: toadd
	 * @返回值:ModelAndView
	 */
	@RequestMapping(value="/updateGg")
	public String updateGg(GongGao gg)throws Exception{
		gg.setDate(new Date());
		gg.setFname("admin");
		shangpinService.updateGg(gg);
		
		return "redirect:/shangpin/selGg";
	}
	/**
	 * 
	 * @描述:删除新闻
	 * @作者:
	 * @时间 2018年3月15日 下午5:39:37
	 * @获取一个: toadd
	 * @返回值:ModelAndView
	 */
	@RequestMapping(value="/deleteGg")
	public String deleteGg(Integer id)throws Exception{
		
		shangpinService.deleteByGg(id);
		
		return "redirect:/shangpin/selGg";
	}
	/**
	 * 
	 * @描述:查看统计信息
	 * @作者:
	 * @时间 2018年3月15日 下午5:39:37
	 * @获取一个: toadd
	 * @返回值:ModelAndView
	 */
	@RequestMapping(value="/selCount")
	public ModelAndView selCount(Integer page,ShangPin record)throws Exception{
		ModelAndView mav = new ModelAndView();
		List<ShangPin> ggList = shangpinService.selectCount(record);
		//分页
		if (page == null) {
			page = 1;
		}
		//分页		
		PageHelper.startPage(page,10,true);
		PageInfo<ShangPin> pageInfo = new PageInfo<ShangPin>(ggList); 
	  
		mav.addObject("ggList",ggList);
		mav.addObject("page", new PageInfo(ggList));
		mav.addObject("count", pageInfo.getTotal());
		mav.addObject("countPage", pageInfo.getPages());
		mav.addObject("lastPage", pageInfo.getLastPage());
		mav.setViewName("admin/count/selCount");
		return mav;
	}
	/**
	 * 
	 * @描述:打印计划表
	 * @作者:
	 * @时间 2018年3月15日 下午5:39:37
	 * @获取一个: toadd
	 * @返回值:ModelAndView
	 */
	@RequestMapping(value="/dayinCj")
	public String dayinCj(Integer id,ShangPin record)throws Exception{
		try
		   {
		List<ShangPin> list = shangpinService.selectCount(record);
		   File fileWrite = new File("D:/Write.xls");
		   fileWrite.createNewFile();
		   OutputStream os = new FileOutputStream(fileWrite);
		   ExcelExport export  = new ExcelExport(); 
		   export.excelExport(os,list);
		   }
		   catch(Exception e)
		   {
		   e.printStackTrace();
		   }
		   return "redirect:/shangpin/selCount";
	}
}
	
	
