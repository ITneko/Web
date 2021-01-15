package adminservlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import admin.model.AdminDAO;
import admin.model.AdminVO;

/**
 * Servlet implementation class AdminIndexServlet
 */
@WebServlet("/notice_write")
public class AdminNoticeWriteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminNoticeWriteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RequestDispatcher rd = request.getRequestDispatcher("Admin/notice_write.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		//int page = Integer.parseInt(request.getParameter("page"));
		
		AdminVO admin = new AdminVO();
		admin.setSubject(request.getParameter("subject"));
		admin.setContents(request.getParameter("contents"));

		System.out.println(admin.getSubject());
		System.out.println(admin.getContents());
		AdminDAO dao = AdminDAO.getInstance();
		int row = dao.adminWrite(admin);
		
		//request.setAttribute("page", page);
		request.setAttribute("row", row);
		
		
		RequestDispatcher rd = request.getRequestDispatcher("Admin/notice_write_pro.jsp");
		rd.forward(request, response);
	}

}
