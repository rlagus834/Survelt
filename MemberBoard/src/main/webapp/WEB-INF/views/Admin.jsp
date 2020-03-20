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

function selects(){
	var res=document.getElementById("selects").value;
	var selects=document.getElementById("result");
	var save="";
console.log(res);
	$.ajax({
		
		type:"GET",
		url:"selectMember",
	
		data:"id="+res,
	dataType:"json",
	success:function(result){
		console.log(result[0].id);
		if(result==null){
		alert('검색결과가없습니다');	
		}else{			
		save+="<table border='1px'>";
		for(var i=0; i<result.length; i++){
		save+="<tr>";
		save+="<td>"+result[i].id+"</td>";
		save+="<td>"+result[i].name+"</td>";
		save+="<td>"+result[i].birth+"</td>";
		save+="<td>"+result[i].address+"</td>";
		save+="<td>"+result[i].phone+"</td>";
		save+="<td><a onclick='MemberDelete(\""+result[i].id+"\")'>삭제</a></td>";
		save+="</tr>";
		}		
		save+="</table>";
		$("#result").html(save);
		}
	},error:function(){
		
	}
	});
	
}

function MemberDelete(member){
	$.ajax({
		type:"get",
		url:"MemberDelete",
		data:"id="+member,
		dataType:"text",
		success:function(result){
			alert('삭제성공');
			selects();
		},error:function(){
			
		}
		
	});
	
}
</script>
</head>
<body>
<div>
아이디 조회:<input type="text" id="selects">
<button onclick="selects()">search</button>
</div>
<div id="result">

</div>



</body>
</html>