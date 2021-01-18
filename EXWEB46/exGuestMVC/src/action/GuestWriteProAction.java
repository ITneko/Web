package action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.GuestDAO;
import model.GuestVO;

public class GuestWriteProAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		//int page = Integer.parseInt(request.getParameter("page"));
		String name = request.getParameter("name");
		String subject = request.getParameter("subject");
		String pass = request.getParameter("pass");
		String contents = request.getParameter("contents");
		
		
		GuestVO vo = new GuestVO();
		vo.setName(name);
		vo.setSubject(subject);
		vo.setContents(contents);
		vo.setPass(pass);
		
		GuestDAO dao = GuestDAO.getInstance();
		int row = dao.guestWrite(vo);
		
		request.setAttribute("row", row);
	//	request.setAttribute("page", page);
		
		RequestDispatcher rd = request.getRequestDispatcher("Guest/guest_write_pro.jsp");
		rd.forward(request, response);

	}

}
