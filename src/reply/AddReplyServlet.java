package reply;


import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import reply.ReplyDao;

@WebServlet("/AddReplyServlet")
public class AddReplyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String articleId = request.getParameter("articleId");
		String addReplyName = request.getParameter("addReplyName");
		String addReplyContents = request.getParameter("addReplyContents");
		
		ReplyDao dao = new ReplyDao();
		int updatedRows = dao.addReply(articleId, addReplyName, addReplyContents);
		
		request.setAttribute("articleId", articleId);
		RequestDispatcher rd = request.getRequestDispatcher("/jsp/replySuccess.jsp");
		rd.forward(request, response);	
	}

}
