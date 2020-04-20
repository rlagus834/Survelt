package com.jade.swp;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.*;
import lombok.RequiredArgsConstructor;

//import 생략...

@RequiredArgsConstructor
@Controller
@RequestMapping("/chat")
public class ChatRoomController {

 private final com.jade.swp.ChatRoomRepository chatRoomRepository;

 // 채팅 리스트 화면
 @GetMapping("/room")
 public String rooms(Model model) {
     return "room";
 }
 // 모든 채팅방 목록 반환
 @GetMapping("/rooms")
 @ResponseBody
 public List<ChatRoom> room() {
     return chatRoomRepository.findAllRoom();
 }
 // 채팅방 생성
 @PostMapping("/room")
 @ResponseBody
 public ChatRoom createRoom(@RequestParam String name) {
     return chatRoomRepository.createChatRoom(name);
 }
 // 채팅방 입장 화면
 @GetMapping("/room/enter/{roomId}")
 public String roomDetail(Model model, @PathVariable String roomId) {
     model.addAttribute("roomId", roomId);
     return "roomdetail";
 }
 // 특정 채팅방 조회
 @GetMapping("/room/{roomId}")
 @ResponseBody
 public ChatRoom roomInfo(@PathVariable String roomId) {
     return chatRoomRepository.findRoomById(roomId);
 }
}
