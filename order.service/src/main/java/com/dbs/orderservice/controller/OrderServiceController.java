package com.dbs.orderservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dbs.orderservice.bean.OrderDO;
import com.dbs.orderservice.impl.OrderService;

@RestController
@RequestMapping("order-service")
public class OrderServiceController {

	@Autowired
	private OrderService orderService;

	@PostMapping("/create/order")
	public ResponseEntity<OrderDO> createOrder(@RequestBody OrderDO orderDTO) {
		return ResponseEntity.ok().body(orderService.createOrder(orderDTO));
	}

	@GetMapping("/orderid/{id}")
	public ResponseEntity<OrderDO> getOrderByOrderId(@PathVariable("id") Long id) {
		return ResponseEntity.ok().body(orderService.getOrderById(id));
	}

	@GetMapping("all/orders")
	public ResponseEntity<List<OrderDO>> getAllOrdersList() {
		return ResponseEntity.ok().body(orderService.getAllOrders());
	}

}
