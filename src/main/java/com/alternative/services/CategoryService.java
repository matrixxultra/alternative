package com.alternative.services;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alternative.dto.CategoryReq;
import com.alternative.entities.Category;
import com.alternative.repositories.CategoryRepository;

@Service
public class CategoryService {

	@Autowired
	private CategoryRepository categoryRepository;
	
	public CategoryReq getCategories(){
		CategoryReq resp = new CategoryReq();
		/*
		Category category = categoryRepository.findById(categoryId)
                .orElseThrow(() -> new RuntimeException("Category not found"));

        List<ProductResponseDTO> productDTOs = category.getProducts().stream()
                .map(product -> {
                    ProductResponseDTO productDTO = new ProductResponseDTO();
                    productDTO.setId(product.getId());
                    productDTO.setName(product.getName());
                    productDTO.setDescription(product.getDescription());
                    productDTO.setPrice(product.getPrice());
                    productDTO.setQuantityInStock(product.getQuantityInStock());
                    // Handle image conversion if needed
                    productDTO.setImage(null);  // For simplicity, set to null for now
                    return productDTO;
                })
                .collect(Collectors.toList());

        CategoryResponseDTO categoryDTO = new CategoryResponseDTO();
        categoryDTO.setId(category.getId());
        categoryDTO.setName(category.getName());
        categoryDTO.setDescription(category.getDescription());
        categoryDTO.setProducts(productDTOs);
		/*
		CategoryReq resp = new CategoryReq();
		
		resp.setMessage("FETCHED");
		resp.setCategories(categoryRepository.findAll())
		
		*/
		return resp;
		
	}
	public CategoryReq getCategory(Long id){
		CategoryReq resp = new CategoryReq();
		
		resp.setCategory(categoryRepository.findById(id).orElse(null));
		resp.setMessage("With Success");
		/*
		resp.setMessage("FETCHED");
		resp.setCategories(categoryRepository.findAll())*/
		
		
		return resp;
		
	}
	
	
	public CategoryReq addCategory(CategoryReq categoryReq){
		CategoryReq resp = new CategoryReq();
		try {
			Category category = new Category();
			category.setName(categoryReq.getName());
			category.setDescription(categoryReq.getDescription());
			
			
			categoryRepository.save(category);
			resp.setStatusCode(200);;
			resp.setMessage("Added with Success");
		}
		catch(Exception e) {
			resp.setStatusCode(500);;
			resp.setMessage("Somthing went Wrong");
		}
		return resp;
	}
	
	public CategoryReq updateCategory(Long id , CategoryReq categoryReq ){
		CategoryReq resp = new CategoryReq();
		try {
			Category category = categoryRepository.findById(id).orElse(null);
			category.setName(categoryReq.getName());
			category.setDescription(categoryReq.getDescription());
			category.setProducts(categoryReq.getProducts());
			
			categoryRepository.save(category);
			resp.setStatusCode(200);;
			resp.setMessage("Updated with Success");
		}
		catch(Exception e) {
			resp.setStatusCode(500);;
			resp.setMessage("Somthing went Wrong");
		}
		return resp;
	}
	
	public CategoryReq deleteCategory(Long id){
		 CategoryReq resp = new CategoryReq();
		 categoryRepository.deleteById(id);
		 resp.setStatusCode(200);
		 resp.setMessage("DELETED WITH SUCCESS");
		 return resp;
	}
}
