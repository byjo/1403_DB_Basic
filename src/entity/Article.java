package entity;

public class Article {
	String articleId;
	String name;
	String date;
	String title;
	String contents;
	
	public Article(String articleId, String name, String date, String title,
			String contents) {
		this.articleId = articleId;
		this.name = name;
		this.date = date;
		this.title = title;
		this.contents = contents;
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
	
	public String getTitle() {
		return title;
	}
	
	public String getContents() {
		return contents;
	}
}
