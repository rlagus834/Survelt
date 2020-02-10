package dto;

public class BoardDTO {
private int boardnumber;
private String boardtitle;
private String id;
private String text;
private String dateofissue;
private String password;
private int count;

public BoardDTO() {
	
}


public BoardDTO(int boardNumber, String boardTitle, String id, String text, String dateOfIssue, String password,
		int count) {
	super();
	this.boardnumber = boardnumber;
	this.boardtitle = boardtitle;
	this.id = id;
	this.text = text;
	this.dateofissue = dateofissue;
	this.password = password;
	this.count = count;
}


public int getBoardnumber() {
	return boardnumber;
}


public void setBoardnumber(int boardnumber) {
	this.boardnumber = boardnumber;
}


public String getBoardtitle() {
	return boardtitle;
}


public void setBoardtitle(String boardtitle) {
	this.boardtitle = boardtitle;
}


public String getId() {
	return id;
}


public void setId(String id) {
	this.id = id;
}


public String getText() {
	return text;
}


public void setText(String text) {
	this.text = text;
}


public String getDateofissue() {
	return dateofissue;
}


public void setDateofissue(String dateofissue) {
	this.dateofissue = dateofissue;
}


public String getPassword() {
	return password;
}


public void setPassword(String password) {
	this.password = password;
}


public int getCount() {
	return count;
}


public void setCount(int count) {
	this.count = count;
}



	
	
	
	
	
}
