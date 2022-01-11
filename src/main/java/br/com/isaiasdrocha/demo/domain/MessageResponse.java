package br.com.isaiasdrocha.demo.domain;

import io.swagger.annotations.ApiModelProperty;

public class MessageResponse {

	@ApiModelProperty(name = "code", value = "Response code", dataType = "Integer", example = "1")
	private Integer code;
	
	@ApiModelProperty(name = "message", value = "Response message", dataType = "String", example = "The result is success")
	private String message;

	public MessageResponse() {}
	public MessageResponse(Integer code, String message) {
		this.code = code; 
		this.message = message;
	}
	
	
	public Integer getCode() {
		return code;
	}
	public void setCode(Integer code) {
		this.code = code;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
}