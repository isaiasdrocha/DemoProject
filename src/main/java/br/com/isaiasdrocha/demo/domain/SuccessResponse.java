package br.com.isaiasdrocha.demo.domain;

import io.swagger.annotations.ApiModelProperty;

public class SuccessResponse {

	@ApiModelProperty(value = "first param", name = "param", dataType = "String", example = "xyz")
	private String param;

	public SuccessResponse() {}
	public SuccessResponse(String param) {
		this.param = param;
	}
	
	public String getParam() {
		return param;
	}

	public void setParam(String param) {
		this.param = param;
	}
	
}