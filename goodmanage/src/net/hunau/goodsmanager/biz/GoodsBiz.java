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
	 * �ж��Ǹ�����ƷID���Ǹ�����Ʒ���Ʋ�ѯ���ݿ⡣
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
