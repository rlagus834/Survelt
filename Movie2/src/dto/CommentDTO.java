package dto;

public class CommentDTO {

	private int bnum;
	private String mname;
	private String id;
	private String text;
	private int score;
	private String cdate;
	private int mnum;
	private String colunm;
	private String gchance;
	private String mchance;
	private int gcnum;
	private int mcnum;
	private String search;
	private String filter;
	private int endrow;
	private int startrow;

	public int getGcnum() {
		return gcnum;
	}

	public String getSearch() {
		return search;
	}

	public void setSearch(String search) {
		this.search = search;
	}

	public String getFilter() {
		return filter;
	}

	public void setFilter(String filter) {
		this.filter = filter;
	}

	public int getEndrow() {
		return endrow;
	}

	public void setEndrow(int endrow) {
		this.endrow = endrow;
	}

	public int getStartrow() {
		return startrow;
	}

	public void setStartrow(int startrow) {
		this.startrow = startrow;
	}

	public void setGcnum(int gcnum) {
		this.gcnum = gcnum;
	}

	public int getMcnum() {
		return mcnum;
	}

	public void setMcnum(int mcnum) {
		this.mcnum = mcnum;
	}

	public String getGchance() {
		return gchance;
	}

	public void setGchance(String gchance) {
		this.gchance = gchance;
	}

	public String getMchance() {
		return mchance;
	}

	public void setMchance(String mchance) {
		this.mchance = mchance;
	}

	
	
	public String getColunm() {
		return colunm;
	}

	public void setColunm(String colunm) {
		this.colunm = colunm;
	}

	public int getBnum() {
		return bnum;
	}

	public void setBnum(int bnum) {
		this.bnum = bnum;
	}

	public String getMname() {
		return mname;
	}

	public void setMname(String mname) {
		this.mname = mname;
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

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public String getCdate() {
		return cdate;
	}

	public void setCdate(String cdate) {
		this.cdate = cdate;
	}

	public int getMnum() {
		return mnum;
	}

	public void setMnum(int mnum) {
		this.mnum = mnum;
	}

}
