package com.alternative.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alternative.dto.CategoryReq;
import com.alternative.dto.UserReq;
import com.alternative.entities.Category;
import com.alternative.entities.User;
import com.alternative.services.AdminService;
import com.alternative.services.CategoryService;



@RestController
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	private AdminService adminService;
	@Autowired
	private CategoryService categoryService;
	
	@GetMapping("/producteurs")
    public ResponseEntity<UserReq> getProducers(){
		return ResponseEntity.ok(adminService.getProducers());    
    }
	
	@GetMapping("/producteurs/{id}")
    public ResponseEntity<UserReq> getProducer(@PathVariable Long id){
		
        return ResponseEntity.ok(adminService.getProducer(id));

    }
	@GetMapping("/producteurs/{id}/products")
    public ResponseEntity<UserReq> getProductsByProducer(@PathVariable Long id){
        return ResponseEntity.ok(adminService.getProducts(id));

    }
	
	@PutMapping("/producteur/{id}")
	 public ResponseEntity<UserReq> updateProducer(@PathVariable Long id,@RequestBody UserReq req){
       return ResponseEntity.ok(adminService.updateUser(id,req));

   }
	@GetMapping("/clients")
	 public ResponseEntity<UserReq> getClients(){
        return ResponseEntity.ok(adminService.getClients());

    }

	@GetMapping("/clients/{id}")
	 public ResponseEntity<UserReq> getClient(@PathVariable Long id){
       return ResponseEntity.ok(adminService.getClient(id));

    }
	@PutMapping("/client/{id}")
	 public ResponseEntity<UserReq> updateClient(@PathVariable Long id,@RequestBody UserReq req){
      return ResponseEntity.ok(adminService.updateUser(id,req));

  }
	
	
	@DeleteMapping("/clients/{id}")
	 public ResponseEntity<UserReq> deleteClient(@PathVariable Long id){
       return ResponseEntity.ok(adminService.deleteUser(id));

    }
	
	@GetMapping("/categories")
	public ResponseEntity<CategoryReq> getCategories(){
		 return ResponseEntity.ok(categoryService.getCategories());
	}
	@GetMapping("/categories/{id}")
	public ResponseEntity<CategoryReq> getCategory(@PathVariable Long id){
		 return ResponseEntity.ok(categoryService.getCategory(id));
	}
	@PostMapping("/categories")
	public ResponseEntity<CategoryReq> addCategory(@RequestBody CategoryReq categoryReq ){
		 return ResponseEntity.ok(categoryService.addCategory(categoryReq));
	}
	@PutMapping("/categories/{id}")
	public ResponseEntity<CategoryReq> updateCategory(@PathVariable Long id,@RequestBody CategoryReq categoryReq ){
		 return ResponseEntity.ok(categoryService.updateCategory(id,categoryReq));
	}
	
	@DeleteMapping("/categories/{id}")
	public ResponseEntity<CategoryReq> deleteCategories(@PathVariable Long id){
		 return ResponseEntity.ok(categoryService.deleteCategory(id));
	}
	
	
	

}
