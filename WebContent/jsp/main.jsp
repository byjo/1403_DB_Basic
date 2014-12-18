<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>JoJo's News Room</title>
	<link rel = "stylesheet" media = "screen" type = "text/css" href = "./../css/style.css" />
	<link rel = "stylesheet" media = "screen" type = "text/css" href = "./../css/main.css" />
</head>

<body>
	<header>
		<ul id = "menu">
			<li><a href = "/LoadArticleServlet">Main</a></li>
			<li><a href = "/AddArticleServlet">Add</a></li>
			<li><a href = "<c:url value="/ReplyServlet">							
						<c:param name="articleId" value="${article.articleId}" />
						</c:url>"
				>Reply</a>
			</li>
		</ul>
	</header>

	<section>
		<div id="top">
			<div class="top_edge"></div>
			<div class="top_bar"></div>
		</div>
		<div id="content">
			<div id="head">
				<div class="title">${article.title}</div>
				<div class="author">${article.name}</div>
				<div class="date">${article.date}</div>
			</div>
			<hr>
			<div id="text">${article.contents}</div>
		</div>
		<div id="bottom">
			<div class="bottom_bar"></div>
			<div class="bottom_edge"></div>
		</div>	
	</section>
	
	<nav>
		<ul id = "navi">
			<li><a href = "<c:url value="/LoadArticleServlet">
					<c:param name="articleId" value="${article.articleId-1}" />
					</c:url>"
			>prev</a></li>
			
			<li><a href = "<c:url value="/LoadArticleServlet">
					<c:param name="articleId" value="${article.articleId+1}" />
					</c:url>"
			>next</a></li>
		</ul>
	</nav>
	
	<footer>
	</footer>
</body>
</html>