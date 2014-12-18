package article;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.Article;

@WebServlet("/LoadArticleServlet")
public class LoadArticleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String articleId = request.getParameter("articleId");
		
		ArticleDao dao = new ArticleDao();
		Article article = null;
		
		
		if(articleId == null)
			article = dao.loadLastArticle();
		else
			article = dao.loadArticle(articleId);

		request.setAttribute("article", article);
		
		RequestDispatcher rd = request.getRequestDispatcher("/jsp/main.jsp");
		rd.forward(request, response);	
	}
}
