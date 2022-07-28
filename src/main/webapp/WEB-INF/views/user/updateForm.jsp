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
<%@ include file="../layout/header.jsp" %>
 
<div class="container">
 	<form>
 	  <input type="hidden" id="id" value="${principal.user.id }" />
	  <div class="form-group">
	    <label for="username">Username</label>
	    <input value="${principal.user.username }" type="text" class="form-control" placeholder="Enter username" id="username" readonly>
	  </div>
	  <c:if test="${empty principal.user.oauth }">
	  <div class="form-group">
	    <label for="pwd">Password</label>
	    <input type="password" class="form-control" placeholder="Enter password" id="password">
	  </div>
		  <div class="form-group mb-3">
		    <label for="email">Email</label>
		    <input type="email" value="${principal.user.email }" class="form-control" placeholder="Enter email" id="email" readonly>
		  </div>
	  </c:if>
	</form> 
	<button id="btn-update" class="btn btn-primary ">회원수정</button>
</div>

<script src="/js/user.js"></script>
<%@ include file="../layout/footer.jsp" %>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
</body>
</html>