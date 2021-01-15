package adminservlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import admin.model.AdminDAO;

/**
 * Servlet implementation class AdminIndexServlet
 */
@WebServlet("/index")
public class AdminIndexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminIndexServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RequestDispatcher rd = request.getRequestDispatcher("Admin/index.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String adminid = request.getParameter("adminid");
		String adminpass = request.getParameter("adminpass");
		System.out.println(adminid);
		System.out.println(adminpass);
		
		AdminDAO dao = AdminDAO.getInstance();
		int row = dao.adminLogin(adminid,adminpass);
		if(row==1) {
			HttpSession session = request.getSession();
			session.setAttribute("adminid", adminid);
			session.setMaxInactiveInterval(60*60);
		}
		
		request.setAttribute("row", row);
		
		RequestDispatcher rd = request.getRequestDispatcher("Admin/userlogin_ok.jsp");
		rd.forward(request, response);
	}

}
