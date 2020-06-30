package com.dbs.order.item.service.impl;

import java.util.List;

import com.dbs.order.item.service.bean.OrderItemDO;

public interface OrderItemService {
	
	  public OrderItemDO createOrderItem(OrderItemDO orderItemDTO);
	  
	  public OrderItemDO getOrderItemById(Long id);
	  
	  public List<OrderItemDO> getOrderAllOrderItems();	
	  
	  public List<OrderItemDO> getOrderItemByOrderId(Long id);
	 
}
