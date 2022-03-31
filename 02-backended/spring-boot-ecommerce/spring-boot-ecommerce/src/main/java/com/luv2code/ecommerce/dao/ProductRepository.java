package com.luv2code.ecommerce.dao;

import com.luv2code.ecommerce.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestParam;

@CrossOrigin("http://localhost:4200")
public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query("SELECT p FROM Product p WHERE p.category.id = ?1")
    Page<Product> findByCategoryId(@RequestParam("id") Long id, Pageable pageable);

    @Query("SELECT p FROM Product p WHERE p.name LIKE CONCAT('%', :name, '%')")
    Page<Product> findByNameContaining(@RequestParam("name") String name, Pageable pageable);

//    Page<Product> findByCategoryId(@RequestParam("id") Long id, Pageable pageable);
}
