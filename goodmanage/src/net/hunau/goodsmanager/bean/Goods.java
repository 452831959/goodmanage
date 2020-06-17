package net.hunau.goodsmanager.bean;

import java.io.Serializable;

public class Goods implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2871543335292737531L;
		
	
	private int id;
	private String goodname;
	private double goodprice;
	private int goodcount;
	private String goodDep;
	private String goodtype;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getGoodname() {
		return goodname;
	}

	public void setGoodname(String goodname) {
		this.goodname = goodname;
	}

	public double getGoodprice() {
		return goodprice;
	}

	public void setGoodprice(double goodprice) {
		this.goodprice = goodprice;
	}

	public int getGoodcount() {
		return goodcount;
	}

	public void setGoodcount(int goodcount) {
		this.goodcount = goodcount;
	}

	public String getGoodtype() {
		return goodtype;
	}

	public void setGoodtype(String goodtype) {
		this.goodtype = goodtype;
	}

	public String getGoodDep() {
		return goodDep;
	}

	public void setGoodDep(String goodDep) {
		this.goodDep = goodDep;
	}

	

}
