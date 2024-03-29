<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<sec:authorize access="isAuthenticated()">
	<sec:authentication property="principal" var="principal"/>
</sec:authorize> 

<!DOCTYPE html>
<html lang="en">
<head>
  <title>Bootstrap Example</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" ></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.10.2/dist/umd/popper.min.js" ></script>

<!-- include libraries(jQuery, bootstrap) -->
<link href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css" rel="stylesheet">
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

<!-- include summernote css/js -->
<link href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.js"></script>

</head>
<body>
<nav class="navbar navbar-expand-md bg-dark navbar-dark">
    <a class="navbar-brand" href="/">Blog</a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#collapsibleNavbar">
      <span class="navbar-toggler-icon"></span>
    </button>
      
    <div class="collapse navbar-collapse" id="collapsibleNavbar">
      <c:choose> 
      	<c:when test="${empty principal}">
      		<ul class="navbar-nav" >
        		<li class="nav-item"><a class="nav-link" href="/auth/loginForm">로그인</a></li>
        		<li class="nav-item"><a class="nav-link" href="/auth/joinForm">회원가입</a></li>
      		</ul>
      	</c:when>
      	<c:otherwise>
      	    <ul class="navbar-nav" >
        		<li class="nav-item"><a class="nav-link" href="/board/saveForm">글쓰기</a></li>
        		<li class="nav-item"><a class="nav-link" href="/user/updateForm">회원정보</a></li>
        		<li class="nav-item"><a class="nav-link" href="/logout">로그아웃</a></li>
      		</ul>
      	</c:otherwise> 
      </c:choose>
    
  </div>
</nav>
 
 <br>