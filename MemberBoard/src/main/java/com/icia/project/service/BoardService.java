package com.icia.project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.icia.project.dao.BoardDAO;
import java.util.*;
@Service
public class BoardService {

	@Autowired
BoardDAO dao;
	
	public Map<String,Object> BoardList(int page){
		
		dao.BoardList(page);		
	}
	
	
	
	
	
	
	
	
}
