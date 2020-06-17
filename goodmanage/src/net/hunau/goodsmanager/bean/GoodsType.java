package net.hunau.goodsmanager.bean;

import java.io.Serializable;

public class GoodsType implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7427677125691690732L;
	
	private int id;
	private String typeName;
	private String typeDec;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTypeName() {
		return typeName;
	}
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
	public String getTypeDec() {
		return typeDec;
	}
	public void setTypeDec(String typeDec) {
		this.typeDec = typeDec;
	}

}
