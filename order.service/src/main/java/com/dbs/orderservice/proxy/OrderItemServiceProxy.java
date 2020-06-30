package com.dbs.orderservice.proxy;

import java.util.List;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.dbs.orderservice.bean.OrderItemDO;


@Configuration
@FeignClient(name="order.item.service")
@RibbonClient(name="order.item.service")
public interface OrderItemServiceProxy {

	@GetMapping("/order-items/orderId/{id}")
	public ResponseEntity<List<OrderItemDO>> getOrderByOrderId(@PathVariable("id") long id);
	
	@PostMapping("/order-items/create/order/item")
	public ResponseEntity<OrderItemDO> createOrderItem(@RequestBody OrderItemDO orderItemDTO);
	
	
}
