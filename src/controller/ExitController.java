package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ExitController
 */
@WebServlet("/ExitController")
public class ExitController extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 删除session
		HttpSession session = request.getSession();
		session.invalidate();

		// 删除cookie
		Cookie[] cookies = request.getCookies();

		for (Cookie cookie : cookies) {

			cookie.setMaxAge(0);

			cookie.setPath("/");

			response.addCookie(cookie);

		} // 跳转到登录页面

		
		System.out.println("!!!!!!!");
		if (cookies!=null) {

			for (Cookie cookie : cookies) {
				
				System.out.println(cookie.getName()  +  cookie.getValue());
			}
		}
		else  {
			System.out.println("已删除");
		}
		response.sendRedirect("/test/login.html");


	}

}
