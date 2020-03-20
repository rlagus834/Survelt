<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.4.1.js"
	integrity="sha256-WpOohJOqMqqyKL9FccASB9O0KwACQJpFTUBLTYOVvVU="
	crossorigin="anonymous"></script>
	
	
<script>
CommentList(1);

function CommentWrite(bnum){
	var texts=document.getElementById("textVal").value;
	$.ajax({
		type:"POST",
		url:"CommentWrite",
		data:"bnum="+bnum+"&text="+texts,
		dataType:"text",
		success:function(result){
		CommentList(1);
		document.getElementById("textVal").value="";
		},error:function(){
			
			
			
		}
				
	});
	
	
	
}


function CommentDelete(cnum){
	$.ajax({
		type:"POST",
		url:"CommentDelete",
		data:"cnum="+cnum,
		dataType:"text",
		success:function(result){
		CommentList(1);
		},error:function(){		
			alert('성공');
			
		}
				
	});
	
	
	
}




function CommentList(page){
	console.log(page);
	var bnum=${bnum};
	$.ajax({
		type:"POST",
		url:"CommentList",
		data:"page="+page+"&bnum="+bnum,
		dataType:"json",
		success:function(result){
		var save="";
		var pageSave="";
		var searchSave="";
		save+="<table>";
		for(var i=0;i<result.list.length;i++){
			save+="<tr>";
			save+="<td>"+result.list[i].id+"</td>";
			save+="<td>"+result.list[i].text+"</td>";	
if(result.list[i].id=='${sessionScope.id}'){
	save+="<td><p onclick='CommentDelete("+result.list[i].cnum+")'>삭제</p>/td>";	
	
}
			save+="</tr>";		
		}
		save+="</table>";
		var prevPage=result.paging.page-1;
		var nextPage=result.paging.page+1;
		$("#CommentList").html(save);
		if(result.paging.page<=1){
			pageSave+="[이전]&nbsp;";
		}
		if(result.paging.page>1){
			pageSave+="<a href='javascript:CommentList("+prevPage+")'>[이전]</a>&nbsp;";
		}
		for(var i=result.paging.startPage;i<=result.paging.endPage;i++){
			if(i == result.paging.page){
				pageSave+="<a href='javascript:CommentList("+i+")'>"+i+"</a>&nbsp;";					
			}else{
				pageSave+="<a href='javascript:CommentList("+i+")'>"+i+"</a>&nbsp;";										
			}
		}
		if(result.paging.page>=result.paging.maxPage){
			pageSave+="[다음]";			
		}
		if(result.paging.page<result.paging.maxPage){
			pageSave+="<a href='javascript:CommentList("+nextPage+")'>[다음]</a>&nbsp;";			
		}
		$("#pageOrder").html(pageSave);
		},error:function(){
			
		}
	});	
	
}
</script>
</head>
<body>
	<table>
		<c:forEach var="list" items="${list}">

			<tr>
				<td>${list.title}</td>
			</tr>
			<tr>
				<td>${list.text}</td>
			</tr>
			<tr>
				<c:forEach var="fileList" items="${fileList}">
					<td><img
						src="${pageContext.request.contextPath}/resources/fileUpload/${fileList.files}"
						width="300px" height="300px" ></td>
				</c:forEach>

			</tr>
			<tr>
				<c:forEach var="fileList" items="${fileList}">
					<td>${fileList.filesRealName}</td>
					<td><a href="FileDownLoad?files=${fileList.files}&filesRealName=${fileList.filesRealName}">다운</p></td>
				</c:forEach>
			</tr>
		</c:forEach>
		<button onclick="location.href='BoardUpdateForm?bnum=${bnum}'">수정</button>
		<button onclick="location.href='BoardDelete?bnum=${bnum}'">삭제</button>
		
		<div>
		
		<input type="text" name="text" id="textVal" >		
<button onclick="CommentWrite(${bnum})"></button>		
		</div>
		<div id="CommentList">
			
		</div>

		<div id="pageOrder">
			
		</div>
		
	</table>
</body>
</html>