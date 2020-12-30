package exDay1229_.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import exDay1229_.model.GuestDAO;
import exDay1229_.model.GuestDTO;

/**
 * Servlet implementation class GuestModifyServlet
 */
@WebServlet("/guest_modify.do")
public class GuestModifyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GuestModifyServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int idx = Integer.parseInt(request.getParameter("idx"));
		GuestDAO dao = GuestDAO.getInstance();
		GuestDTO vo = dao.guestView(idx);
		
		request.setAttribute("vo", vo);
		
		RequestDispatcher rd = request.getRequestDispatcher("Guest/guest_modify.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		GuestDTO vo = new GuestDTO();
		request.setCharacterEncoding("UTf-8");
		int idx = Integer.parseInt(request.getParameter("idx"));
		int page = Integer.parseInt(request.getParameter("page"));
		vo.setIdx(idx);
		vo.setPass(request.getParameter("pass"));
		vo.setSubject(request.getParameter("subject"));
		vo.setContents(request.getParameter("contents"));

		
		GuestDAO dao = GuestDAO.getInstance();
		int row = dao.guestModify(vo);
		
		request.setAttribute("row", row);
		request.setAttribute("page", page);
		RequestDispatcher rd = request.getRequestDispatcher("Guest/guest_modify_pro.jsp");
		rd.forward(request, response);
	}

}
