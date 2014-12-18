<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>JoJo's News Room</title>
	<link rel = "stylesheet" media = "screen" type = "text/css" href = "./../css/style.css" />
	<link rel = "stylesheet" media = "screen" type = "text/css" href = "./../css/addArticle.css" />
</head>
<body>
	<header>
		<ul id = "menu">
			<li><a href = "/LoadArticleServlet">Main</a></li>
		</ul>
	</header>
	
	<section>
		<div id="top">
			<div class="top_edge"></div>
			<div class="top_bar"></div>
		</div>
		<div id="content">
			<form id="addArticle" action="/AddArticleServlet" method="POST">
				<input class="name" type="text" name="addName" value placeholder="이름">
				<input class="title" type="text" name="addTitle" value placeholder="제목">
				<textarea class="contents" name="addContents" value placeholder="내용"></textarea>
				<input class="submit" type="submit" name="addSubmit" value="작성">
			</form>
		</div>
		<div id="bottom">
			<div class="bottom_bar"></div>
			<div class="bottom_edge"></div>
		</div>	
	</section>
	
	<nav>
	</nav>
</body>
</html>