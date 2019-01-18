package com.jj.base.common.dto;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;

@ApiModel(description = "排序参数")
public class SortDto implements Serializable {

	private static final long serialVersionUID = 142629486027462929L;

	private String sortParamName;

	private boolean isDesc;

	public void setSortParamName(String sortParamName) {
		this.sortParamName = sortParamName;
	}

	public void setDesc(boolean isDesc) {
		this.isDesc = isDesc;
	}

	@Override
	public boolean equals(Object o) {
		if (o == this) {
			return true;
		}
		if (!(o instanceof SortDto)) {
			return false;
		}
		SortDto other = (SortDto) o;
		if (!other.canEqual(this)) {
			return false;
		}
		Object this$sortParamName = getSortParamName();
		Object other$sortParamName = other.getSortParamName();
		if (this$sortParamName == null ? other$sortParamName != null
				: !this$sortParamName.equals(other$sortParamName)) {
			return false;
		}
		return isDesc() == other.isDesc();
	}

	protected boolean canEqual(Object other) {
		return other instanceof SortDto;
	}

	@Override
	public int hashCode() {
		int result = 1;
		Object $sortParamName = getSortParamName();
		result = result * 59 + ($sortParamName == null ? 43 : $sortParamName.hashCode());
		result = result * 59 + (isDesc() ? 79 : 97);
		return result;
	}

	@Override
	public String toString() {
		return "SortDto(sortParamName=" + getSortParamName() + ", isDesc=" + isDesc()
				+ ")";
	}

	public String getSortParamName() {
		return this.sortParamName;
	}

	public boolean isDesc() {
		return this.isDesc;
	}

}
