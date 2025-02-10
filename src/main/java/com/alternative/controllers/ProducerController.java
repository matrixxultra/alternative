package com.alternative.controllers;


import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alternative.dto.ProdReq;
import com.alternative.services.ProducerService;


@RestController
@RequestMapping("/producer")
public class ProducerController {
	
	@Autowired
	private ProducerService producerService;
	

	    
	    @PostMapping("/addProduct")
	    public ResponseEntity<ProdReq> createProduct(@RequestBody ProdReq prodReq) throws IOException {

	        return ResponseEntity.ok(producerService.addProduct(prodReq));
	    }

	    // Get all products of a producer
	    @GetMapping("/myproducts")
	    public ResponseEntity<ProdReq> getMyProducts() {
	       
	        return ResponseEntity.ok(producerService.getMyProducts());
	    }

	    
	    // Update a product
	    @PutMapping("/edit/{productId}")
	    public ResponseEntity<ProdReq> updateProduct(@RequestBody ProdReq updatedProduct) {

	        return ResponseEntity.ok(producerService.updateProduct(updatedProduct));
	    }

	    // Delete a product
	    @DeleteMapping("delete/{productId}")
	    public ResponseEntity<ProdReq> deleteProduct(@PathVariable long productId) {
	    	
	    	 return ResponseEntity.ok(producerService.deleteProduct(productId));

	    
	}
	
}
