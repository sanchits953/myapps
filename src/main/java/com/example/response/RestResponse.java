package com.example.response;

import java.io.Serializable;

import org.springframework.stereotype.Component;

@Component
public class RestResponse implements Serializable {

	private static final long serialVersionUID = 1L;

	private int httpStatus;
	private String statusCode;
	private String message;
	private String developer_message;
	

	public RestResponse build(int httpStatus, String statusCode, String message,String developer_message) {
		this.httpStatus = httpStatus;
		this.statusCode = statusCode;
		this.message = message;
		this.setDeveloper_message(developer_message);
		return this;
	}
	public int getHttpStatus() {
		return httpStatus;
	}


	public void setHttpStatus(int httpStatus) {
		this.httpStatus = httpStatus;
	}


	public String getStatusCode() {
		return statusCode;
	}


	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}


	public String getMessage() {
		return message;
	}


	public void setMessage(String message) {
		this.message = message;
	}
	public String getDeveloper_message() {
		return developer_message;
	}
	public void setDeveloper_message(String developer_message) {
		this.developer_message = developer_message;
	}


}

