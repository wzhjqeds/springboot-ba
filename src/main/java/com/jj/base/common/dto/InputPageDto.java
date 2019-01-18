package com.jj.base.common.dto;


import javax.validation.constraints.Min;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

@ApiModel(description = "基础请求参数")
@Data 
@EqualsAndHashCode(callSuper = true)
public  class InputPageDto extends InputDto {

	private static final long serialVersionUID = 8788247457467212974L;

	@ApiModelProperty(allowEmptyValue = false, required = true, value = "当前页码")
	@Min(1)
	private int pageNum = 1;

	@ApiModelProperty(allowEmptyValue = false, required = true, value = "页大小")
	@Min(1)
	private int pageSize = 10;

}
