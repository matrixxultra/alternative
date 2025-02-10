package com.alternative.repositories;


import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.alternative.entities.User;
import com.alternative.entities.Category;
import com.alternative.entities.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

	List<Product> findByUser(User user);
	List<Product> findByCategory(Category categorie);
}
