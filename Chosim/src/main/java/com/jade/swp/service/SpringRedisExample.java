package com.jade.swp.service;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.stereotype.Service;

import com.jade.swp.RedisMessagePublisher;
import com.jade.swp.SpringRedisConfig;

@Service
public class SpringRedisExample {
	public void exam() {
		ConfigurableApplicationContext ctx = new AnnotationConfigApplicationContext(SpringRedisConfig.class);
		try {
			StringRedisTemplate redisTemplate = (StringRedisTemplate)ctx.getBean("strRedisTemplate");
			ChannelTopic topic = (ChannelTopic)ctx.getBean("topic");
			
			RedisMessagePublisher redisMessagePublisher
						= (RedisMessagePublisher)ctx.getBean("redisPublisher", redisTemplate, topic);
			String message = "안녕!!";
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
