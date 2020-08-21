package com.project.vo;

public class BoardVO {
	private int bno; // 게시글 번호
	private String boardWriter;
	private String boardEmail;
	private String boardTitle;
	private String boardContent;
	private String boardPassword;
	private int boardHit;
	private int boardParam;// 게시글 답변 전용 파라미터

	public BoardVO() {

	}

	public BoardVO(int bno, String boardWriter, String boardEmail, String boardTitle, String boardContent,
			String boardPassword, int boardHit, int boardParam) {
		this.bno = bno;
		this.boardWriter = boardWriter;
		this.boardEmail = boardEmail;
		this.boardTitle = boardTitle;
		this.boardContent = boardContent;
		this.boardPassword = boardPassword;
		this.boardHit = boardHit;
		this.boardParam = boardParam;
	}

	public String getBoardWriter() {
		return boardWriter;
	}

	public void setBoardWriter(String boardWriter) {
		this.boardWriter = boardWriter;
	}

	public String getBoardEmail() {
		return boardEmail;
	}

	public void setBoardEmail(String boardEmail) {
		this.boardEmail = boardEmail;
	}

	public String getBoardTitle() {
		return boardTitle;
	}

	public void setBoardTitle(String boardTitle) {
		this.boardTitle = boardTitle;
	}

	public String getBoardContent() {
		return boardContent;
	}

	public void setBoardContent(String boardContent) {
		this.boardContent = boardContent;
	}

	public String getBoardPassword() {
		return boardPassword;
	}

	public void setBoardPassword(String boardPassword) {
		this.boardPassword = boardPassword;
	}

	public int getBoardHit() {
		return boardHit;
	}

	public void setBoardHit(int boardHit) {
		this.boardHit = boardHit;
	}

	public int getBno() {
		return bno;
	}

	public void setBno(int bno) {
		this.bno = bno;
	}

	public int getBoardParam() {
		return boardParam;
	}

	public void setBoardParam(int boardParam) {
		this.boardParam = boardParam;
	}
}