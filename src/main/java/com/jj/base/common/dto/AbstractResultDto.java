package com.jj.base.common.dto;


import java.io.Serializable;
import com.jj.base.common.constans.CommonEnum;
import lombok.Data;

@Data
public abstract class AbstractResultDto implements Serializable {

	private static final long serialVersionUID = 9164167410172753325L;

	protected String code;

	protected String message;

	public AbstractResultDto() {
		super();
		this.code = CommonEnum.SUCCESS.code();
		this.message = CommonEnum.SUCCESS.message();
	}

	public boolean testSuccess() {
		return CommonEnum.SUCCESS.code().equals(code);
	}

}
