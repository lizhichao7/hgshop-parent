package com.lizhichao.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.lizhichao.bean.Order;
import com.lizhichao.bean.OrderDetail;

/**
 * 订单的服务
 * @author 李志超
 *
 */
public interface OrderService {
	
	//查看订单
	PageInfo<Order> list(int userId,int page);
	
	//查看订单详情
	List<OrderDetail> listDetail(int orderId,int page);
	
	
	
}
