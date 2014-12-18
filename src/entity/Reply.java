package entity;

public class Reply {
	String replyId;
	String articleId;
	String name;
	String date;
	String contents;
	
	public Reply(String replyId, String articleId, String name, String date,
			String contents) {
		this.replyId = replyId;
		this.articleId = articleId;
		this.name = name;
		this.date = date;
		this.contents = contents;
	}

	public Reply(String articleId) {
		this.articleId = articleId;
	}

	public String getReplyId() {
		return replyId;
	}
	
	public String getArticleId() {
		return articleId;
	}
	
	public String getName() {
		return name;
	}
	
	public String getDate() {
		return date;
	}
	
	public String getContents() {
		return contents;
	}

}
