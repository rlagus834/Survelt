<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
    <style>
      [v-cloak] {
          display: none;
      }
    </style>
</head>
<body>
${test}
  <div class="container" id="app" v-cloak>
        <div>
            <h2>{{room.name}}</h2>
        </div>
        <div class="input-group">
            <div class="input-group-prepend">
                <label class="input-group-text">내용</label>
            </div>
            <input type="text" class="form-control" v-model="message" v-on:keypress.enter="sendMessage">
            <div class="input-group-append">
                <button class="btn btn-primary" type="button" @click="sendMessage">보내기</button>
            </div>
        </div>
        <ul class="list-group">
            <li class="list-group-item" v-for="message in messages">
                {{message.sender}} - {{message.message}}</a>
            </li>
        </ul>
        <div></div>
    </div>
    <!-- JavaScript -->
    
  <script src="https://cdnjs.cloudflare.com/ajax/libs/stomp.js/2.3.3/stomp.min.js"></script>

  <script src="https://cdn.jsdelivr.net/npm/vue/dist/vue.js"></script>
<script src="https://unpkg.com/axios/dist/axios.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/sockjs-client/1.4.0/sockjs.js"></script>
    <script>
        //alert(document.title);
        // websocket & stomp initialize
        var sock = new SockJS("http://localhost:8090/swp/ws-stomp");
        var ws = Stomp.over(sock);
        var reconnect = 0;
        // vue.js
        var vm = new Vue({
            el: '#app',
            data: {
                roomId: '',
                room: {},
                sender: '',
                message: '',
                messages: []
            },
            created() {
                this.roomId = localStorage.getItem('wschat.roomId');
                this.sender = localStorage.getItem('wschat.sender');
                this.findRoom();
            },
            methods: {
                findRoom: function() {
                    axios.get('http://localhost:8090/swp/chat/room/'+this.roomId).then(response => { this.room = response.data; });
                },
                sendMessage: function() {
                    ws.send("/pub/chat/message", {}, JSON.stringify({type:'TALK', roomId:this.roomId, sender:this.sender, message:this.message}));
                    this.message = '';
                },
                recvMessage: function(recv) {
                    this.messages.unshift({"type":recv.type,"sender":recv.type=='ENTER'?'[알림]':recv.sender,"message":recv.message})
                }
            }
        });
        function connect() {
            // pub/sub event
            ws.connect({}, function(frame) {
                ws.subscribe("/sub/chat/room/"+vm.$data.roomId, function(message) {
                    var recv = JSON.parse(message.body);
                    vm.recvMessage(recv);
                });
                ws.send("/pub/chat/message", {}, JSON.stringify({type:'ENTER', roomId:vm.$data.roomId, sender:vm.$data.sender}));
            }, function(error) {
                if(reconnect++ <= 5) {
                    setTimeout(function() {
                        console.log("connection reconnect");
                        sock = new SockJS("http://localhost:8090/swp/ws-stomp");
                        ws = Stomp.over(sock);
                        connect();
                    },10*1000);
                }
            });
        }
        connect();
    </script>
</body>
</html>