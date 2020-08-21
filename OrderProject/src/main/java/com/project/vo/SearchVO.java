package com.project.vo;

/**
 * 검색기능에 사용되는 vo
 * 
 * @author seven
 *
 */
public class SearchVO {

	private String board_title_kind;
	private String boardSearchParam;

	public SearchVO() {

	}

	public SearchVO(String boardSearchParam) {
      this.boardSearchParam = boardSearchParam;
	}

	public String getBoard_title_kind() {
		return board_title_kind;
	}

	public void setBoard_title_kind(String board_title_kind) {
		this.board_title_kind = board_title_kind;
	}

	public String getBoardSearchParam() {
		return boardSearchParam;
	}

	public void setBoardSearchParam(String boardSearchParam) {
		this.boardSearchParam = boardSearchParam;
	}

}