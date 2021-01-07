package exSample.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import exSample.model.GuestDAO;
import exSample.model.GuestVO;
import exSample.util.PageIndex;

/**
 * Servlet implementation class GuestListServlet
 */
@WebServlet("/guest_list")
public class GuestListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GuestListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		GuestVO vo = new GuestVO();
		GuestDAO dao = GuestDAO.getInstance();
		int totcount = dao.guestCount();
		
		int nowpage= 1;
		int maxlist = 10;
		int totpage =1;
		
		if(totcount % maxlist ==0) {
			totpage = totcount / maxlist;
		}else {
			totpage = totcount /maxlist + 1;
		}
		
		if(totcount == 0 ) totpage = 1;
		
		if(request.getParameter("page")!=null) {
			nowpage = Integer.parseInt(request.getParameter("page"));
		}
		if(nowpage>totpage) nowpage = totpage;
		
		int startpage = (nowpage-1)*maxlist +1;
		int endpage = nowpage * maxlist;
		int listcount = totcount - ((nowpage-1)*maxlist);
		
		List<GuestVO> list = null;
	
		list = dao.guestList(startpage, endpage);
		
		
		String pageSkip = "";
	
		pageSkip = PageIndex.pageList(nowpage, totpage, "guest_list", "");

		
		request.setAttribute("totcount", totcount);
		request.setAttribute("totpage", totpage);
		request.setAttribute("page", nowpage);
		request.setAttribute("listcount", listcount);
		request.setAttribute("list", list);
		request.setAttribute("pageSkip", pageSkip);
		
		
		RequestDispatcher rd = request.getRequestDispatcher("Guest/guest_list.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
