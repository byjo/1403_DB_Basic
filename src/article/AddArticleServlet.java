package article;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/AddArticleServlet")
public class AddArticleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/jsp/addArticle.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String addName = request.getParameter("addName");
		String addTitle = request.getParameter("addTitle");
		String addContents = request.getParameter("addContents");
		
		ArticleDao dao = new ArticleDao();
		int updatedRows = dao.addArticle(addName, addTitle, addContents);
		
		RequestDispatcher rd = request.getRequestDispatcher("/jsp/articleSuccess.jsp");
		rd.forward(request, response);	
	}

}
