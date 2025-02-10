package com.alternative.dto;


import java.util.Date;

import com.alternative.entities.Product;
import com.alternative.entities.User;




public class ReviewReq {
	
		private int statusCode;
		private String error;
		private String message;
	    private User client;
	    private Product product;
	    private int rating;
	    private String comment;
	    private Date reviewDate;
	    
	    
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
		public User getClient() {
			return client;
		}
		public void setClient(User client) {
			this.client = client;
		}
		public Product getProduct() {
			return product;
		}
		public void setProduct(Product product) {
			this.product = product;
		}
		public int getRating() {
			return rating;
		}
		public void setRating(int rating) {
			this.rating = rating;
		}
		public String getComment() {
			return comment;
		}
		public void setComment(String comment) {
			this.comment = comment;
		}
		public Date getReviewDate() {
			return reviewDate;
		}
		public void setReviewDate(Date reviewDate) {
			this.reviewDate = reviewDate;
		}
	    
}
