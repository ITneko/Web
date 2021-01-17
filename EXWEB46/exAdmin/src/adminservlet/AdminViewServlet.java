package adminservlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import admin.model.AdminDAO;
import admin.model.AdminVO;

/**
 * Servlet implementation class BaordViewServlet
 */
@WebServlet("/notice_view")
public class AdminViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AdminViewServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int idx = Integer.parseInt(request.getParameter("idx"));
		int page = 0;
		if (request.getParameter("page") != null) {
			Integer.parseInt(request.getParameter("page"));
		}
		request.setCharacterEncoding("UTF-8");

		AdminDAO dao = AdminDAO.getInstance();
		AdminVO admin = null;
		admin = dao.noticeView(idx);
		

		boolean bool = false;
		Cookie info = null;
		Cookie[] cookies = request.getCookies();

		for (int i = 0; i < cookies.length; i++) {
			info = cookies[i];
			if (info.getName().equals("NoticeList" + idx)) {
				bool = true;
				break;
			}
		}

		String newValue = "" + System.currentTimeMillis();
		if (!bool) {
			info = new Cookie("NoticeList" + idx, newValue);
			info.setMaxAge(24 * 60 * 60);
			response.addCookie(info);
			dao.adminReadCount(idx);
		}
		request.setAttribute("idx", idx);
		request.setAttribute("page", page);
		request.setAttribute("admin", admin);

		RequestDispatcher rd = request.getRequestDispatcher("Admin/notice_view.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
