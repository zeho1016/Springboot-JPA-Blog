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
	
	<form>
	  <input type="hidden" id="id" value="${board.id }">
	  <div class="form-group">
	    <input value="${board.title}" type="text" class="form-control" id="title">
	  </div>
	  
	  <div class="form-group">
	    <textarea class='form-control summernote' rows="5" cols="" id="content">${board.content}</textarea>
	  </div>
	</form>  
	  <button id="btn-cancel" class="btn btn-primary mt-3">취소</button>
	  <button id="btn-update" class="btn btn-primary mt-3">수정</button>
</div>

<script>
$('.summernote').summernote({
    tabsize: 2,
    height: 300
  });
</script>
<script src="/js/board.js"></script>
<%@ include file="../layout/footer.jsp" %>
</body>
</html>