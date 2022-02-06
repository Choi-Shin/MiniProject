package com.choi.board.common;

public class PageNavigator {

	private int totalCount;
	private int startPage;
	private int endPage;
	private boolean prev;
	private boolean next;
	private Page page;

	private int displayPageNum = 10;

	public void setPage(Page page) {
		this.page = page;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
		setOthers();
	}

	public Page getPage() {
		return page;
	}

	public boolean isPrev() {
		return prev;
	}

	public void setPrev(boolean prev) {
		this.prev = prev;
	}

	public boolean isNext() {
		return next;
	}

	public void setNext(boolean next) {
		this.next = next;
	}

	public int getDisplayPageNum() {
		return displayPageNum;
	}

	public void setDisplayPageNum(int displayPageNum) {
		this.displayPageNum = displayPageNum;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}

	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}

	public int getStartPage() {
		return startPage;
	}

	public int getEndPage() {
		return endPage;
	}

	private void setOthers() {
		endPage = (int) (Math.ceil(page.getPage() / (double) displayPageNum) * displayPageNum);
		int tempEndPage = (int) (Math.ceil(totalCount / (double) page.getPerPageNum()));
		if (endPage > tempEndPage) {
			endPage = tempEndPage;
		}

		startPage = (endPage - displayPageNum) + 1;
		if (startPage <= 0) {
			startPage = 1;
		}

		prev = startPage == 1 ? false : true;
		next = endPage * page.getPerPageNum() >= totalCount ? false : true;
	}

}
