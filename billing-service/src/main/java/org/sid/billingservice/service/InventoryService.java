package org.sid.billingservice.service;

import org.sid.billingservice.entity.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.hateoas.PagedModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Collection;

@FeignClient(name = "INVENTORY-SERVICE")
public interface InventoryService {

    @GetMapping("/products/{id}")
    public Product findProductById(@PathVariable(name = "id") Long id);

    @GetMapping("/products") //Collection<Product> don't work for me
    public PagedModel<Product> findAllProducts();

}
