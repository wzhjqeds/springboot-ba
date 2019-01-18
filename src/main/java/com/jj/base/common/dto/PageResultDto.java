package com.jj.base.common.dto;


import com.jj.base.common.constans.IEnum;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class PageResultDto<T> extends AbstractResultDto {

	private static final long serialVersionUID = 1712154328279091638L;
	private PageDto<T> data;

	public PageResultDto() {
		super();
	}

	public PageResultDto(IEnum ienum) {
		super();
		this.code = ienum.code();
		this.message = ienum.message();
	}

	public PageResultDto(IEnum ienum, PageDto<T> data) {
		this.code = ienum.code();
		this.message = ienum.message();
		this.data = data;
	}

	private PageResultDto(String code, String message) {
		super();
		this.code = code;
		this.message = message;
	}

	public PageResultDto(PageDto<T> data) {
		super();
		this.data = data;
	}

	public static <T> PageResultDto<T> error(String code, String message) {
		return new PageResultDto<>(code, message);
	}

	public static <T> PageResultDto<T> error(IEnum ienum) {
		return new PageResultDto<>(ienum);
	}

	public static <T> PageResultDto<T> success(PageDto<T> data) {
		return new PageResultDto<>(data);
	}

}
