package exSample.servlet;

import java.io.File;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import exSample.model.PdsDAO;
import exSample.model.PdsVO;

/**
 * Servlet implementation class PdsDeleteServlet
 */
@WebServlet("/pds_delete.do")
public class PdsDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public PdsDeleteServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int idx = Integer.parseInt(request.getParameter("idx"));
		int page = Integer.parseInt(request.getParameter("page"));

		request.setAttribute("idx", idx);
		request.setAttribute("page", page);

		RequestDispatcher rd = request.getRequestDispatcher("Pds/pds_delete.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int idx = Integer.parseInt(request.getParameter("idx"));
		int page = Integer.parseInt(request.getParameter("page"));
		String pass = request.getParameter("pass");
		ServletContext context = getServletContext();
		// 파일 저장경로
		String path = context.getRealPath("Pds/upload/");


		// new DefaultFileRenamePolicy() : 파일 중복시 자동이름 변경

		PdsDAO dao = PdsDAO.getInstance();
		PdsVO vo = dao.pdsView(idx);

		int row = dao.pdsDelete(idx, pass);

		if (row == 1) {
			// 구 파일 삭제
			File f = new File(path + vo.getFilename());
			if (f.exists()) {
				System.out.println("OK");
				f.delete();
			} else {
				System.out.println("flase");
			}
		}

		request.setAttribute("page", page);
		request.setAttribute("row", row);

		RequestDispatcher rd = request.getRequestDispatcher("Pds/pds_delete_pro.jsp");
		rd.forward(request, response);
	}

}
