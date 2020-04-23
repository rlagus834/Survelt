package com.jade.swp.service;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.stereotype.Service;

import com.jade.swp.RedisMessagePublisher;
import com.jade.swp.SpringRedisConfig;
import java.util.*;
@Service
public class SpringRedisExample {
	public void exam() {
		ConfigurableApplicationContext ctx = new AnnotationConfigApplicationContext(SpringRedisConfig.class);
		try {
			StringRedisTemplate redisTemplate = (StringRedisTemplate)ctx.getBean("strRedisTemplate");//서버연결하는값
			ChannelTopic topic = (ChannelTopic)ctx.getBean("topic");//구독 값			
			RedisMessagePublisher redisMessagePublisher
						= (RedisMessagePublisher)ctx.getBean("redisPublisher", redisTemplate, topic);//redis에 메세지보내기위한 객체생성
			String message = "안녕!!";
			RedisTemplate<String, Object> redisTemplate1 = (RedisTemplate<String, Object>)ctx.getBean("redisTemplate");
			// value operation
			ValueOperations<String, Object> values = redisTemplate1.opsForValue();
List<String> list=new ArrayList<String>();
			list.add("야");
			list.add("야");
			list.add("야");
			list.add("야");			
			values.set("hyun",list.toString());

			
			
			redisMessagePublisher.publish(message);
	
		}	
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			ctx.close();
		}
		
	}
}
