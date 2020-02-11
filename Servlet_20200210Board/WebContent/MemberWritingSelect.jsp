<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
             <%@ taglib prefix="c" 
uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
    <script>
    function write(){
    
location.href="write.jsp";   	
    }
    function writes(){
        
    	location.href="write.jsp";   	
    	    }
    	     
function selectUpdate(){
	
	location.href="UpdateSelect";   	
	
}
    </script>
    <style>
        div{
float: left;
        }
        td{
width:150px;
height:100px;
border:1px solid black;
}

#table{
    background-color: aqua;
height: 300px;    
}
#button{
    background-color: aqua;

    height: 300px;    

}
#writeButton{
    background-color: aqua;
    
}

    </style>

</head>
<body >

<br>
<div id="table" >
    <table>
  
  <caption><h1>게시글목록</h1></caption>      
<tr>
<th>글번호</th><th>제목</th><th><a href="UpdateSelectAsc">조회수</a></th>
<th>작성자</th><th>작성일</th>
</tr>
<c:forEach var="member" items="${select}">

<tr>
<td>${member.boardnumber}</td>
<td>${member.boardtitle}</td>
<td>${member.count}</td>
<td><a href="MemberWritingSelect?resultParam=${member.id}">${member.id}</a></td>
<td>${member.dateofissue}</td>
<td><a href="writeOpen?resultParam=${member.id}">작성글보기</a></td>
</tr>
</c:forEach>
</table>
</div>
<a href="">작성하기</button>
<button onclick="selectUpdate()">업데이트</button>

</body>
</html>