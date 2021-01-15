package pdsservlet;

import java.io.File;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import pds_model.PdsDAO;
import pds_model.PdsVO;

/**
 * Servlet implementation class PdsModifyServlet
 */
@WebServlet("/pds_modify")
public class PdsModifyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public PdsModifyServlet() {
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

		PdsDAO dao = PdsDAO.getInstance();
		PdsVO vo = dao.pdsView(idx);

		request.setAttribute("idx", idx);
		request.setAttribute("page", page);
		request.setAttribute("vo", vo);
		RequestDispatcher rd = request.getRequestDispatcher("Pds/pds_modify.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		int idx = Integer.parseInt(request.getParameter("idx"));
		int page = Integer.parseInt(request.getParameter("page"));

		ServletContext context = getServletContext();
		// 파일 저장경로
		String path = context.getRealPath("Pds/upload/");
		String encType = "UTF-8";
		int sizeLimit = 3 * 1024 * 1024; // 파일 최대 용량설정(최대2MB)

		MultipartRequest multi = new MultipartRequest(request, path, sizeLimit, encType, new DefaultFileRenamePolicy());
		// new DefaultFileRenamePolicy() : 파일 중복시 자동이름 변경

		PdsVO vo = new PdsVO();
		vo.setIdx(idx);
		vo.setName(multi.getParameter("name"));
		vo.setEmail(multi.getParameter("email"));
		vo.setSubject(multi.getParameter("subject"));
		vo.setContents(multi.getParameter("contents"));
		vo.setFilename(multi.getFilesystemName("filename"));
		vo.setPass(multi.getParameter("pass"));
		
		String oldfilename = multi.getParameter("oldfilename");
		
		// 첨부파일이 있는지 검사
		if(vo.getFilename()==null) {
			vo.setFilename(oldfilename);
		}else {
			// 구 파일 삭제
			File f = new File(path+oldfilename);
			if(f.exists()) {
				System.out.println("OK");
				f.delete();
			}else {
				System.out.println("flase");
			}
		}
		PdsDAO dao = PdsDAO.getInstance();
		int row = dao.pdsModify(vo);
		
		request.setAttribute("row", row);
		RequestDispatcher rd = request.getRequestDispatcher("Admin/pds_modify_pro.jsp");
		rd.forward(request, response);
	}

}
