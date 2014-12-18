package reply;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import entity.Reply;


public class ReplyDao {
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	ArrayList<Reply> replyList = new ArrayList<Reply>();
	int updatedRows = -1;
	
	String address = "jdbc:mysql://192.168.56.102/midProj?useUnicode=true&characterEncoding=UTF-8";
	String id = "jojo";
	String pw = "abcd";
	
	public ArrayList<Reply> loadReply(String articleId) {
		String sql = "SELECT * FROM REPLY WHERE aId = ?";	
		
		try {	
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(address, id, pw);
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, articleId);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				replyList.add(new Reply(rs.getString("rId") ,rs.getString("aId"), rs.getString("name"), rs.getString("date"), rs.getString("contents")));
			}
			
		} catch (Exception e) {
			System.out.println(e.toString());
			
		} finally {
			if(pstmt != null) try { pstmt.close(); } catch (SQLException e) {}				
			if(conn != null) try { conn.close(); } catch (SQLException e) {}				
		}
		
		return replyList;
	}

	public int addReply(String articleId, String addName, String addContents) {
		String sql = "INSERT INTO REPLY(aId ,name, date, contents) VALUES(?,?,NOW(),?)";
		
		try {	
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(address, id, pw);
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, articleId);
			pstmt.setString(2, addName);
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
}
