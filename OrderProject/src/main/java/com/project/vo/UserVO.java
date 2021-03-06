package com.project.vo;

public class UserVO {

	private String duplicateid; // 회원 아이디
	private String pass1; // 비번
	private String pass2;
	private String name; // 회원이름
	private String birth;
	private String manType;
	private String postAddress;
	private String address;
	private String churchName;
	private String email;
	private String homeTel;
	private String churchTel;
	private String phoneTel;
	private String faxNumber;
	private String date; // 가입일
	private String point; // 회원 포인트

	public UserVO() {
	}

	public UserVO(String duplicateid, String pass1) {
		this.duplicateid = duplicateid;
		this.pass1 = pass1;
	}

	public String getDuplicateid() {
		return duplicateid;
	}

	public void setDuplicateid(String duplicateid) {
		this.duplicateid = duplicateid;
	}

	public String getPass1() {
		return pass1;
	}

	public void setPass1(String pass1) {
		this.pass1 = pass1;
	}

	public String getPass2() {
		return pass2;
	}

	public void setPass2(String pass2) {
		this.pass2 = pass2;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBirth() {
		return birth;
	}

	public void setBirth(String birth) {
		this.birth = birth;
	}

	public String getManType() {
		return manType;
	}

	public void setManType(String manType) {
		this.manType = manType;
	}

	public String getPostAddress() {
		return postAddress;
	}

	public void setPostAddress(String postAddress) {
		this.postAddress = postAddress;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getChurchName() {
		return churchName;
	}

	public void setChurchName(String churchName) {
		this.churchName = churchName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getHomeTel() {
		return homeTel;
	}

	public void setHomeTel(String homeTel) {
		this.homeTel = homeTel;
	}

	public String getChurchTel() {
		return churchTel;
	}

	public void setChurchTel(String churchTel) {
		this.churchTel = churchTel;
	}

	public String getPhoneTel() {
		return phoneTel;
	}

	public void setPhoneTel(String phoneTel) {
		this.phoneTel = phoneTel;
	}

	public String getFaxNumber() {
		return faxNumber;
	}

	public void setFaxNumber(String faxNumber) {
		this.faxNumber = faxNumber;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getPoint() {
		return point;
	}

	public void setPoint(String point) {
		this.point = point;
	}

}