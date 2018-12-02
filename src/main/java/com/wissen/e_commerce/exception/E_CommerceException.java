package com.wissen.e_commerce.exception;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import com.wissen.e_commerce.constants.E_CommerceError.Code;
import com.wissen.e_commerce.constants.E_CommerceError.Message;
import com.wissen.e_commerce.pojo.ErrorBo;

@Provider
public class E_CommerceException extends Exception implements ExceptionMapper<E_CommerceException> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2862344637448275076L;

	public E_CommerceException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public E_CommerceException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public E_CommerceException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public E_CommerceException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public E_CommerceException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	public E_CommerceException(String errorCode, String errorMessage) {
		super(errorMessage);
		this.errorCode = errorCode;
		this.errorMessage = errorMessage;
	}

	private String errorCode;
	private String errorMessage;
	private String action;

	public E_CommerceException(Code errorCode, Message errorMessage, String action) {
		super(errorMessage.name());
		this.errorCode = errorCode.getValue();
		this.errorMessage = errorMessage.getValue();
		this.action = action;
	}

	public E_CommerceException(Code errorCode, Message errorMessage, String action, Throwable throwable) {
		super(errorMessage.name(), throwable);
		this.errorCode = errorCode.getValue();
		this.errorMessage = errorMessage.getValue();
		this.action = action;
	}

	public E_CommerceException(Code errorCode, Message errorMessage, Throwable throwable) {
		super(errorMessage.name(), throwable);
		this.errorCode = errorCode.getValue();
		this.errorMessage = errorMessage.getValue();
	}

	public E_CommerceException(Code errorCode, Message errorMessage) {
		super(errorMessage.name());
		this.errorCode = errorCode.getValue();
		this.errorMessage = errorMessage.getValue();
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

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	@Override
	public Response toResponse(E_CommerceException exception) {
		ErrorBo error = new ErrorBo();
		error.setErrorCode(exception.getErrorCode());
		error.setErrorMessage(exception.getErrorMessage());
		error.setAction(exception.getAction());
		return Response.status(Integer.parseInt(exception.errorCode)).entity(error).build();
	}

}
