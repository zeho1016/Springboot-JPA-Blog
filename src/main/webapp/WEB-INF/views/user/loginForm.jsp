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
 
<div class="container mt-3">
 	<form action="/auth/loginProc" method="post">
	  
	  <div class="form-group">
	    <label for="username">Username</label>
	    <input type="text" name="username" class="form-control" placeholder="Enter username" id="username">
	  </div>
	  
	  <div class="form-group">
	    <label for="pwd">Password</label>
	    <input type="password" name="password" class="form-control" placeholder="Enter password" id="password">
	  </div>
	  <div class="form-group">
		  <button id="btn-login" class="btn btn-primary me-2">로그인</button>
		  <a href=" https://kauth.kakao.com/oauth/authorize?client_id=3a11aea65b874a0123b32fd07e333586&redirect_uri=http://localhost:8000/auth/kakao/callback&response_type=code"><img height ="34px" src="/images/kakao_login_button.png"/></a>
	  </div>
	</form> 
	
</div>

<%@ include file="../layout/footer.jsp" %>

<!-- <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
 -->
 </body>
</html>