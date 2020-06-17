package net.hunau.goodsmanager.utils;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;
public class JDBCUtils {
	
	public static DataSource ds = null;
	// ��ʼ��C3P0����Դ
	static {
		// ʹ��c3p0-config.xml�����ļ��е�named-config�ڵ���name���Ե�ֵ
		ComboPooledDataSource cpds = new ComboPooledDataSource("goodmanage");
		ds = cpds;
	}
	// �������������������ݿ�����
	public static Connection getConnection() throws SQLException,
			ClassNotFoundException {
		return ds.getConnection();
	}
	// �ر����ݿ����ӣ��ͷ���Դ
	public static void release(Statement stmt, Connection conn) {
		if (stmt != null) {
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			stmt = null;
		}
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			conn = null;
		}
	}
     public static void release(ResultSet rs, Statement stmt, 
     		Connection conn){
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			rs = null;
		}
		release(stmt, conn);
	}
}
