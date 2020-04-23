package com.jade.swp;

import javax.annotation.PostConstruct;
import java.util.*;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.stereotype.Repository;

@Repository
public class ChatRoomRepository {
    private Map<String, ChatRoom> chatRoomMap;
    @PostConstruct
    private void init() {
        chatRoomMap = new LinkedHashMap<>();
    }
    public List<ChatRoom> findAllRoom() {
        // 채팅방 생성순서 최근 순으로 반환
        List chatRooms = new ArrayList<>(chatRoomMap.values());
        Collections.reverse(chatRooms);
        return chatRooms;
    }
    public ChatRoom findRoomById(String id) {
        return chatRoomMap.get(id);
    }
    public ChatRoom createChatRoom(String name) {
        ChatRoom chatRoom = ChatRoom.create(name);
        chatRoomMap.put(chatRoom.getRoomId(), chatRoom);
        
    	ConfigurableApplicationContext ctx = new AnnotationConfigApplicationContext(SpringRedisConfig.class);
    	ChannelTopic topic = (ChannelTopic)ctx.getBean("topic");//구독 값			
		
        return chatRoom;
    }
}