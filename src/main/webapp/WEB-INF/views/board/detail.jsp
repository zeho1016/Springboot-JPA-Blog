<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <title>saveForm</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<%@ include file="../layout/header.jsp" %>
 
<div class="container">
	  <div class="mb-3">
	  	글번호: <span id="id"><i>${board.id } </i></span>
	  	작성자: <span id="username"><i>${board.user.username } </i></span>
	  	조회수: <span id="count"><i>${board.count} </i></span>
	  	
	  </div>	  
	  
	  <div>
	    title: <h3>${board.title }</h3>
	  </div>
	  <hr>
	  <div>
	    content: <div>${board.content }</div>
	  </div>
	  <div class="mb-3">
		 <c:if test="${board.user.id == principal.user.id }">
		 <a href="/board/${board.id}/updateForm" class="btn btn-warning">수정</a>
		 <button id="btn-delete" class="btn btn-danger">삭제</button>
		 </c:if>	
		 <button class="btn btn-dark" onclick="history.back()">뒤로</button>
	  </div>
</div>


<script src="/js/board.js"></script>
<%@ include file="../layout/footer.jsp" %>
</body>
</html>