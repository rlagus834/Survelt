<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.4.1.js"
	integrity="sha256-WpOohJOqMqqyKL9FccASB9O0KwACQJpFTUBLTYOVvVU="
	crossorigin="anonymous"></script>
<script>
var page=1;
$(document).ready(function(){
$.ajax({
	type:"get",
	url:"BoardList",
	data:"page"+page,
	dataType:"page="+page,
	success:function(result){
		
	},error:function(){
		
	}
});	
	
});
</script>
</head>
<body>
<div id="BoardList"></div>
<div id="pageOrder"></div>


</body>
</html>