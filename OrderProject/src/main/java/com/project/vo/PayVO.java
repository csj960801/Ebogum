package com.project.vo;

public class PayVO {

	// 회원아이디
    private String member;
	
	// 정회원
	private String RegularUser;

	// 부회원
	private String unRegularUser;

	// 결제 방식
	private String paySelector;

	// 무통장입금
	private String saveUnpay;

	public PayVO() {
	}

	public String getRegularUser() {
		return RegularUser;
	}

	public void setRegularUser(String regularUser) {
		RegularUser = regularUser;
	}

	public String getUnRegularUser() {
		return unRegularUser;
	}

	public void setUnRegularUser(String unRegularUser) {
		this.unRegularUser = unRegularUser;
	}

	public String getPaySelector() {
		return paySelector;
	}

	public void setPaySelector(String paySelector) {
		this.paySelector = paySelector;
	}

	public String getSaveUnpay() {
		return saveUnpay;
	}

	public void setSaveUnpay(String saveUnpay) {
		this.saveUnpay = saveUnpay;
	}

	public String getMember() {
		return member;
	}

	public void setMember(String member) {
		this.member = member;
	}
}
