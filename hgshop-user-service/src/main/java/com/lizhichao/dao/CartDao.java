package com.lizhichao.dao;

import java.util.List;

import com.lizhichao.bean.Cart;

/**
 * 
 * @author 李志超
 *
 */
public interface CartDao {
	
	int delete(int[] ids);

	int add(Cart cart);

	int clear(int uid);

	List<Cart> list(int uid);

	List<Cart> listByIds(int[] cartIds);
	
	//根据购物车数据id 数据
	void deleteByIds(int[] cartIds);
}
