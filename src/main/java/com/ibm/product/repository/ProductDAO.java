package com.ibm.product.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.ibm.product.entity.Product;


@Component
public interface ProductDAO extends JpaRepository<Product, Integer> {

}
