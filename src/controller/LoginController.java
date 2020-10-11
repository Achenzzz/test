package controller;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Dao.UserDao;
import model.User;
import service.UserService;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	 UserService userService=new UserService();


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		UserDao userDao=new UserDao();

		HttpSession session = request.getSession();
		String userCode = request.getParameter("userCode");// 用户输入的验证码
		String vCode = (String) session.getAttribute("verityCode");// 正确的验证码
		String username = request.getParameter("username");//获取用户输入的账号
		String password = request.getParameter("password");//密码
		String autologin = request.getParameter("autologin");//免登陆
		//System.out.println(autologin);
		
		session.setAttribute("username", username);
		session.setAttribute("password", password);
		User user=userDao.finduserByusername(username);
	    int result=userService.login(username,password);
	    session.setAttribute("result", result);//存放result
		if (!userCode.equalsIgnoreCase(vCode)) {// 验证码错误 

			System.out.println("验证码错误!");
			request.setAttribute("result", "验证码错误！");

			request.getRequestDispatcher("error.jsp?").forward(request, response);
		}
		else {//先进行验证码判断 再进行账号密码判断
			if (result==0) {
				System.out.println("账号错误！");//账号错误还要传给error.jsp 一个值告诉错误类型
				request.setAttribute("result", "账号错误！");

				request.getRequestDispatcher("error.jsp").forward(request, response);
//				((HttpServletResponse) request).sendRedirect("error.jsp?result=0");


			}
			else if (result==1) {
				System.out.println("密码错误！");//密码错误还要传给error.jsp 一个值告诉错误类型
				request.setAttribute("result", "账号错误！");
				request.getRequestDispatcher("error.jsp").forward(request, response);
//				((HttpServletResponse) request).sendRedirect("error.jsp?result=1");
			}
			else {
				System.out.println("登录成功！");
				request.setAttribute("username", user.getUsername());
				request.setAttribute("result", "ture");
				if (autologin!=null) {
					//中文编码
					String encodeUsername = URLEncoder.encode(username,"utf-8");
					String encodePassword = URLEncoder.encode(password,"utf-8");
					Cookie cookie1=new Cookie("username", encodeUsername);
					Cookie cookie2=new Cookie("password", encodePassword);
					
					cookie1.setPath("/");
					cookie2.setPath("/");

					response.addCookie(cookie1);
					response.addCookie(cookie2);
					
				}
				request.getRequestDispatcher("main.jsp").forward(request, response);


			}
		}
	}

}
