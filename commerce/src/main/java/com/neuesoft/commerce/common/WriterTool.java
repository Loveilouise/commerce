package com.neuesoft.commerce.common;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class WriterTool {
  public  static void  write (HttpServletResponse  response,String  content){
	   response.setContentType("text/json;charset=UTF-8");
	   PrintWriter out;
	try {
		out = response.getWriter();
		out.write(content);
		out.flush();
		out.close();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	  
  }
}
