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
	  
	  <button id="btn-login" class="btn btn-primary ">가입</button>
	</form> 
</div>

<%@ include file="../layout/footer.jsp" %>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
</body>
</html>