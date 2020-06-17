package net.hunau.goodsmanager.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import net.hunau.goodsmanager.bean.Roles;
import net.hunau.goodsmanager.utils.JDBCUtils;

public class RoleDao {
	private Connection conn;
	private ResultSet rs;
	private PreparedStatement ps;
	public List<Roles>  getRoles(){
		List<Roles> roles = new ArrayList<Roles>();
		Roles role = null;
		String sql = "select * from roles";
		try {
			conn = JDBCUtils.getConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()){
				role = new Roles();
				role.setId(rs.getInt(1));
				role.setRoleName(rs.getString("roleName"));
				role.setRoleDesc(rs.getString("roleDesc"));
				roles.add(role);
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCUtils.release(rs, ps, conn);
		}
		return roles;
	}
	
	
	
	public static void main(String[] args) {
		RoleDao rd = new  RoleDao();
		System.out.println(rd.getRoles());
	}
}
