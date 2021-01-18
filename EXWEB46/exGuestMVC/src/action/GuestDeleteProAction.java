package action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.GuestDAO;

public class GuestDeleteProAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int idx = Integer.parseInt(request.getParameter("idx"));
		int page = Integer.parseInt(request.getParameter("page"));
		String pass = request.getParameter("pass");
		
		System.out.println(idx);
		System.out.println(page);
		System.out.println(pass);
		
		request.setAttribute("idx", idx);
		request.setAttribute("page", page);
		
		GuestDAO dao = GuestDAO.getInstance();
		int row = dao.guestDelete(idx, pass);
		
		request.setAttribute("row", row);
	}

}
