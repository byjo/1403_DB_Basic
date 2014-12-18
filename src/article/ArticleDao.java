package article;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import entity.Article;


public class ArticleDao {
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	Article article = null;
	int updatedRows = -1;
	
	String address = "jdbc:mysql://192.168.56.102/midProj?useUnicode=true&characterEncoding=UTF-8";
	String id = "jojo";
	String pw = "abcd";
	
	public int addArticle(String addName, String addTitle, String addContents) {
		String sql = "INSERT INTO ARTICLE(name, date, title, contents) VALUES(?,NOW(),?,?)";
		
		try {	
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(address, id, pw);
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, addName);
			pstmt.setString(2, addTitle);
			pstmt.setString(3, addContents);
			
			updatedRows = pstmt.executeUpdate();
			
		} catch (Exception e) {
			System.out.println(e.toString());
			
		} finally {
			if(pstmt != null) try { pstmt.close(); } catch (SQLException e) {}				
			if(conn != null) try { conn.close(); } catch (SQLException e) {}				
		}
		
		return updatedRows;
	}
	
	public Article loadLastArticle() {
		String sql = "SELECT * FROM ARTICLE ORDER BY aId DESC LIMIT 1";	
		
		try {	
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(address, id, pw);
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				 article = new Article(rs.getString("aId"), rs.getString("name"), rs.getString("date"), rs.getString("title"), rs.getString("contents"));
			}
			
		} catch (Exception e) {
			System.out.println(e.toString());
			
		} finally {
			if(pstmt != null) try { pstmt.close(); } catch (SQLException e) {}				
			if(conn != null) try { conn.close(); } catch (SQLException e) {}				
		}
		
		return article;
	}
	
	public Article loadArticle(String articleId) {
		ResultSet rs = null;
		Article article = null;
		String sql = "SELECT * FROM ARTICLE WHERE aId = ?";	
		
		try {	
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(address, id, pw);
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, articleId);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				 article = new Article(rs.getString("aId"), rs.getString("name"), rs.getString("date"), rs.getString("title"), rs.getString("contents"));
			}
			
		} catch (Exception e) {
			System.out.println(e.toString());
			
		} finally {
			if(pstmt != null) try { pstmt.close(); } catch (SQLException e) {}				
			if(conn != null) try { conn.close(); } catch (SQLException e) {}				
		}
		
		return article;
	}
}
