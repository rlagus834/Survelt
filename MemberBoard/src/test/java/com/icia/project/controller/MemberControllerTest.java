package com.icia.project.controller;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;

import lombok.extern.slf4j.Slf4j;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"file:src/main/webapp/WEB-INF/spring/**/*.xml"})
@Slf4j
@WebAppConfiguration
public class MemberControllerTest {
@Autowired
private WebApplicationContext wac;
	


	@Test
	public void test() {
		fail("Not yet implemented");
	}

	
	//MockMvc는 서블릿과 동일하게 동작함
	private MockMvc mock;
	
	//mock 객체를 만들어 주기위해
	
	@Before
	public void setup() {
		System.out.println("setup 메소드 호출");
		this.mock=
				MockMvcBuilders.webAppContextSetup(wac).build();
	}
	
	@Test
	@Transactional
	@Rollback(true)
	public void memberJoinTest() throws Exception{
		System.out.println("로그인 테스트");
		log.info(mock.perform(MockMvcRequestBuilders.post("/LoginCheck")
		.param("id","rlagus834")
		.param("password","Zxcv5797@")
		
		)
				.andReturn().getModelAndView().getViewName());
System.out.println("dh");
	}
	
	
	
	
}
