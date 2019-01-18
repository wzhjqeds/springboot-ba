package com.jj.base.common.constans;



public enum CommonEnum implements IEnum {

	SUCCESS("SUCCESS", "请求成功"), ERROR("E001", "系统异常,请重试");
	private CommonEnum(String code, String message) {
		this.code = code;
		this.message = message;
	}

	private String code;

	private String message;

	@Override
	public String code() {
		return this.code;
	}

	@Override
	public String message() {
		return this.message;
	}

}