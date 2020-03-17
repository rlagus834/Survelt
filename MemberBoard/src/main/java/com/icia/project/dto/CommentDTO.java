package com.icia.project.dto;

public class CommentDTO {
private int cnum;
private int bnum;
private String id;
private String text;
@Override
public String toString() {
	return "CommentDTO [cnum=" + cnum + ", bnum=" + bnum + ", id=" + id + ", text=" + text + "]";
}
public int getCnum() {
	return cnum;
}
public void setCnum(int cnum) {
	this.cnum = cnum;
}
public int getBnum() {
	return bnum;
}
public void setBnum(int bnum) {
	this.bnum = bnum;
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
	
	
	
	
	
}
