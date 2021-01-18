package action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.GuestDAO;
import model.GuestVO;

public class GuestModifyProAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		int idx = Integer.parseInt(request.getParameter("idx"));
		int page = Integer.parseInt(request.getParameter("page"));
		
		String subject = request.getParameter("subject");
		String pass = request.getParameter("pass");
		String contents = request.getParameter("contents");
		
		
		GuestVO vo = new GuestVO();
		vo.setSubject(subject);
		vo.setContents(contents);
		vo.setPass(pass);
		
		GuestDAO dao = GuestDAO.getInstance();
		int row = dao.guestModify(vo, idx);
		
		request.setAttribute("row", row);
		
		RequestDispatcher rd = request.getRequestDispatcher("Guest/guest_modify_pro.jsp");
		rd.forward(request, response);

	}

}
