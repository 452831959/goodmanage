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
	// 初始化C3P0数据源
	static {
		// 使用c3p0-config.xml配置文件中的named-config节点中name属性的值
		ComboPooledDataSource cpds = new ComboPooledDataSource("goodmanage");
		ds = cpds;
	}
	// 加载驱动，并建立数据库连接
	public static Connection getConnection() throws SQLException,
			ClassNotFoundException {
		return ds.getConnection();
	}
	// 关闭数据库连接，释放资源
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
