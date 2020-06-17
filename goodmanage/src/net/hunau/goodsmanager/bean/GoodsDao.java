package net.hunau.goodsmanager.bean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import net.hunau.goodsmanager.utils.JDBCUtils;

public class GoodsDao {
	private Connection conn =null;
	private ResultSet rs=null;
	private PreparedStatement ps=null;
	private static GoodsDao gd = new GoodsDao();;
	
	/**
	 * 添加商品
	 * @param goods
	 */
	public void  addGoods(Goods goods){
		String sql = "insert into goods(goodsName,goodsPrice,goodsCount,goodsDep,goodsType)"+"values(?,?,?,?,?)";
		try {
			conn = JDBCUtils.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, goods.getGoodname());
			ps.setDouble(2, goods.getGoodprice());
			ps.setInt(3, goods.getGoodcount());
			ps.setString(4, goods.getGoodDep());
			ps.setString(5, goods.getGoodtype());
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
	 * 商品查询
	 * @return
	 */
	public List<Goods> getGoods(){
		List<Goods> goods = new ArrayList<Goods>();
		String sql = "select * from goods";
		try {
			conn = JDBCUtils.getConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()){
				Goods Goods = new Goods();
				Goods.setId(rs.getInt("goodsID"));
				Goods.setGoodname(rs.getString("goodsName"));
				Goods.setGoodprice(rs.getDouble("goodsPrice"));
				Goods.setGoodcount(rs.getInt("goodsCount"));
				Goods.setGoodtype(gd.GtIntToString(rs.getInt("goodsType")));
				Goods.setGoodDep(rs.getString("goodsDep"));
				goods.add(Goods);
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
		
		return goods;
	}
	/**
	 * 根据商品名称查询商品
	 * @param goodsName
	 * @return
	 */
	public List<Goods> getGoods(String goodsName){
		List<Goods> goods = new ArrayList<Goods>();
		String sql = "select * from goods where goodsName like '%"+goodsName+"%'";
		try {
			conn = JDBCUtils.getConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()){
				Goods Goods = new Goods();
				Goods.setId(rs.getInt("goodsID"));
				Goods.setGoodname(rs.getString("goodsName"));
				Goods.setGoodprice(rs.getDouble("goodsPrice"));
				Goods.setGoodcount(rs.getInt("goodsCount"));
				Goods.setGoodtype(gd.GtIntToString(rs.getInt("goodsType")));
				Goods.setGoodDep(rs.getString("goodsDep"));
				goods.add(Goods);
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
		
		return goods;
	}
	
	/**
	 * 根据商品ID查询商品
	 * @param id
	 * @return
	 */
	public Goods getGoods(int id){
		String sql = "select * from goods where goodsID="+id;
		Goods Goods = null;
		try {
			conn = JDBCUtils.getConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()){
				Goods = new Goods();
				Goods.setId(rs.getInt("goodsID"));
				Goods.setGoodname(rs.getString("goodsName"));
				Goods.setGoodprice(rs.getDouble("goodsPrice"));
				Goods.setGoodcount(rs.getInt("goodsCount"));
				Goods.setGoodtype(gd.GtIntToString(rs.getInt("goodsType")));
				Goods.setGoodDep(rs.getString("goodsDep"));
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
		
		return Goods;
	}
	/**
	 * 根据商品ID删除商品
	 * @param id
	 */
	public void delGoods(int id){
		String sql = "delete from goods where goodsID="+id;
		try {
			conn = JDBCUtils.getConnection();
			ps = conn.prepareStatement(sql);
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
	 * 更新商品
	 * @param goods
	 */
	public void updateGoods(Goods goods){
		String sql = "update goods set goodsName=?,goodsPrice=?,goodsCount=?,goodsDep=?,goodsType=? where goodsID=?";
		try {
			conn = JDBCUtils.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, goods.getGoodname());
			ps.setDouble(2, goods.getGoodprice());
			ps.setInt(3, goods.getGoodcount());
			ps.setString(4, goods.getGoodDep());
			ps.setString(5, goods.getGoodtype());
			ps.setInt(6,goods.getId());
			ps.executeUpdate();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
	}
	
	
	public String GtIntToString (int goodstype){
		String sql  = "select typename from goodstype where id="+goodstype;
		String str = "";
		try {
			conn = JDBCUtils.getConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			
			if(rs.next()){
				str = rs.getString("typename");
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
		return str;
	}
	public static void main(String[] args) {
		
	}
	
	
}
