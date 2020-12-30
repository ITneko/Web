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
 * Servlet implementation class GuestDeleteServlet
 */
@WebServlet("/guest_delete.do")
public class GuestDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GuestDeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int idx = Integer.parseInt(request.getParameter("idx"));
		int page = Integer.parseInt(request.getParameter("page"));
		request.setAttribute("idx", idx);
		request.setAttribute("page", page);
		
		RequestDispatcher rd = request.getRequestDispatcher("Guest/guest_delete.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		GuestDTO vo = new GuestDTO();
		request.setCharacterEncoding("UTf-8");
		int idx = Integer.parseInt(request.getParameter("idx"));
		vo.setIdx(idx);
		vo.setPass(request.getParameter("pass"));

		
		GuestDAO dao = GuestDAO.getInstance();
		int row = dao.guestDelete(vo);
		
		request.setAttribute("row", row);
		RequestDispatcher rd = request.getRequestDispatcher("Guest/guest_delete_pro.jsp");
		rd.forward(request, response);
	}

}
