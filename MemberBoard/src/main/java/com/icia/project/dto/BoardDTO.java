package com.icia.project.dto;

import org.springframework.web.multipart.MultipartFile;

public class BoardDTO {
private int bnum;
private String id;
private String title;
private String text;
private String files;
private String filesRealName;
private int mkey;
private int fnum;

public int getFnum() {
	return fnum;
}
public void setFnum(int fnum) {
	this.fnum = fnum;
}
public int getMkey() {
	return mkey;
}
public void setMkey(int mkey) {
	this.mkey = mkey;
}
public String getFilesRealName() {
	return filesRealName;
}
public void setFilesRealName(String filesRealName) {
	this.filesRealName = filesRealName;
}
private MultipartFile bfile;  //파일 업로드용
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
public String getTitle() {
	return title;
}
public void setTitle(String title) {
	this.title = title;
}
public String getText() {
	return text;
}
public void setText(String text) {
	this.text = text;
}
public String getFiles() {
	return files;
}
public void setFiles(String files) {
	this.files = files;
}
public MultipartFile getBfile() {
	return bfile;
}
public void setBfile(MultipartFile bfile) {
	this.bfile = bfile;
}
@Override
public String toString() {
	return "BoardDTO [bnum=" + bnum + ", id=" + id + ", title=" + title + ", text=" + text + ", files=" + files + "]";
}




	
	
	
	
	
}
