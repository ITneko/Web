package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class userinfoinsertServlet
 */
@WebServlet("/insert.do")
public class userinfoinsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public userinfoinsertServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/Member/userinfo_insert.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/Member/userinfo_insert_pro.jsp");
		request.setCharacterEncoding("UTF-8");
		String name = request.getParameter("name");
		String[] fa = request.getParameterValues("fa");
		String str = fa[0];
		for(int i=1; i<fa.length; i++) {
			str = str + "," + fa[i];
		}
		
		request.setAttribute("name", name);
		request.setAttribute("str", str);
		
		rd.forward(request, response);
	}

}
