<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script src="https://code.jquery.com/jquery-3.4.1.js"
	integrity="sha256-WpOohJOqMqqyKL9FccASB9O0KwACQJpFTUBLTYOVvVU="
	crossorigin="anonymous"></script>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link type="text/css" rel="stylesheet"
	herf="${pageConetxt.request.contextPath}/resources/css/table.css">
<script type="text/javascript">
function memberViewAjax(viewId){
	$.ajax({
		type:"post",
		url:"viewId",
		data:{"id":viewId},
		dataType:"json", //
		success:function(result){
     console.log(result); 
console.log(result.id); //리턴받은 result는 타입이dto라 이렇게해도됨
var output="";
output+="<table border='1'>";
output+="<tr><th>id</th><th>password</th><th>phone</th><th>gender</th><th>email</th></tr>";
output+="<tr>";
output+="<td>"+result.id+"</td>";
output+="<td>"+result.password+"</td>";
output+="<td>"+result.phone+"</td>";
output+="<td>"+result.gender+"</td>";
output+="<td>"+result.email+"</td>";
output+="</tr>";
output+="</table>";

//div에 output에담긴값출력
$("#search").html(output);
		},
		error:function(){
console.log("실패");
		}

		})
	
}
</script>
</head>
<body>
	<table>
		<c:forEach var="movie" items="${memberList}">
			<tr>
				<td>${movie.id}</td>
				<td>${movie.password}</td>
				<td>${movie.gender}</td>
				<td>${movie.phone}</td>
				<td>${movie.email}</td>
				<td>
					<button onclick="memberViewAjax('${movie.id}')">sds</button>
				</td>
				<td><a href="memberUpdateSelect?id=${movie.id}">수정</a></td>
				<td><a href="memberDelete?id=${movie.id}">삭제</a></td>

			</tr>

		</c:forEach>
	</table>
<br>
<div id="search">
</body>
</html>