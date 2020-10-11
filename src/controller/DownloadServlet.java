package controller;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/DownloadServlet")
public class DownloadServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String paString=null;
		String string=request.getParameter("按钮");
		if(string.equals("1"))  paString="/files/1.docx";
		else if (string.equals("2")) paString="/files/2.docx";
		else if (string.equals("3")) paString="/files/3.docx";
	
		  String path=request.getServletContext().getRealPath(paString);
		  
		  String fileName=path.substring(path.lastIndexOf("\\")+1);
		  
		  response.setHeader("content-disposition","attachment;filename=" +
		  URLEncoder.encode(fileName,"UTF-8") );
		  
		  InputStream in = new FileInputStream(path); int len =0;
		  
		  byte[] buffer = new byte[1024];
		  
		  ServletOutputStream out= response.getOutputStream(); while
		  ((len=in.read(buffer))!=-1) { out.write(buffer,0,len); } in.close();
		  out.close();
		 
		
	}


}
