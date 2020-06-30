package com.dbs.orderservice.impl;

import java.util.List;

import com.dbs.orderservice.bean.OrderDO;

public interface OrderService {

	public OrderDO createOrder(OrderDO orderDTO);
	
	public OrderDO getOrderById(Long id);
	
	public List<OrderDO> getAllOrders();
	
}
