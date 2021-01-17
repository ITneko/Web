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
 * Servlet implementation class AdminNoticeModifyServlet
 */
@WebServlet("/notice_modify")
public class AdminNoticeModifyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminNoticeModifyServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int idx = Integer.parseInt(request.getParameter("idx"));
		
		AdminDAO dao = AdminDAO.getInstance();
		AdminVO admin = dao.noticeView(idx);
		
		request.setAttribute("admin", admin);
		RequestDispatcher rd = request.getRequestDispatcher("Admin/notice_modify.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int idx = Integer.parseInt(request.getParameter("idx"));
		
		AdminDAO dao = AdminDAO.getInstance();
		AdminVO admin = new AdminVO();
		
		admin.setSubject(request.getParameter("subject"));
		admin.setContents(request.getParameter("contents"));
		admin.setIdx(idx);
		int row = dao.noticeModify(admin);
		
		request.setAttribute("row", row);
		
		RequestDispatcher rd = request.getRequestDispatcher("Admin/notice_modify_pro.jsp");
		rd.forward(request, response);
	}

}
