package com.ibm.product.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibm.product.entity.Product;
import com.ibm.product.repository.ProductDAO;

@Service
public class ProductService {
	
	@Autowired
	ProductDAO productDAO;

	public List<Product> getAllProducts() {
		return productDAO.findAll();
	}
	
	public Product getProduct(int productId) {
		Optional<Product> products = productDAO.findById(productId);
		Product product  = null;
		System.out.println("In Productms- getproduct:"+product);
		if (products != null && products.isPresent() ){
			product = products.get();
		}
		return product;
	}

}
