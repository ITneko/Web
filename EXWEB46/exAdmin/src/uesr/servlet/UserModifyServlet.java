package uesr.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import uesr.model.UsersDAO;
import uesr.model.UsersVO;
import util.SHA256Util;

/**
 * Servlet implementation class UserIdcheckServlet
 */
@WebServlet("/user_modify")
public class UserModifyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserModifyServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("Users/user_modify.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userid = request.getParameter("userid");
		String passwd = SHA256Util.getEncSHA256(request.getParameter("passwd"));
		String newpasswd = SHA256Util.getEncSHA256(request.getParameter("newpasswd"));
		String tel = request.getParameter("tel");
		
		UsersVO vo = new UsersVO();
		UsersDAO dao = UsersDAO.getInstance();
		
		vo.setUserid(userid);
		vo.setPasswd(passwd);
		vo.setNewpasswd(newpasswd);
		vo.setTel(tel);
		int row = dao.userModify(vo);
	
		RequestDispatcher rd = request.getRequestDispatcher("Users/user_modify_pro.jsp");
		rd.forward(request, response);
	}

}
