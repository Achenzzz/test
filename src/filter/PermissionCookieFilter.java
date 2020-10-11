
package filter;

import java.io.IOException;
import java.net.URLDecoder;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebFilter(urlPatterns = "/login.html")
public class PermissionCookieFilter implements Filter {

	@Override
	public void destroy() {

	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {

		HttpServletRequest request = (HttpServletRequest) req;
		HttpSession session=request.getSession();
		/*
		 * String string=(String)session.getAttribute("username"); String path =
		 * request.getServletPath(); System.out.println(path); if (string==null) {
		 * request.getRequestDispatcher("error.jsp?").forward(request, resp);
		 * 
		 * }
		 */
		Cookie [] cookies=request.getCookies();
		if (cookies!=null) {
			
		
		for (Cookie cookie : cookies) {
			String string=cookie.getValue();
			String username=URLDecoder.decode(string,"utf-8");
			if (cookie.getName().equals("username")) {
					session.setAttribute("username", username);
					request.getRequestDispatcher("main.jsp").forward(request, (HttpServletResponse)resp);	
			}
		
		}
		}
		chain.doFilter(req, resp);
		
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {

	}

}
