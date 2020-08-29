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
	
	//관리자
	private String adminSearchId;
	private String adminSearchName;
	private String adminSearchAddress;
	
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

	/**
	 * 관리자 기능
	 * @return
	 */
	public String getAdminSearchId() {
		return adminSearchId;
	}

	public void setAdminSearchId(String adminSearchId) {
		this.adminSearchId = adminSearchId;
	}

	public String getAdminSearchName() {
		return adminSearchName;
	}

	public void setAdminSearchName(String adminSearchName) {
		this.adminSearchName = adminSearchName;
	}

	public String getAdminSearchAddress() {
		return adminSearchAddress;
	}

	public void setAdminSearchAddress(String adminSearchAddress) {
		this.adminSearchAddress = adminSearchAddress;
	}

}