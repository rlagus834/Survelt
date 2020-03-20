package com.icia.project.dto;


public class BoardDTO {
private int bnum;
private String id;
private String title;
private String text;
private String files;
private String filesRealName;
private int mkey;
private int fnum;
private int counts;

public int getCounts() {
	return counts;
}
public void setCounts(int counts) {
	this.counts = counts;
}
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
 //파일 업로드용
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
@Override
public String toString() {
	return "BoardDTO [bnum=" + bnum + ", id=" + id + ", title=" + title + ", text=" + text + ", files=" + files
			+ ", filesRealName=" + filesRealName + ", mkey=" + mkey + ", fnum=" + fnum + ", counts=" + counts + "]";
}




	
	
	
	
	
}
