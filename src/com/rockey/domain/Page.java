package com.rockey.domain;

import java.util.List;

public class Page {
	private int thispage;
	private int rowpage;
	private int firstpage;
	private int lastpage;
	private int prepage;
	private int nextpage;
	private int rowcount;
	private int pagecount;
	private List<Cust> list;
	public int getThispage() {
		return thispage;
	}
	public void setThispage(int thispage) {
		this.thispage = thispage;
	}
	public int getRowpage() {
		return rowpage;
	}
	public void setRowpage(int rowpage) {
		this.rowpage = rowpage;
	}
	public int getFirstpage() {
		return firstpage;
	}
	public void setFirstpage(int firstpage) {
		this.firstpage = firstpage;
	}
	public int getLastpage() {
		return lastpage;
	}
	public void setLastpage(int lastpage) {
		this.lastpage = lastpage;
	}
	public int getPrepage() {
		return prepage;
	}
	public void setPrepage(int prepage) {
		this.prepage = prepage;
	}
	public int getNextpage() {
		return nextpage;
	}
	public void setNextpage(int nextpage) {
		this.nextpage = nextpage;
	}
	public int getPagecount() {
		return pagecount;
	}
	public void setPagecount(int pagecount) {
		this.pagecount = pagecount;
	}
	public List<Cust> getList() {
		return list;
	}
	public void setList(List<Cust> list ) {
		this.list = list;
	}
	public int getRowcount() {
		return rowcount;
	}
	public void setRowcount(int rowcount) {
		this.rowcount = rowcount;
	}
}
