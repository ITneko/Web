package exUserServletJSTL.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import exUserServletJSTL.model.UsersVO;
import exUserServletJSTL.util.SHA256Util;
import exUserServletJSTL.model.UsersDAO;

/**
 * Servlet implementation class UserInsertServlet
 */
@WebServlet("/user_insert")
public class UserInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserInsertServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		RequestDispatcher rd = request.getRequestDispatcher("/Users/user_insert.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		UsersVO vo = new UsersVO();
		String email1 = request.getParameter("email1");
		String email2 = request.getParameter("email2");
		String email = email1+ "@" + email2;
		
		vo.setName(request.getParameter("name"));
		vo.setUserid(request.getParameter("userid"));
		vo.setPasswd(SHA256Util.getEncSHA256(request.getParameter("passwd")));
		vo.setTel(request.getParameter("tel"));
		vo.setEmail(email);
		
		System.out.println(vo.getName());
		System.out.println(vo.getUserid());
		System.out.println(vo.getPasswd());
		System.out.println(vo.getTel());
		
		UsersDAO dao = UsersDAO.getInstance();
		int row = dao.userInsert(vo);
		
		request.setAttribute("row", row);
		
		RequestDispatcher rd = request.getRequestDispatcher("/Users/user_insert_pro.jsp");
		rd.forward(request, response);
	}

}
