package com.jj.base.common.dto;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

/**
 * @author scm
 */

@ApiModel(description = "基础请求参数")
@Data
public class InputDto implements Serializable {

	private static final long serialVersionUID = 3749228091628239342L;

	@JsonIgnore
	@ApiModelProperty(allowEmptyValue = true, required = false, value = "请求IP")
	private String ip;

	@JsonIgnore
	@ApiModelProperty(allowEmptyValue = true, required = false, value = "操作人")
	private String operator;
	
	@ApiModelProperty(allowEmptyValue=true, required=false, value="排序")
	private List<SortDto> sortParam;

}
