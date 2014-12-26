package com.gms.domain;

import java.util.List;

public class Page {

	private int totalPage;// ��ס��ҳ��
	private int startPage;// ��ʼҳ
	private int endPage;// ����ҳ
	private int pageSize ;// ҳ���С,Ҳ���Ƕ������
	private int totalRecord;// �ܼ�¼��
	private int pageNum;// ��ס��ǰҳ
	private int startIndex;// ��¼����ݿ��ĸ��ط���ʼ
	private List list;// ����ҳ������

	public Page(int pageSize, int pageNum, int totalRecord) {
		
		this.pageSize = pageSize;
		this.pageNum = pageNum;
		this.totalRecord = totalRecord;

		// �����ҳ��
		this.totalPage = (this.totalRecord + this.pageSize - 1) / this.pageSize;
		// �������ݿ��ĸ��ط���ʼ��ȡ���
		this.startIndex = this.pageSize * (this.pageNum - 1);
		// �����ʼҳ��ͽ���ҳ��
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
