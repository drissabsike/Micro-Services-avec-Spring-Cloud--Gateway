package org.sid.customerservice;

import org.sid.customerservice.entity.Customer;
import org.sid.customerservice.projection.CustomerProjection;
import org.sid.customerservice.repositories.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

@SpringBootApplication
public class CustomerServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomerServiceApplication.class, args);
	}

	@Bean
	CommandLineRunner start(CustomerRepository customerRepository, RepositoryRestConfiguration restConfiguration){
		return args -> {
			// pour afficher ID de chaque Customer sur la page WEB
			restConfiguration.exposeIdsFor(Customer.class);

			//pour spécifié si vous voullez envoyé juste id et name...
			restConfiguration.getProjectionConfiguration().addProjection(CustomerProjection.class);

			// Ajouter des Customers
			/*
			customerRepository.save(new Customer(null,"Driss","absike30@gmail.com"));
			customerRepository.save(new Customer(null,"Hanane","Hanane@gmail.com"));
			customerRepository.save(new Customer(null,"Hassan","Hassan@gmail.com"));
			*/
			//pour tésté l'affichage
			customerRepository.findAll().forEach(System.out::println);
		};
	}

}
