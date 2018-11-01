package VO;

public class Board {
	private int boardNum;
	private String userId;
	private String title;
	private String content;
	private int hitcount;
	private String regdate;
	private String originalFile;
	private String savedFile;
	
	public Board() {
	}

	public Board(int boardNum, String userId, String title, String content, int hitcount, String regdate,
			String originalFile, String savedFile) {
		super();
		this.boardNum = boardNum;
		this.userId = userId;
		this.title = title;
		this.content = content;
		this.hitcount = hitcount;
		this.regdate = regdate;
		this.originalFile = originalFile;
		this.savedFile = savedFile;
	}

	public int getBoardNum() {
		return boardNum;
	}

	public void setBoardNum(int boardNum) {
		this.boardNum = boardNum;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getHitcount() {
		return hitcount;
	}

	public void setHitcount(int hitcount) {
		this.hitcount = hitcount;
	}

	public String getRegdate() {
		return regdate;
	}

	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}

	public String getOriginalFile() {
		return originalFile;
	}

	public void setOriginalFile(String originalFile) {
		this.originalFile = originalFile;
	}

	public String getSavedFile() {
		return savedFile;
	}

	public void setSavedFile(String savedFile) {
		this.savedFile = savedFile;
	}

	@Override
	public String toString() {
		return "Board [boardNum=" + boardNum + ", userId=" + userId + ", title=" + title + ", content=" + content
				+ ", hitcount=" + hitcount + ", regdate=" + regdate + ", originalFile=" + originalFile + ", savedFile="
				+ savedFile + "]";
	}
	
	
}
