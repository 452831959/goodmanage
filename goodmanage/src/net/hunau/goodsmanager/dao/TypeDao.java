package net.hunau.goodsmanager.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import net.hunau.goodsmanager.bean.GoodsType;
import net.hunau.goodsmanager.utils.JDBCUtils;

public class TypeDao {
	private Connection conn =null;
	private ResultSet rs=null;
	private PreparedStatement ps=null;
	/**
	 * 返回商品类型
	 * @return
	 */
	public List<GoodsType> scanAllGoodsType(){
		List<GoodsType> goodsType  = new ArrayList<GoodsType>();
		String sql = "select id,typename,typedes from goodstype";
		try {
			conn = JDBCUtils.getConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()){
				GoodsType goodstype = new GoodsType();
				goodstype.setId(rs.getInt("id"));
				goodstype.setTypeName(rs.getString("typename"));
				goodstype.setTypeDec(rs.getString("typedes"));
				goodsType.add(goodstype);
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCUtils.release(ps, conn);
		}
		
		
		return goodsType;
	}
	
	/**
	 * 添加商品分类
	 * @param goodsType
	 */
	public void addType(GoodsType goodsType){
		String sql = "insert into goodstype(id,typename,typedes) values(?,?,?)";
		try {
			conn = JDBCUtils.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, goodsType.getId());
			ps.setString(2, goodsType.getTypeName());
			ps.setString(3, goodsType.getTypeDec());
			ps.executeUpdate();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * 根据用户输入商品ID判断数据库是否已经存在    true - 存在    false-不存在
	 * @param TypeId
	 * @return
	 */
	public boolean isExsit(int TypeId){
		String sql = "select id from goodstype where id="+TypeId;
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
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return false;
	}
	/*public static void main(String[] args) {
		TypeDao tp = new TypeDao();
//		System.out.println(tp.isExsit(78));
	}*/
}
