package com.gms.domain;

import java.util.List;

public class Page {

	private int totalPage;// 锟斤拷住锟斤拷页锟斤拷
	private int startPage;// 锟斤拷始页
	private int endPage;// 锟斤拷锟斤拷页
	private int pageSize ;// 页锟斤拷锟叫�也锟斤拷锟角讹拷锟斤拷锟斤拷锟�
	private int totalRecord;// 锟杰硷拷录锟斤拷
	private int pageNum;// 锟斤拷住锟斤拷前页
	private int startIndex;// 锟斤拷录锟斤拷锟斤拷菘锟斤拷母锟斤拷胤锟斤拷锟绞�
	private List list;// 锟斤拷锟斤拷页锟斤拷锟斤拷锟斤拷

	public Page(int pageSize, int pageNum, int totalRecord) {
		
		this.pageSize = pageSize;
		this.pageNum = pageNum;
		this.totalRecord = totalRecord;

		// 锟斤拷锟斤拷锟揭筹拷锟�
		this.totalPage = (this.totalRecord + this.pageSize - 1) / this.pageSize;
		// 锟斤拷锟斤拷锟斤拷锟捷匡拷锟侥革拷锟截凤拷锟斤拷始锟斤拷取锟斤拷锟�
		this.startIndex = this.pageSize * (this.pageNum - 1);
		// 锟斤拷锟斤拷锟绞家筹拷锟酵斤拷锟斤拷页锟斤拷
		if (this.totalPage <= 10) {
			this.startPage = 1;
			this.endPage = this.totalPage;
		} else {
			this.startPage = this.pageNum - 4;
			this.endPage = this.pageNum + 5;
			if (this.startPage < 1) {
				this.startPage = 1;
				this.endPage = 10;
			}
			if (this.endPage > this.totalPage) {
				this.endPage = this.totalPage;
				this.startPage = this.totalPage - 9;
			}
		}
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public int getStartPage() {
		return startPage;
	}

	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}

	public int getEndPage() {
		return endPage;
	}

	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getTotalRecord() {
		return totalRecord;
	}

	public void setTotalRecord(int totalRecord) {
		this.totalRecord = totalRecord;
	}

	public int getStartIndex() {
		return startIndex;
	}

	public void setStartIndex(int startIndex) {
		this.startIndex = startIndex;
	}

	public List getList() {
		return list;
	}

	public void setList(List list) {
		this.list = list;
	}

	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}

}
