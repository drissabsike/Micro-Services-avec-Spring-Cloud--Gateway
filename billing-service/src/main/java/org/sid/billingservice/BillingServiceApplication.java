package org.sid.billingservice;

import org.sid.billingservice.entity.Bill;
import org.sid.billingservice.entity.Customer;
import org.sid.billingservice.entity.Product;
import org.sid.billingservice.entity.ProductItem;
import org.sid.billingservice.projection.BillProjection;
import org.sid.billingservice.repositories.BillRepository;
import org.sid.billingservice.repositories.ProductItemRepository;
import org.sid.billingservice.service.CustomerService;
import org.sid.billingservice.service.InventoryService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.hateoas.PagedModel;

import java.util.Date;

@SpringBootApplication
@EnableFeignClients
public class BillingServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(BillingServiceApplication.class, args);
	}

	@Bean
	CommandLineRunner start(BillRepository billRepository, ProductItemRepository productItemRepository,
							RepositoryRestConfiguration configuration,
							CustomerService customerService,
							InventoryService inventoryService){
		return args -> {
			//ADD Projection
			configuration.getProjectionConfiguration().addProjection(BillProjection.class);
			//Recuperation
			Customer c1 = customerService.findCustomerById(1L);
			System.out.println("************* CustomerService. TEST***********");
			System.out.println("ID customer: "+c1.getId());
			System.out.println("Name: "+c1.getName());
			System.out.println("Email: "+c1.getEmail());
			System.out.println("***********************************************");
			Bill bill1 = billRepository.save(new Bill(null,new Date(), c1.getId(), null));

			//Recuperation all Products
			PagedModel<Product> products = inventoryService.findAllProducts();
			products.getContent().forEach(p->{
				productItemRepository.save(new ProductItem(null, p.getId(), p.getPrice(), 30, bill1));
			});

		};
	}

}
