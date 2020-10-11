package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Dao.DownloadDao;
import model.Download;


@WebServlet("/GetDownloadListController")
public class GetDownloadListController extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session=request.getSession();


		DownloadDao downloadDao = new DownloadDao();
		List<Download> downloads = downloadDao.findAll();
		session.setAttribute("downloads", downloads);
		request.getRequestDispatcher("download.jsp").forward(request, response);

	}

}
