package com.jj.base.common.dto;


import java.util.Collections;
import java.util.List;

import com.jj.base.common.constans.IEnum;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class ListResultDto<T> extends AbstractResultDto {

	private static final long serialVersionUID = 6380935104572494082L;
	private List<T> data = Collections.emptyList();

	public ListResultDto() {
		super();
		this.data = Collections.emptyList();
	}

	public ListResultDto(IEnum ienum) {
		this.code = ienum.code();
		this.message = ienum.message();
	}

	public ListResultDto(IEnum ienum, List<T> data) {
		this.code = ienum.code();
		this.message = ienum.message();
		this.data = data;
	}

	private ListResultDto(String code, String message) {
		this.code = code;
		this.message = message;
	}

	public ListResultDto(List<T> data) {
		super();
		this.data = data;
	}

	public static <T> ListResultDto<T> error(String code, String message) {
		return new ListResultDto<>(code, message);
	}

	public static <T> ListResultDto<T> error(IEnum ienum) {
		return new ListResultDto<>(ienum);
	}

	public static <T> ListResultDto<T> success(List<T> data) {
		return new ListResultDto<>(data);
	}

}
