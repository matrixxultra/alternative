package com.alternative.dto;

import java.util.Date;
import java.util.List;

import com.alternative.entities.Order;
import com.alternative.entities.OrderItem;
import com.alternative.entities.Product;
import com.alternative.entities.User;



public class OrderReq {
	
	private User client;
	private int statusCode;
	private String error;
	private String message;
    private Date orderDate;
    private String status;
    private double totalAmount;
    private Product product;
    private Order order;
    List<OrderItem> orderItems;
    
	public User getClient() {
		return client;
	}
	public void setClient(User client) {
		this.client = client;
	}
	public Date getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public double getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}
	public int getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}
	public String getError() {
		return error;
	}
	public void setError(String error) {
		this.error = error;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
	}
	public List<OrderItem> getOrderItems() {
		return orderItems;
	}
	public void setOrderItems(List<OrderItem> orderItems) {
		this.orderItems = orderItems;
	}
    
	
    
}
