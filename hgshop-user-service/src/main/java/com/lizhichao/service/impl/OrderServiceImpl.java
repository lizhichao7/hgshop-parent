package com.lizhichao.service.impl;

import java.util.List;

import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lizhichao.bean.Order;
import com.lizhichao.bean.OrderDetail;
import com.lizhichao.dao.OrderDao;
import com.lizhichao.service.OrderService;

/**
 * 
 * @author 李志超
 *
 */
@Service(interfaceClass=OrderService.class)
public class OrderServiceImpl implements OrderService{

	@Autowired
	OrderDao orderDao;

	@Override
	public PageInfo<Order> list(int userId, int page) {
		// TODO Auto-generated method stub
		PageHelper.startPage(page, 10);
		
		return new PageInfo<Order>(orderDao.list(userId));
	}

	@Override
	public List<OrderDetail> listDetail(int orderId, int page) {
		// TODO Auto-generated method stub
		return orderDao.listDetail(orderId);
	}

}
