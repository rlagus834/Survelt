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
<script type="text/javascript">
	$.ajax({
		type : "GET",
		url : "board",
		dataType : "json",
		success : function(result) {
			var length = result.length;
			var tb = "";
			tb += "<table border='1px'>";
			for (var i = 0; i < length; i++) {
				tb += "<tr>";
				tb += "<td>" + result[i].bnum + "</td>";
				tb += "<td>" + result[i].id + "</td>";
				tb += "<td>"+ result[i].title+"</td>";
				tb += "<td>" + result[i].text + "</td>";
				tb += "</tr>";
			};
			tb += "</table>";
			$("#search").html(tb);
		},
		error : function() {
		}
	});
</script>
</head>
<body>
	<div id="search"></div>
	<button onclick="location.href='boardWrite'">글쓰기</button>

</body>
</html>