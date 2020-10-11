package filter;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Dao.PermissionDao;
import model.T_resource;

public class PermissionResourceFilter implements Filter {
	private String notCheckPath;

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("notCheckPath" + notCheckPath);

		HttpServletRequest request = (HttpServletRequest) req;
		String path = request.getServletPath();

		System.out.println("path" + path); // 请求地不在需要过滤的列表范围,再进行是否登录
		if (notCheckPath.indexOf(path) == -1) {
			System.out.println("notCheckPath" + notCheckPath);
			HttpSession session = request.getSession();
			if ((Integer) session.getAttribute("result") == 1 || (Integer) session.getAttribute("result") == 0) {// 没有登录
				request.setAttribute("result", "没有权限访问!");
				request.getRequestDispatcher("error.jsp").forward(request, resp);
			} else {// 登录成功后进行权限判断
				PermissionDao permissionDao = new PermissionDao();
				String username = (String) session.getAttribute("username");
			

				ArrayList<T_resource> resources = permissionDao.findResourceByUserName(username);
				for (T_resource t_resource : resources) {

					String[] strings = t_resource.getUrl().split(",");
					boolean res = false;
					System.out.println(t_resource.getResourceName());

					for (int i = 0; i < strings.length; i++) {
						String string = strings[i];
						System.out.println(string);

					}

					System.out.println(path.substring(1));
					if (t_resource.getUrl().indexOf(path.substring(1)) != -1) {
						int a=t_resource.getUrl().indexOf(path.substring(1));
						System.out.println(a);
						res = true;
						request.getRequestDispatcher(path).forward(request, resp);
					}

					if (!res) {
						request.setAttribute("result", "没有权限访问!");
						request.getRequestDispatcher("error1.jsp").forward(request, resp);
					}
				}

			}
			chain.doFilter(req, resp);
		} else {
			chain.doFilter(req, resp);
		}

	}

	@Override
	public void init(FilterConfig config) throws ServletException {
		// TODO Auto-generated method stub
		notCheckPath = config.getInitParameter("notCheckPath");

	}

}
