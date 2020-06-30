package com.dbs.order.item.service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dbs.order.item.service.bean.OrderItemDO;
import com.dbs.order.item.service.impl.OrderItemService;

@RestController
@RequestMapping("orderitems")
public class OrderItemController {

	@Autowired
	private OrderItemService orderItemService;

	@PostMapping(value = "/create/order/item")
	public ResponseEntity<OrderItemDO> createOrderItem(@RequestBody OrderItemDO orderItemDTO) {
		return ResponseEntity.ok().body(orderItemService.createOrderItem(orderItemDTO));
	}

	@GetMapping(value = "/orderItem/{id}")
	public ResponseEntity<OrderItemDO> getOrderById(@PathVariable("id") Long id) {
		return ResponseEntity.ok().body(orderItemService.getOrderItemById(id));
	}

	@GetMapping(value = "/all/orderItems")
	public ResponseEntity<List<OrderItemDO>> getAllOrderItems() {
		return ResponseEntity.ok().body(orderItemService.getOrderAllOrderItems());
	}

	@GetMapping(value = "/orderId/{id}")
	public ResponseEntity<List<OrderItemDO>> getOrderItemByOrderId(Long id) {
		return ResponseEntity.ok().body(orderItemService.getOrderItemByOrderId(id));
	}

}
