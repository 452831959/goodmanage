package net.hunau.goodsmanager.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import net.hunau.goodsmanager.bean.User;
import net.hunau.goodsmanager.utils.JDBCUtils;

public class UserDao {
	private Connection conn;
	private ResultSet rs;
	private PreparedStatement ps;
	/**
	 * 根据用户名和密码获取User
	 * @param userName
	 * @param pwd
	 * @return
	 */
	public User getUser(String userName,String pwd){
		User us = null;
		String sql ="select userName,pwd,roles from users where userName=? and pwd=?";
		try {
			conn = JDBCUtils.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, userName);
			ps.setString(2, pwd);
			rs = ps.executeQuery();
			if(rs.next()){
				us = new User();
				us.setUsername(rs.getString("userName"));
				us.setPassword(rs.getString("pwd"));
				us.setRoles(rs.getInt("roles"));
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

		return us;
	}
	/**
	 * 查询数据库返回用户信息
	 * @param args
	 */
	public List<User> getUsers(){
		List<User> users = new ArrayList<User>();
		String sql = "select userName,pwd,validateFlag,roles from users";
		User tempUser = null;
		try {
			conn = JDBCUtils.getConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()){
				tempUser  =  new User();
				tempUser.setUsername(rs.getString("userName"));	
				tempUser.setPassword(rs.getString("pwd"));	
				tempUser.setValidateFlag(rs.getInt("validateFlag"));
				tempUser.setRoles(rs.getInt("roles"));
				users.add(tempUser);
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return users;
	}
	/**
	 * 根据用户名获取用户信息
	 * @param userName
	 * @param pwd
	 * @return
	 */
	public User getUser(String userName){
		User us = null;
		String sql ="select userName,pwd,validateFlag,roles from users where userName=?";
		try {
			conn = JDBCUtils.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, userName);
			rs = ps.executeQuery();
			if(rs.next()){
				us = new User();
				us.setUsername(rs.getString("userName"));
				us.setPassword(rs.getString("pwd"));
				us.setValidateFlag(rs.getInt("validateFlag"));
				us.setRoles(rs.getInt("roles"));	
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

		return us;
	}
	/**
	 * 用户信息修改
	 * @param args
	 */
	public void updateUser(User user){
		//pwd=md5(?)
		String sql = "update users set validateFlag=?,pwd=?,roles=? where UserName=?";
		try {
			conn = JDBCUtils.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, user.getValidateFlag());
			ps.setString(2, user.getPassword());
			ps.setInt(3, user.getRoles());
			ps.setString(4, user.getUsername());
			ps.executeUpdate();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCUtils.release(ps, conn);
		}
		
		
	}
	
	
	/**
	 * 用户标识修改
	 * @param args
	 */
	public void updateUservalidateFlag(User user){
		String sql = "update users set validateFlag=? where UserName=?";
		try {
			conn = JDBCUtils.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, user.getValidateFlag());
			ps.setString(2, user.getUsername());
			ps.executeUpdate();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCUtils.release(ps, conn);
		}
		
		
	}
	/**
	 * 添加用户
	 * @param args
	 */
	public void addUser(User user){
		String sql = "insert into users(userName,pwd,validateFlag,roles) values(?,?,?,?)";
		try {
			conn = JDBCUtils.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, user.getUsername());
			ps.setString(2, user.getPassword());
			ps.setInt(3, user.getValidateFlag());
			ps.setInt(4, user.getRoles());
			ps.executeUpdate();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCUtils.release(ps, conn);
		}
		
	}
	/**
	 * 判断用户名是否已经存在  true - 存在  false -- 不存在
	 * @param UserName
	 * @return
	 */
	public boolean checkUser(String UserName){
		String sql = "select * from users where userName='"+UserName+"'";
		try {
			try {
				conn = JDBCUtils.getConnection();
				ps = conn.prepareStatement(sql);
				rs = ps.executeQuery();
				if(rs.next()){
					return true;
				}
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCUtils.release(rs, ps, conn);
		}
		return false;
	}
	
	public static void main(String[] args) {
		UserDao u = new UserDao();
//		System.out.println(	u.getUser("peter", "123456"));
		List<User> us = u.getUsers();
		for (User user : us) {
			System.out.println(user);
		}
		
	}
}
