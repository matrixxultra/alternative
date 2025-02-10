package com.alternative.dto;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.alternative.entities.Category;
import com.alternative.entities.Product;
import com.alternative.entities.Review;
import com.alternative.entities.User;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;




@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ProdReq {
	
	
	private int statusCode;
	private String error;
	private String message;
    private String name;
    private String description;
    private double price;
    private int quantityInStock;
    private String redirectUrl;
    
    private Long category;
    private Product product; 
    private Long producer;
    private List<Review> reviews;
    private List<Product> products; 
    private MultipartFile image;

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


	public String getRedirectUrl() {
		return redirectUrl;
	}


	public void setRedirectUrl(String redirectUrl) {
		this.redirectUrl = redirectUrl;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public double getPrice() {
		return price;
	}


	public void setPrice(double price) {
		this.price = price;
	}


	public int getQuantityInStock() {
		return quantityInStock;
	}


	public void setQuantityInStock(int quantityInStock) {
		this.quantityInStock = quantityInStock;
	}


	



	public List<Review> getReviews() {
		return reviews;
	}


	public void setReviews(List<Review> reviews) {
		this.reviews = reviews;
	}


	public List<Product> getProducts() {
		return products;
	}


	public void setProducts(List<Product> products) {
		this.products = products;
	}


	public Product getProduct() {
		return product;
	}


	public void setProduct(Product product) {
		this.product = product;
	}


	public MultipartFile getImage() {
		return image;
	}


	public void setImage(MultipartFile image) {
		this.image = image;
	}


	public Long getCategory() {
		return category;
	}


	public void setCategory(Long category) {
		this.category = category;
	}


	public Long getProducer() {
		return producer;
	}


	public void setProducer(Long producer) {
		this.producer = producer;
	}


	
	
    
}
