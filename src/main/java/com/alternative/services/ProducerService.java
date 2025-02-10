package com.alternative.services;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.alternative.dto.OrderReq;
import com.alternative.dto.ProdReq;
import com.alternative.entities.Category;
import com.alternative.entities.Product;
import com.alternative.entities.User;
import com.alternative.repositories.CategoryRepository;
import com.alternative.repositories.ProductRepository;
import com.alternative.repositories.UserRepository;

import jakarta.transaction.Transactional;



@Service
public class ProducerService {

	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;
	@Autowired
	private UserRepository userRepository;
	
	
	public ProdReq getMyProducts() {
		ProdReq resp = new ProdReq();
		List<Product> products = productRepository.findAll();
		resp.setProducts(products);
		resp.setMessage("Fetched");
		resp.setStatusCode(200);
        return resp;
        
	}
	 @Transactional
	public ProdReq addProduct(ProdReq productDTO) throws IOException {
		ProdReq resp = new ProdReq();
		try {
			Product product = new Product();
			
			User user = userRepository.findById(productDTO.getProducer()).orElse(null); 
			Category category = categoryRepository.findById(productDTO.getCategory()).orElse(null);
			
	        product.setName(productDTO.getName());
	        product.setDescription(productDTO.getDescription());
	        product.setCategory(category);
	        product.setQuantityInStock(productDTO.getQuantityInStock());
	        product.setUser(user);
	        //product.setImage(productDTO.getImage().getBytes());
	        productRepository.save(product);
	        
		}
		catch(Exception e) {
			resp.setStatusCode(300);
			resp.setError("Somthing Went Wrong" + e.getMessage());
		}
       
		return resp;
    }
	public ProdReq updateProduct(ProdReq productDTO) {
		ProdReq resp = new ProdReq();
		try {
			Product product = new Product();
			User user = userRepository.findById(productDTO.getProducer()).orElse(null); 
			Category category = categoryRepository.findById(productDTO.getCategory()).orElse(null);
			System.out.println(user);
			System.out.println(category);
	        product.setName(productDTO.getName());
	        product.setDescription(productDTO.getDescription());
	        product.setCategory(category);
	        product.setQuantityInStock(productDTO.getQuantityInStock());
	        product.setUser(user);
	       // product.setImage(productDTO.getImage().getBytes());
	        productRepository.save(product);
		}
		catch(Exception e) {
			resp.setStatusCode(300);
			resp.setError("Somthing Went Wrong");
		}
		return resp;
	}
	
	public ProdReq deleteProduct(Long id) {
		ProdReq resp = new ProdReq();
		productRepository.deleteById(id);
		resp.setMessage("Deleted With Success");
		resp.setStatusCode(200);
		return resp;
	}
	
	public OrderReq getOrders(@RequestBody Long id){
		OrderReq resp = new OrderReq();
		
		return resp;
	}

	
	
}
