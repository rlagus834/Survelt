package com.icia.board.dto;

import lombok.Data;

@Data
public class PageDTO {

	private int startRow;
	private int endRow;
	private int page;
	private int startPage;

	private int listCount;
	private int endPage;
	private int maxPage;
	
	
	
}
