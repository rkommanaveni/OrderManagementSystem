package com.dbs.order.item.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import com.dbs.order.item.service.bean.OrderItemDO;
import com.dbs.order.item.service.exception.OrderItemDataException;
import com.dbs.order.item.service.exception.OrderItemNotFound;
import com.dbs.order.item.service.exception.OrderItemNotAvailable;
import com.dbs.order.item.service.model.OrderItem;
import com.dbs.order.item.service.repository.OrderItemRepository;


@Service("orderItemService")
public class OrderItemServiceImpl implements OrderItemService {

	@Autowired
	private OrderItemRepository orderItemRepository;

	@Override
	@Transactional
	public OrderItemDO createOrderItem(OrderItemDO orderItemDTO) {
		OrderItem oderItem = new OrderItem();
		OrderItemDO orderItemDTORes = new OrderItemDO();
		try {
			if (null != orderItemDTO) {
				BeanUtils.copyProperties(orderItemDTO, oderItem);
				oderItem = orderItemRepository.save(oderItem);
				BeanUtils.copyProperties(oderItem, orderItemDTORes);
			}
		} catch (Exception exception) {
			throw new OrderItemNotAvailable(exception.getMessage());
		}
		return orderItemDTORes;
	}

	@Override
	public OrderItemDO getOrderItemById(Long id) {
		OrderItemDO itemDTO = new OrderItemDO();
		try {
			OrderItem orderItem = orderItemRepository.findByOrderItemId(id);
			if (null != orderItem) {
				BeanUtils.copyProperties(orderItem, itemDTO);
			} else {
				throw new OrderItemNotFound("No order items are available");
			}
		} catch (Exception exception) {
			throw new OrderItemDataException(exception.getMessage());
		}
		return itemDTO;
	}

	@Override
	public List<OrderItemDO> getOrderAllOrderItems() {
		List<OrderItemDO> orderItemDTOList = null;
		List<OrderItem> orderItem = null;
		try {
			orderItem = orderItemRepository.findAll();
			if (!CollectionUtils.isEmpty(orderItem)) {
				orderItemDTOList = convertBOListTODTOList(orderItem);
			} else {
				throw new OrderItemNotFound("No order items are available");
			}
		} catch (Exception exception) {
			throw new OrderItemDataException(exception.getMessage());
		}

		return orderItemDTOList;
	}

	@Override
	public List<OrderItemDO> getOrderItemByOrderId(Long id) {
		List<OrderItemDO> itemDTOList = null;
		List<OrderItem> orderItems = orderItemRepository.findByOrderId(id);

		if (!CollectionUtils.isEmpty(orderItems)) {
			itemDTOList = convertBOListTODTOList(orderItems);
		} else {
			throw new OrderItemNotFound("order items are not available with this order id");
		}
		return itemDTOList;
	}

	private List<OrderItemDO> convertBOListTODTOList(List<OrderItem> orderItems) {
		List<OrderItemDO> itemDTOList = new ArrayList<>();
		orderItems.forEach(item -> {
			OrderItemDO itemDTO = new OrderItemDO();
			BeanUtils.copyProperties(item, itemDTO);
			itemDTOList.add(itemDTO);
		});
		return itemDTOList;
	}
}
