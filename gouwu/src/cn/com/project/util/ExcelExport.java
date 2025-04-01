package cn.com.project.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;

import cn.com.project.shangpin.domain.ShangPin;
import cn.com.project.shangpin.service.ShangpinService;

import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;


public class ExcelExport extends HttpServlet {
	
	private static final long serialVersionUID = -5824318581633781502L;
	public  void excelExport(OutputStream os,List<ShangPin> list){
		  try{

		  WritableWorkbook wwb = Workbook.createWorkbook(os);

		  WritableSheet ws = wwb.createSheet("第一页",0);

		  Label label = new Label(0,0,"商品名称");
		  ws.addCell(label);
		  label = new Label(1,0,"商品单价（元）");
		  ws.addCell(label);
		  label = new Label(2,0,"销售数量");
		  ws.addCell(label);
		  label = new Label(3,0,"库存");
		  ws.addCell(label);
		  for(int i=0;i<list.size();i++){
			   label=new Label(0,i+1,list.get(i).getSname());
			   ws.addCell(label);
			   label=new Label(1,i+1,list.get(i).getPrice());
			   ws.addCell(label);
			   label=new Label(2,i+1,list.get(i).getSaleNumber());
			   ws.addCell(label);
			   label=new Label(3,i+1,list.get(i).getNumber());
			   ws.addCell(label);
		  }

		  wwb.write();
		  wwb.close();

		  }catch(Exception e){
		  System.out.println("生成信息表(Excel格式)时出错：");
		     e.printStackTrace();
		  }
		  }
		 public String getFileName(){
		  Date date=new Date();
		  Long dateL=date.getTime();
		  String fileName=dateL.toString()+".xls";
		  return fileName;
		 }
}


