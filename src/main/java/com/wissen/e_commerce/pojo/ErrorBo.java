package com.wissen.e_commerce.pojo;

public class ErrorBo {
	
	private String errorCode;
	private String errorMessage;
	private String action;
	public String getAction() {
		return action;
	}
	public void setAction(String action) {
		this.action = action;
	}
	public String getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	@Override
	public String toString() {
		return "ErrorBo [errorCode=" + errorCode + ", errorMessage=" + errorMessage + ", action=" + action + "]";
	}

}
