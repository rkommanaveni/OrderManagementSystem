package com.dbs.orderservice.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.dbs.orderservice.bean.OrderDO;
import com.dbs.orderservice.bean.OrderItemDO;
import com.dbs.orderservice.exception.ErrorCreatingOrderService;
import com.dbs.orderservice.exception.OrderNotFoundException;
import com.dbs.orderservice.model.Order;
import com.dbs.orderservice.proxy.OrderItemServiceProxy;
import com.dbs.orderservice.repository.OrderRepository;

@Service("orderService")
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderRepository orderRepository;

	@Autowired
	private OrderItemServiceProxy orderItemServiceProxy;

	@Override
	public OrderDO createOrder(OrderDO orderDTO) {
		Order order = new Order();
		BeanUtils.copyProperties(orderDTO, order);
		order = orderRepository.save(order);
		if (null != order) {
			BeanUtils.copyProperties(order, orderDTO);
			if (!CollectionUtils.isEmpty(orderDTO.getOrderItemDTOs())) {
				List<OrderItemDO> itemDTOList = new ArrayList<>();
				for(OrderItemDO itemDTO: orderDTO.getOrderItemDTOs()) {
					ResponseEntity<OrderItemDO> orderItemDTO = orderItemServiceProxy.createOrderItem(itemDTO);
					if (null != orderItemDTO) {
						itemDTOList.add(orderItemDTO.getBody());
					}
				}
				orderDTO.setOrderItemDTOs(itemDTOList);
			}
		} else {
			throw new ErrorCreatingOrderService("unable to create the order");
		}

		return orderDTO;
	}

	@Override
	public OrderDO getOrderById(Long id) {
		OrderDO orderDTO = new OrderDO();
		Order order = orderRepository.findByOrderId(id);
		if (null != order) {
			BeanUtils.copyProperties(order, orderDTO);
			ResponseEntity<List<OrderItemDO>> responseEntity = orderItemServiceProxy.getOrderByOrderId(order.getOrderId());
			if(null != responseEntity) {
				orderDTO.setOrderItemDTOs(responseEntity.getBody());
			}
		} else {
			throw new OrderNotFoundException("No order item found");
		}
		return orderDTO;
	}

	@Override
	public List<OrderDO> getAllOrders() {
		List<OrderDO> orderDTOList = new ArrayList<>();
		List<Order> orderList = orderRepository.findAll();
		if (!CollectionUtils.isEmpty(orderList)) {
			orderList.forEach(order -> {
				OrderDO orderDTO = new OrderDO();
				BeanUtils.copyProperties(order, orderDTO);
				orderDTOList.add(orderDTO);
			});
			BeanUtils.copyProperties(orderList, orderDTOList);
		} else {
			throw new OrderNotFoundException("No order item found");
		}
		return orderDTOList;
	}

}
