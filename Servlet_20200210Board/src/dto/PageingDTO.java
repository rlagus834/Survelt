package dto;

public class PageingDTO {
private int page;  // 현재페이지
private int maxPage;  //  15개가 있는데 페이지당 4개씩보여준다하면 페이지이동번호가 4개인데 그계산값을 저장하는필드   
private int startPage;	// 7페이지를 본다 가정하면 1-10까지의 클릭할  페이지이동번호를 보여주어야하는데 그중1의 값을 가지는 저장 필드 endPage는 10
private int endPage; //  
private int listCount;  //전체글갯수
public int getPage() {
	return page;
}
public void setPage(int page) {
	this.page = page;
}
public int getMaxPage() {
	return maxPage;
}
public void setMaxPage(int maxPage) {
	this.maxPage = maxPage;
}
public int getStartPage() {
	return startPage;
}
public void setStartPage(int startPage) {
	this.startPage = startPage;
}
public int getEndPage() {
	return endPage;
}
public void setEndPage(int endPage) {
	this.endPage = endPage;
}
public int getListCount() {
	return listCount;
}
public void setListCount(int listCount) {
	this.listCount = listCount;
}
public PageingDTO(int page, int maxPage, int startPage, int endPage, int listCount) {
	super();
	this.page = page;
	this.maxPage = maxPage;
	this.startPage = startPage;
	this.endPage = endPage;
	this.listCount = listCount;
}

public PageingDTO() {

}

	
	
	
	
	
}
