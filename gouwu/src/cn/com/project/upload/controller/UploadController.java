package cn.com.project.upload.controller;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.com.project.shangpin.domain.ShangPin;
import cn.com.project.upload.service.UploadService;
import cn.com.project.util.Comm;
import cn.com.project.util.FileUploadTool;
import cn.com.project.web.user.domain.User;


public class UploadController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8272973503552210639L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request,response);
}
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			request.setCharacterEncoding("UTF-8");
			String method = request.getParameter("method");
			
				 if("saveSp".equals(method)){
					 FileUploadTool fut = new FileUploadTool(request);
						fut.upload();
						String m_id = fut.getParameter("m_id");
						String sname = fut.getParameter("sname");
						String price = fut.getParameter("price");
						String sx = fut.getParameter("sx");
						String number = fut.getParameter("number");
						String color = fut.getParameter("color");
						String miaoshu = fut.getParameter("miaoshu");
						String photo = fut.getParameter("photo");
						ShangPin sp = new ShangPin();
						sp.setSname(sname);
						sp.setSx(sx);
						sp.setPrice(price);
						sp.setPhoto(photo);
						sp.setMiaoshu(miaoshu);
						sp.setmId(m_id);
						sp.setNumber(number);
						sp.setColor(color);
						new UploadService().addSp(sp);
					response.sendRedirect("shangpin/selSp");
				}else if("saveUpdateSp".equals(method)){	
					 FileUploadTool fut = new FileUploadTool(request);
						fut.upload();
						String id = fut.getParameter("id");
						String m_id = fut.getParameter("m_id");
						String sname = fut.getParameter("sname");
						String price = fut.getParameter("price");
						String sx = fut.getParameter("sx");
						String number = fut.getParameter("number");
						String color = fut.getParameter("color");
						String miaoshu = fut.getParameter("miaoshu");
						String photo = fut.getParameter("photo");
						ShangPin sp = new ShangPin();
						sp.setId(id);
						sp.setSname(sname);
						sp.setSx(sx);
						sp.setPrice(price);
						sp.setPhoto(photo);
						sp.setMiaoshu(miaoshu);
						sp.setmId(m_id);
						sp.setNumber(number);
						sp.setColor(color);
						new UploadService().updateSp(sp);
						response.sendRedirect("shangpin/selSp");
				}else if("saveUser".equals(method)){	
					 FileUploadTool fut = new FileUploadTool(request);
						fut.upload();
						String[] beforeShuffle = new String[] {"1", "2", "3", "4", "5", "6", "7",  
				                "8", "9","10"   
				                 };  
				        List list = Arrays.asList(beforeShuffle);  
				        Collections.shuffle(list);  
				        StringBuilder sb = new StringBuilder();  
				        for (int i = 0; i < list.size(); i++) {  
				            sb.append(list.get(i));  
				        }  
				        String afterShuffle = sb.toString();  
				        String number = afterShuffle.substring(6, 9); 
						String id = (String)request.getSession().getAttribute("id");
						String name = fut.getParameter("name");
						String password = fut.getParameter("password");
						String email = fut.getParameter("email");
						String photo = fut.getParameter("photo");
						User u = new User();
						u.setName(name);
						u.setPassword(password);
						u.setEmail(email);
						u.setPhoto(photo);
						u.setdId(id);
						u.setNumber(number);
						new UploadService().saveUser(u);
						request.getRequestDispatcher("/index/temp/login.jsp").forward(request, response);
				}else if("saveUpdateUser".equals(method)){	
					 FileUploadTool fut = new FileUploadTool(request);
						fut.upload();
						String number = (String)request.getSession().getAttribute("number");
						String name = fut.getParameter("name");
						String password = fut.getParameter("password");
						String email = fut.getParameter("email");
						String photo = fut.getParameter("photo");
						User u = new User();
						u.setNumber(number);
						u.setName(name);
						u.setPassword(password);
						u.setEmail(email);
						u.setPhoto(photo);
						new UploadService().saveUpdateUser(u);
						response.sendRedirect("web/oper/showUser");
				}	
			}
}
