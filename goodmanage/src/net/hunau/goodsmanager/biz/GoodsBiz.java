package net.hunau.goodsmanager.biz;

import java.util.ArrayList;
import java.util.List;

import net.hunau.goodsmanager.bean.Goods;
import net.hunau.goodsmanager.bean.GoodsDao;

public class GoodsBiz {
	private GoodsDao gd;
	public GoodsBiz(){
		gd = new GoodsDao();
	}
	
	public void  addGoods(Goods goods){
		gd.addGoods(goods);
	}
	public List<Goods> getGoods(){
		return gd.getGoods();
	}
	/**
	 * 判断是根据商品ID还是根据商品名称查询数据库。
	 * @param condition
	 * @return
	 */
	public List<Goods> findGoods(Goods condition){
		List<Goods> goods = new ArrayList<Goods>();
		if(condition.getId()!=0){
			goods.add(gd.getGoods(condition.getId()));
		}else if(condition.getGoodname() != null){
			goods.addAll(gd.getGoods(condition.getGoodname()));
		}

		return goods;
	}
}
