package com.project.vo;

import org.springframework.web.multipart.MultipartFile;

public class SermonVO {

	private String sermonSubject;
	private String sermonTitle;
	private String sermonMain;
	private String sermonPage;
	private String sermonPoint;
	private String sermonFile;
	private String sermonDate;
	private String sermonCnt;

	public SermonVO() {

	}

	/**
	 * insert 전용 생성자
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
			String sermonFile, String sermonDate) {
		this.sermonSubject = sermonSubject;
		this.sermonTitle = sermonTitle;
		this.sermonMain = sermonMain;
		this.sermonPage = sermonPage;
		this.sermonPoint = sermonPoint;
		this.sermonFile = sermonFile;
		this.sermonDate = sermonDate;
	}

	/**
	 * update 전용 생성자
	 * 
	 * @param sermonSubject
	 * @param sermonTitle
	 * @param sermonMain
	 * @param sermonPage
	 * @param sermonPoint
	 * @param sermonFile
	 * @param sermonDate
	 * @param sermonCnt
	 */
	public SermonVO(String sermonSubject, String sermonTitle, String sermonMain, String sermonPage, String sermonPoint,
			String sermonFile, String sermonDate, String sermonCnt) {
		this.sermonSubject = sermonSubject;
		this.sermonTitle = sermonTitle;
		this.sermonMain = sermonMain;
		this.sermonPage = sermonPage;
		this.sermonPoint = sermonPoint;
		this.sermonFile = sermonFile;
		this.sermonDate = sermonDate;
		this.sermonCnt = sermonCnt;
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
}