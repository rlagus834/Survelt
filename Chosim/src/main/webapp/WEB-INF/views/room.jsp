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
    <div class="container" id="app" v-cloak>
        <div class="row">
            <div class="col-md-12">
                <h3>채팅방 리스트</h3>
            </div>
        </div>
        <div class="input-group">
            <div class="input-group-prepend">
                <label class="input-group-text">방제목</label>
            </div>
            <input type="text" class="form-control" v-model="room_name" v-on:keyup.enter="createRoom">
            <div class="input-group-append">
                <button class="btn btn-primary" type="button" @click="createRoom">채팅방 개설</button>
            </div>
        </div>
        <ul class="list-group">
            <li class="list-group-item list-group-item-action" v-for="item in chatrooms" v-bind:key="item.roomId" v-on:click="enterRoom(item.roomId)">
                {{item.name}}
            </li>
        </ul>
    </div>
    <!-- JavaScript -->
    <script src="https://cdn.jsdelivr.net/npm/vue/dist/vue.js"></script>
<script src="https://unpkg.com/axios/dist/axios.min.js"></script>
 <script src="https://cdnjs.cloudflare.com/ajax/libs/sockjs-client/1.4.0/sockjs.js"></script>
 
    <script>
    if('${sessionScope.id}'!='admin'){
        var vm = new Vue({
            el: '#app',
            data: {
                room_name : '',
                chatrooms: [
                ]
            },
            created() {
                this.createRoom();
                this.enterRoom('${sessionScope.id}');
            },
            methods: {
                findAllRoom: function() {
                    axios.get('http://localhost:8090/swp/chat/rooms').then(response => { this.chatrooms = response.data; });
                },
                createRoom: function() {
                  
                        var params = new URLSearchParams();
                        params.append("name",'${sessionScope.id}');
                        axios.post('http://localhost:8090/swp/chat/room', params)
                        .then(
                            response => {
                                this.room_name = '';
                            }
                        )
                        .catch( response => { alert("채팅방 개설에 실패하였습니다."); } );
                  
                },
                enterRoom: function(roomId) {                    
                        localStorage.setItem('wschat.sender',roomId);
                        localStorage.setItem('wschat.roomId',roomId);
                        location.href="room/enter/"+roomId;
                }
            }
        });
        
    }else{
    	var vm = new Vue({
            el: '#app',
            data: {
                room_name : '',
                chatrooms: [
                ]
            },
            created() {
                this.findAllRoom();
            },
            methods: {
                findAllRoom: function() {
                    axios.get('http://localhost:8090/swp/chat/rooms').then(response => { this.chatrooms = response.data; });
                },
                createRoom: function() {
                    if("" === this.room_name) {
                        return;
                    } else {
                        var params = new URLSearchParams();
                        params.append("name",this.room_name);
                        axios.post('http://localhost:8090/swp/chat/room', params)
                        .then(
                            response => {
                                this.room_name = '';
                                this.findAllRoom();
                            }
                        )
                        .catch( response => { alert("채팅방 개설에 실패하였습니다."); } );
                    }
                },
                enterRoom: function(roomId) {
                        localStorage.setItem('wschat.sender','${sessionScope.id}');
                        localStorage.setItem('wschat.roomId',roomId);
                        location.href="room/enter/"+roomId;
                }
            }
        });
    }
    </script>
</body>
</html>