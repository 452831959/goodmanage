package net.hunau.goodsmanager.bean;

import java.io.Serializable;

public class Roles implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2040869007880295114L;
	
	private int id;
	private String roleName;
	private String roleDesc;

	public int getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Roles [id=" + id + ", roleName=" + roleName + ", roleDesc=" + roleDesc + "]";
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getRoleDesc() {
		return roleDesc;
	}

	public void setRoleDesc(String roleDesc) {
		this.roleDesc = roleDesc;
	}

}
