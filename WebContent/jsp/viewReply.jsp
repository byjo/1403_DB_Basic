<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>JoJo's News Room</title>
	<link rel = "stylesheet" media = "screen" type = "text/css" href = "./../css/style.css" />
	<link rel = "stylesheet" media = "screen" type = "text/css" href = "./../css/viewReply.css" />
</head>
<body>
	<header>
		<ul id = "menu">
			<li><a href = "/LoadArticleServlet">Main</a></li>
			<li><a href = "/AddArticleServlet">Add</a></li>
			<li><a href = "<c:url value="/LoadArticleServlet">
						<c:param name="articleId" value="${articleId}" />
						</c:url>"
				>Article</a>
			</li>
		</ul>
	</header>

	<section>
		<div id="top">
			<div class="top_edge"></div>
			<div class="top_bar"></div>
		</div>
		
		<div id="content">
			<div id = "addReply">
				<form action="/AddReplyServlet" method="POST">
					<input type="hidden" name="articleId" value="${articleId}">
					<input class="addReplyName" type="text" name="addReplyName" value placeholder="이름">
					<textarea class="addReplyContents" name="addReplyContents" value placeholder="내용"></textarea>
					<input class="addReplySubmit" type="submit" name="addReplySubmit" value="작성">
				</form>
			</div>
			<div id="replyWrap">
				<c:forEach items="${replyList}" var="reply" varStatus="status">
					<hr>
					<div id = "viewReply">
						<div class="replyAuthor">${reply.name}</div>
						<div class="replyDate">${reply.date}</div>
						<div class="replyContents">${reply.contents}</div>
					</div>
				</c:forEach>
			</div>
		</div>
		<div id="bottom">
			<div class="bottom_bar"></div>
			<div class="bottom_edge"></div>
		</div>	
	</section>
	
	<footer>
	</footer>
</body>
</html>