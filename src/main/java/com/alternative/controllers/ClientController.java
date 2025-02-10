package com.alternative.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alternative.dto.OrderReq;
import com.alternative.dto.ProdReq;
import com.alternative.dto.ReviewReq;
import com.alternative.entities.Product;
import com.alternative.services.ClientService;



@RestController
@RequestMapping("/user")
public class ClientController {

	@Autowired
	private ClientService clientService;
	
	@GetMapping("/index")
	public ResponseEntity<List<Product>> getProducts(){
		
		return new ResponseEntity<List<Product>>(clientService.getAllProducts(), HttpStatus.OK);
	}
	
	@GetMapping("/product/{id}")
	public ResponseEntity<ProdReq> getProduct(@PathVariable Long id) {
		return ResponseEntity.ok(clientService.getProduct(id));
	} 
	
	
	@PostMapping("/ajouterReview/{id}")
	public ResponseEntity<ReviewReq> addReview(@PathVariable Long id,@RequestBody ReviewReq rev){
		return ResponseEntity.ok(clientService.addReview(id,rev));
	}

	

	@PostMapping("/create/{id}")
	public ResponseEntity<OrderReq> validerOrder(@PathVariable Long id , @RequestBody OrderReq orderReq){
		return ResponseEntity.ok(clientService.createOrder(id,orderReq));
	}
	
}
