package org.sid.inventoryservice;

import org.sid.inventoryservice.entity.Product;
import org.sid.inventoryservice.repositories.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

@SpringBootApplication
public class InventoryServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(InventoryServiceApplication.class, args);
	}

	@Bean
	CommandLineRunner start(ProductRepository productRepository, RepositoryRestConfiguration restConfiguration){
		return args -> {
			restConfiguration.exposeIdsFor(Product.class);
			//save products
			/*
			productRepository.save(new Product(null,"HP 234",8000));
			productRepository.save(new Product(null,"LENOVO Z50 70",4500));
			productRepository.save(new Product(null,"Dell Core",3000));
			*/
			//display products
			productRepository.findAll().forEach(System.out::println);
		};
	}
}
