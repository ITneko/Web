package com.jslhrd.service.admin.pds;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jslhrd.domain.pds.PdsDAO;
import com.jslhrd.domain.pds.PdsVO;
import com.jslhrd.service.Action;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class AdminPdsWriteProAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		ServletContext context = request.getSession().getServletContext();//getServletContext();
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
		
	
		
		PdsDAO dao = PdsDAO.getInstance();
		int row = dao.pdsWrite(vo);
		
		request.setAttribute("row", row);
		
		RequestDispatcher rd = request.getRequestDispatcher("Admin/pds_write_pro.jsp");
		rd.forward(request, response);
	}

}
