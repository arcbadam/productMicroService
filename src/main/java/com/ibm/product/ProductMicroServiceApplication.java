package com.ibm.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import com.ibm.product.entity.Product;
import com.ibm.product.repository.ProductDAO;

@EnableEurekaClient
@EnableFeignClients
@EnableHystrix
@EnableHystrixDashboard
@SpringBootApplication
public class ProductMicroServiceApplication {
	
	@Autowired
	ProductDAO productDAO;

	public static void main(String[] args) {
		SpringApplication.run(ProductMicroServiceApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
		return args -> {

			for (int i = 1; i <= 10; i++) {
				Product product = new Product(i,"Product "+i, 100+i);
				productDAO.save(product);
			}

		};
	}
}
