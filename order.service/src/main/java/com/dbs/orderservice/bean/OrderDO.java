package com.dbs.orderservice.bean;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

public class OrderDO implements Serializable {


	/**
	 * 
	 */
	private static final long serialVersionUID = 5009846915844238374L;

	private Long id;

	private Long orderId;
	
	private String customerName;

	private Date orderDate;
	private String shippingAddress;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public String getShippingAddress() {
		return shippingAddress;
	}

	public void setShippingAddress(String shippingAddress) {
		this.shippingAddress = shippingAddress;
	}

	public Long getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(Long totalAmount) {
		this.totalAmount = totalAmount;
	}

	public List<OrderItemDO> getOrderItemDTOs() {
		return orderItemDTOs;
	}

	public void setOrderItemDTOs(List<OrderItemDO> orderItemDTOs) {
		this.orderItemDTOs = orderItemDTOs;
	}

	private Long totalAmount;
	
	private List<OrderItemDO> orderItemDTOs;

}
