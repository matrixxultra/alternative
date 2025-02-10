package com.alternative.services;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.alternative.dto.OrderReq;
import com.alternative.dto.ProdReq;
import com.alternative.dto.ReviewReq;
import com.alternative.entities.Category;
import com.alternative.entities.Order;
import com.alternative.entities.OrderItem;
import com.alternative.entities.Product;
import com.alternative.entities.Review;
import com.alternative.entities.User;
import com.alternative.repositories.CategoryRepository;
import com.alternative.repositories.OrderItemRepository;
import com.alternative.repositories.OrderRepository;
import com.alternative.repositories.ProductRepository;
import com.alternative.repositories.ReviewRepository;
import com.alternative.repositories.UserRepository;


@Service
public class ClientService {
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private ReviewRepository reviewRepository;

	
	
	@Autowired
    private OrderItemRepository orderItemRepository;
	
	@Autowired
	private OrderRepository orderRepository;
	

	public List<Product> getAllProducts(){
		return productRepository.findAll();
	}
	
	public ProdReq getProduct(Long id) {
		ProdReq resp = new ProdReq();
		Product product = productRepository.findById(id).orElseThrow();
		resp.setStatusCode(200);
		resp.setProduct(product);
		resp.setReviews(reviewRepository.findByProduct(product));;
		resp.setMessage("DISPLAYED WITH Success");
		return resp;
	}
	
	
	public List<Product> getProductsByCategory(Long id){
		Category category = categoryRepository.findById(id).orElse(null);
		return productRepository.findByCategory(category);
		
	}
	
	public ReviewReq addReview(Long id,@RequestBody ReviewReq rev) {
		ReviewReq resp = new ReviewReq();
		Product product = productRepository.findById(id).orElse(null);
		try {
			Review review = new Review();
			review.setClient(rev.getClient());
			review.setProduct(product);
			review.setComment(rev.getComment());
			review.setRating(rev.getRating());
			review.setReviewDate(rev.getReviewDate());
			resp.setMessage("Success");
	
		}
		catch(Exception e) {
			resp.setStatusCode(444);
			resp.setMessage("errror");
		}
		return resp;
	}
	
	
	
	public OrderReq createOrder(Long userId, OrderReq orderReq) {
		OrderReq response = new OrderReq();
	    // Find user by ID
	    User user = userRepository.findById(userId)
	            .orElseThrow(() -> new RuntimeException("User not found"));

	    // Create new Order instance
	    Order order = new Order();
	    order.setClient(user);
	    order.setStatus("Pending");
	    order.setTotalAmount(orderReq.getTotalAmount());
	    order.setOrderDate(orderReq.getOrderDate());
	    order.setUser(order.getUser());
	    response.setMessage("With Success");

	    // Assuming orderReq contains order items (adjust as necessary)
	    for (OrderItem orderItemReq : orderReq.getOrderItems()) {
	        OrderItem orderItem = new OrderItem();
	        orderItem.setProduct(orderItemReq.getProduct());
	        orderItem.setQuantity(orderItemReq.getQuantity());
	        response.setStatusCode(200);
	        orderItem.setOrder(order);

	        orderItemRepository.save(orderItem);
	    }

	    // Persist the order
	    orderRepository.save(order);

	    // Return the created order
	  
	    return response;
	}
	
}
