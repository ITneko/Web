package com.jslhrd.service.admin.pds;

import java.io.File;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jslhrd.domain.pds.PdsDAO;
import com.jslhrd.domain.pds.PdsVO;
import com.jslhrd.service.Action;

public class AdminPdsDeleteProAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int idx = Integer.parseInt(request.getParameter("idx"));
		int page = Integer.parseInt(request.getParameter("page"));
		String pass = request.getParameter("pass");
		ServletContext context = request.getSession().getServletContext();//getServletContext();
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

		RequestDispatcher rd = request.getRequestDispatcher("Admin/pds_delete_pro.jsp");
		rd.forward(request, response);
	}

}
