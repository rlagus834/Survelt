<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>



<script>

var ws= new WebSocket("ws://localhost:8080/replyEcho?bno=1234");

ws.onopen = function() {
console.log('접속완료');

socket.onmessage = function(event) {
	  alert(`[message] Data received from server: ${event.data}`);
	};

};


socket.onclose = function(event) {
    alert(`[close] Connection closed cleanly, code=${event.code} reason=${event.reason}`);
 
};

socket.onerror = function(error) {
  alert(`[error] ${error.message}`);
};
</script>
</body>

</html>