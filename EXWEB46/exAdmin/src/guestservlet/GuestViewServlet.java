package guestservlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import guest.model.GuestDAO;
import guest.model.GuestVO;

/**
 * Servlet implementation class GuestViewServlet
 */
@WebServlet("/guest_view")
public class GuestViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public GuestViewServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		int idx = Integer.parseInt(request.getParameter("idx"));
		int page = 0;
		if (request.getParameter("page") != null) {
			page = Integer.parseInt(request.getParameter("page"));
		}
		GuestDAO dao = GuestDAO.getInstance();
		GuestVO vo = dao.guestView(idx);

		boolean bool = false;
		Cookie info = null;
		Cookie[] cookies = request.getCookies();

		for (int i = 0; i < cookies.length; i++) {
			info = cookies[i];
			if (info.getName().equals("GuestList" + idx)) {
				bool = true;
				break;
			}
		}

		String newValue = "" + System.currentTimeMillis();
		if (!bool) {
			info = new Cookie("GuestList" + idx, newValue);
			info.setMaxAge(60 * 60);
			response.addCookie(info);
			dao.guestReadCnt(idx);
		}

		request.setAttribute("idx", idx);
		request.setAttribute("page", page);
		request.setAttribute("vo", vo);

		RequestDispatcher rd = request.getRequestDispatcher("Admin/guest_view.jsp");
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
