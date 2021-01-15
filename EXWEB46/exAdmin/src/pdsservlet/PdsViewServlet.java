package pdsservlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pds_model.PdsDAO;
import pds_model.PdsVO;

/**
 * Servlet implementation class PdsViewServlet
 */
@WebServlet("/pds_view")
public class PdsViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PdsViewServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int idx = Integer.parseInt(request.getParameter("idx"));
		int page = Integer.parseInt(request.getParameter("page"));
		
		PdsDAO dao = PdsDAO.getInstance();
		
		boolean bool=false;
		Cookie info = null;
		Cookie[] cookies = request.getCookies();
		
		for(int i=0; i<cookies.length; i++) {
			info = cookies[i];
			if(info.getName().equals("pdsList"+idx)) {
				bool = true;
				break;
			}
		}
		
		String newValue = ""+System.currentTimeMillis();
		if(!bool) {
			Cookie cookie = new Cookie("pdsList"+idx, newValue);
			cookie.setMaxAge(60*60);
			response.addCookie(cookie);
			dao.pdsReadCount(idx);
		}
		
		PdsVO vo = dao.pdsView(idx);
		
		request.setAttribute("vo", vo);
		request.setAttribute("page", page);
		
		RequestDispatcher rd = request.getRequestDispatcher("Admin/pds_view.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
