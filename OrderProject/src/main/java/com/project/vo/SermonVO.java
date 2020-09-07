package com.project.vo;

import org.springframework.web.multipart.MultipartFile;

public class SermonVO {

	private String sermonSubject;
	private String sermonTitle;
	private String sermonMain;
	private String sermonPage;
	private String sermonPoint;
	private MultipartFile sermonFile;
    private String sermonDate;
    private String sermonCnt;
    
	public SermonVO() {

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

	public MultipartFile getSermonFile() {
		return sermonFile;
	}

	public void setSermonFile(MultipartFile sermonFile) {
		this.sermonFile = sermonFile;
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
}