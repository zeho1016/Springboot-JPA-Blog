<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <title>Bootstrap Example</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<%@ include file="layout/header.jsp" %>
 
<div class="container mt-3">
<c:forEach var="board" items="${boards.content }">
  <div class="card m-2">
  	<div class="card-body">
    	<h4 class="card-title">${board.title }</h4>
    	<a href="/board/${board.id}" class="btn btn-primary">상세보기</a>
  	</div>
  </div>
</c:forEach>

<ul class="pagination justify-content-center">
  
  <c:choose>
  	<c:when test="${boards.first }">
	  <li class="page-item disabled"><a class="page-link" href="?page=${boards.number-1 }">Previous</a></li>
  	</c:when>
  	<c:otherwise>
  	  <li class="page-item"><a class="page-link" href="?page=${boards.number-1 }">Previous</a></li>
  	</c:otherwise>
  </c:choose>
  
  <c:choose>
  	<c:when test="${boards.last }">
	  <li class="page-item disabled"><a class="page-link" href="?page=${boards.number+1 }">Next</a></li>
  	</c:when> 
  	<c:otherwise>
  	  <li class="page-item"><a class="page-link" href="?page=${boards.number+1 }">Next</a></li>
  	</c:otherwise>
  </c:choose>
</ul>
  
</div>
<%@ include file="layout/footer.jsp" %>

</body>
</html>