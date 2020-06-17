package net.hunau.goodsmanager.bean;

import java.io.Serializable;

public class User implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6380310081684555616L;
	
	private String username;
	private String password;
	private int validateFlag;
	private int roles;

	public int getValidateFlag() {
		return validateFlag;
	}

	public void setValidateFlag(int validateFlag) {
		this.validateFlag = validateFlag;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "User [userName=" + username + ", password=" + password
				+ ", validateFlag=" + validateFlag + "]";
	}

	public int getRoles() {
		return roles;
	}

	public void setRoles(int roles) {
		this.roles = roles;
	}

}
