package com.SanketIT.Blog_App.excepation;

import java.time.LocalDate;

public class ExcepationMessage {
	
	private String errorCode;
	private String msg;
	private LocalDate localDate;
	public String getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public LocalDate getLocalDate() {
		return localDate;
	}
	public void setLocalDate(LocalDate localDate) {
		this.localDate = localDate;
	}
	

}
