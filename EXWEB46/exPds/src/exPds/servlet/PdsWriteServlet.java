package exPds.servlet;

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

import exPds.model.PdsDAO;
import exPds.model.PdsVO;

/**
 * Servlet implementation class PdsWriteServlet
 */
@WebServlet("/pds_write.do")
public class PdsWriteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PdsWriteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		
		RequestDispatcher rd = request.getRequestDispatcher("Pds/pds_write.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		ServletContext context = getServletContext();
		// 파일 저장경로
		String path = context.getRealPath("Pds/upload");
		String encType = "UTF-8";
		int sizeLimit = 3*1024*1024; // 파일 최대 용량설정(최대2MB)
		
		MultipartRequest multi = new MultipartRequest(request, path, sizeLimit, encType, new DefaultFileRenamePolicy());
		// new DefaultFileRenamePolicy() : 파일 중복시 자동이름 변경
		
		PdsVO vo = new PdsVO();
		vo.setName(multi.getParameter("name"));
		vo.setEmail(multi.getParameter("email"));
		vo.setSubject(multi.getParameter("subject"));
		vo.setContents(multi.getParameter("contents"));
		vo.setFilename(multi.getFilesystemName("filename"));
		vo.setPass(multi.getParameter("pass"));
		
		System.out.println("이름: " + vo.getName());
		System.out.println("메일: " + vo.getEmail());
		System.out.println("제목: " + vo.getSubject());
		System.out.println("내용: " + vo.getContents());
		System.out.println("파일제목: " + vo.getFilename());
		System.out.println("비밀번호: " + vo.getPass());
		
		PdsDAO dao = PdsDAO.getInstance();
		int row = dao.pdsWrite(vo);
		
		request.setAttribute("row", row);
		
		response.sendRedirect("pds_list.do");
	//	RequestDispatcher rd = request.getRequestDispatcher("Pds/pds_write_pro2.jsp");
	//	rd.forward(request, response);
	}

}
