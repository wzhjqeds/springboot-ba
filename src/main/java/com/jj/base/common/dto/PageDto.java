package com.jj.base.common.dto;


import java.io.Serializable;
import java.util.Collections;
import java.util.List;

public class PageDto<T> implements Serializable {

	private static final long serialVersionUID = 1L;

	// 页码
	private int pageNum = 1;

	// 每页条数
	private int pageSize = 10;

	// 总页数
	private long pageCount;

	// 总页数
	private long total;

	// 返回数据
	private List<T> list = Collections.emptyList();

	public PageDto() {

	}

	public int getPageNum() {
		return this.pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}

	public int getPageSize() {
		return this.pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public long getPageCount() {
		return this.pageCount;
	}

	public void setPageCount(long pageCount) {
		this.pageCount = pageCount;
	}

	public List<T> getList() {
		return this.list;
	}

	public void setList(List<T> list) {
		this.list = list;
	}

	public long getTotal() {
		return this.total;
	}

	public void setTotal(long total) {
		this.total = total;
	}

}
