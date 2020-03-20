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
var search="작성자";
var selects="";   

$(document).ready(function() {
	 getBoardList('1');
})

function ListSearch(){
	 search=$("#search").val();	
 selects=$("#selects").val();
console.log(search);
console.log(selects);
getBoardList('1');
}

function getBoardList(page){
$.ajax({
	type:"get",
	url:"BoardList",
	data:"page="+page+"&search="+search+"&select="+selects,
	dataType:"json",
	success:function(result){
	var save="";
	var pageSave="";
	var searchSave="";
	save+="<table>";
	for(var i=0;i<result.list.length;i++){
		save+="<tr>";
		save+="<td>"+result.list[i].id+"</td>";
		save+="<td><a href='BoardView?bnum="+result.list[i].bnum+"'>"+result.list[i].title+"</a></td>";
		save+="<td>"+result.list[i].counts+"</td>";	
		save+="</tr>";		
	}
	save+="</table>";
	var prevPage=result.paging.page-1;
	var nextPage=result.paging.page+1;
	$("#BoardList").html(save);
	if(result.paging.page<=1){
		pageSave+="[이전]&nbsp;";
	}
	if(result.paging.page>1){
		pageSave+="<a href='javascript:getBoardList("+prevPage+")'>[이전]</a>&nbsp;";
	}
	for(var i=result.paging.startPage;i<=result.paging.endPage;i++){
		if(i == result.paging.page){
			pageSave+="<a href='javascript:getBoardList("+i+")'>"+i+"</a>&nbsp;";					
		}else{
			pageSave+="<a href='javascript:getBoardList("+i+")'>"+i+"</a>&nbsp;";										
		}
	}
	if(result.paging.page>=result.paging.maxPage){
		pageSave+="[다음]";			
	}
	if(result.paging.page<result.paging.maxPage){
		pageSave+="<a href='javascript:getBoardList("+nextPage+")'>[다음]</a>&nbsp;";			
	}
	$("#pageOrder").html(pageSave);
	},error:function(){
		
	}
});	
	
}

</script>
</head>
<body>
<div id="BoardList"></div>
<div id="pageOrder"></div>
<div>
	<select  id="search" >
						<option value="작성자">작성자</option>
						<option value="내용">내용</option>
				</select>
				<input type="text" id="selects">
				<button onclick="ListSearch()">검색</button>
</div>

</body>
</html>