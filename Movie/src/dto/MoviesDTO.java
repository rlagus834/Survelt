package dto;

public class MoviesDTO {
	private int boardnumber;
	private String boardtitle;
	private String text;
	private int price;
	private String photo;
	private String photo1;
	private String photo2;
	private String photo3;
	private String photo4;
	private String photo5;
	private String id;
	private int sympathy;
	
	public int getSympathy() {
		return sympathy;
	}

	public void setSympathy(int sympathy) {
		this.sympathy = sympathy;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPhoto1() {
		return photo1;
	}

	public void setPhoto1(String photo1) {
		this.photo1 = photo1;
	}

	public String getPhoto2() {
		return photo2;
	}

	public void setPhoto2(String photo2) {
		this.photo2 = photo2;
	}

	public String getPhoto3() {
		return photo3;
	}

	public void setPhoto3(String photo3) {
		this.photo3 = photo3;
	}

	public String getPhoto4() {
		return photo4;
	}

	public void setPhoto4(String photo4) {
		this.photo4 = photo4;
	}

	public String getPhoto5() {
		return photo5;
	}

	public void setPhoto5(String photo5) {
		this.photo5 = photo5;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	private String dateofissue;

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

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public String getbFile() {
		return bFile;
	}

	public void setbFile(String bFile) {
		this.bFile = bFile;
	}

	private int count;
	private String bFile; // 파일이름을 세팅하는용도

}
