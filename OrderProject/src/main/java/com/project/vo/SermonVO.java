package com.project.vo;

public class SermonVO {

	private String sermonSubject;
	private String sermonTitle;
	private String sermonMain;
	private String sermonPage;

	// 설교파일에 적용되어 있는 포인트
	private String sermonPoint;
	private String sermonFile;
	private String sermonDate;
	private String sermonCnt;

	// 신약/구약
	private String sermonBibleType;

	// 절기설교 타입
	private String sermonBoardType;
	
	public SermonVO() {

	}

	/**
	 * 설교 insert 전용 생성자
	 * 
	 * @param sermonSubject
	 * @param sermonTitle
	 * @param sermonMain
	 * @param sermonPage
	 * @param sermonPoint
	 * @param sermonFile
	 * @param sermonDate
	 */
	public SermonVO(String sermonSubject, String sermonTitle, String sermonMain, String sermonPage, String sermonPoint,
			String sermonFile, String sermonDate, String sermonBibleType) {
		this.sermonSubject = sermonSubject;
		this.sermonTitle = sermonTitle;
		this.sermonMain = sermonMain;
		this.sermonPage = sermonPage;
		this.sermonPoint = sermonPoint;
		this.sermonFile = sermonFile;
		this.sermonDate = sermonDate;
		this.sermonBibleType = sermonBibleType;
	}

	/**
	 * 설교 update 전용 생성자
	 * 
	 * @param sermonSubject
	 * @param sermonTitle
	 * @param sermonMain
	 * @param sermonPage
	 * @param sermonPoint
	 * @param sermonFile
	 * @param sermonDate
	 * @param sermonCnt
	 * @param sermonBibleType
	 */
	public SermonVO(String sermonSubject, String sermonTitle, String sermonMain, String sermonPage, String sermonPoint,
			String sermonFile, String sermonDate, String sermonCnt, String sermonBibleType) {
		this.sermonSubject = sermonSubject;
		this.sermonTitle = sermonTitle;
		this.sermonMain = sermonMain;
		this.sermonPage = sermonPage;
		this.sermonPoint = sermonPoint;
		this.sermonFile = sermonFile;
		this.sermonDate = sermonDate;
		this.sermonCnt = sermonCnt;
		this.sermonBibleType = sermonBibleType;
	}

	/**
	 * 절기 설교 전용 생성자
	 * @param sermonSubject
	 * @param sermonTitle
	 * @param sermonMain
	 * @param sermonPage
	 * @param sermonPoint
	 * @param sermonFile
	 * @param sermonDate
	 * @param sermonCnt
	 * @param sermonBibleType
	 * @param sermonBoardType
	 */
	public SermonVO(String sermonSubject, String sermonTitle, String sermonMain, String sermonPage, String sermonPoint,
			String sermonFile, String sermonDate, String sermonCnt, String sermonBibleType, String sermonBoardType) {
		this.sermonSubject = sermonSubject;
		this.sermonTitle = sermonTitle;
		this.sermonMain = sermonMain;
		this.sermonPage = sermonPage;
		this.sermonPoint = sermonPoint;
		this.sermonFile = sermonFile;
		this.sermonDate = sermonDate;
		this.sermonCnt = sermonCnt;
		this.sermonBibleType = sermonBibleType;
		this.sermonBoardType = sermonBoardType;
	}
	
	public String getSermonSubject() {
		return sermonSubject;
	}

	public void setSermonSubject(String sermonSubject) {
		this.sermonSubject = sermonSubject;
	}

	public String getSermonTitle() {
		return sermonTitle;
	}

	public void setSermonTitle(String sermonTitle) {
		this.sermonTitle = sermonTitle;
	}

	public String getSermonMain() {
		return sermonMain;
	}

	public void setSermonMain(String sermonMain) {
		this.sermonMain = sermonMain;
	}

	public String getSermonPage() {
		return sermonPage;
	}

	public void setSermonPage(String sermonPage) {
		this.sermonPage = sermonPage;
	}

	public String getSermonPoint() {
		return sermonPoint;
	}

	public void setSermonPoint(String sermonPoint) {
		this.sermonPoint = sermonPoint;
	}

	public String getSermonDate() {
		return sermonDate;
	}

	public void setSermonDate(String sermonDate) {
		this.sermonDate = sermonDate;
	}

	public String getSermonCnt() {
		return sermonCnt;
	}

	public void setSermonCnt(String sermonCnt) {
		this.sermonCnt = sermonCnt;
	}

	public String getSermonFile() {
		return sermonFile;
	}

	public void setSermonFile(String sermonFile) {
		this.sermonFile = sermonFile;
	}

	public String getSermonBibleType() {
		return sermonBibleType;
	}

	public void setSermonBibleType(String sermonBibleType) {
		this.sermonBibleType = sermonBibleType;
	}

	public String getSermonBoardType() {
		return sermonBoardType;
	}

	public void setSermonBoardType(String sermonBoardType) {
		this.sermonBoardType = sermonBoardType;
	}

}