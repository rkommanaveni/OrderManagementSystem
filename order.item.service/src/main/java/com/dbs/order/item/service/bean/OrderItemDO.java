package com.dbs.order.item.service.bean;

import java.io.Serializable;


public class OrderItemDO implements Serializable {



	/**
	 * 
	 */
	private static final long serialVersionUID = 677718779300296749L;

	private Long id;

	private Long orderItemId;

	private Long orderId;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getOrderItemId() {
		return orderItemId;
	}

	public void setOrderItemId(Long orderItemId) {
		this.orderItemId = orderItemId;
	}

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public String getProductCode() {
		return productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	private String productCode;

	private String productName;

	private Integer quantity;
	
	public OrderItemDO() {
		
	}

}
