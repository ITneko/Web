package exDay1229_.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.apple.concurrent.Dispatch;

import exDay1229_.model.GuestDAO;
import exDay1229_.model.GuestDTO;

/**
 * Servlet implementation class GuestWriteServlet
 */
@WebServlet("/guest_write.do")
public class GuestWriteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GuestWriteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int page = Integer.parseInt(request.getParameter("page"));
		
		request.setAttribute("page", page);
		RequestDispatcher rd = request.getRequestDispatcher("Guest/guest_write.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTf-8");
		int page = Integer.parseInt(request.getParameter("page"));
		GuestDTO vo = new GuestDTO();
		vo.setName(request.getParameter("name"));
		vo.setPass(request.getParameter("pass"));
		vo.setSubject(request.getParameter("subject"));
		vo.setContents(request.getParameter("contents"));
		
		GuestDAO dao = GuestDAO.getInstance();
		int row = dao.guestWrite(vo);
		
		request.setAttribute("row", row);
		request.setAttribute("page", page);
		
		
		RequestDispatcher rd = request.getRequestDispatcher("Guest/guest_write_pro.jsp");
		rd.forward(request, response);
	}

}
