package com.jj.base.common.dto;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.jj.base.common.constans.IEnum;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
@JsonInclude(value=Include.NON_NULL)
public class ResultDto<T> extends AbstractResultDto {

	private static final long serialVersionUID = 5392578668969843841L;
	private T data;

	public ResultDto() {
		super();
	}

	public ResultDto(IEnum ienum) {
		this.code = ienum.code();
		this.message = ienum.message();
	}

	public ResultDto(IEnum ienum, T data) {
		this.code = ienum.code();
		this.message = ienum.message();
		this.data = data;
	}

	private ResultDto(String code, String message) {
		super();
		this.code = code;
		this.message = message;
	}

	public ResultDto(T data) {
		super();
		this.data = data;
	}

	public static <T> ResultDto<T> error(String code, String message) {
		return new ResultDto<>(code, message);
	}

	public static <T> ResultDto<T> error(IEnum ienum) {
		return new ResultDto<>(ienum);
	}

	public static <T> ResultDto<T> success(T data) {
		return new ResultDto<>(data);
	}

}
