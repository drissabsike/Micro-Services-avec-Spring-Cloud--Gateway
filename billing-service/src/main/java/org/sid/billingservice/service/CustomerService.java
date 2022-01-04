package org.sid.billingservice.service;

import org.sid.billingservice.entity.Customer;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

//La récuperation des donnés d'un autre service par exemple "CUSTOMER-SERVICE" via le nom du service !!!
// and add @EnableFeignClients in class main
@FeignClient(name = "CUSTOMER-SERVICE")
public interface CustomerService {

    @GetMapping("/customers/{id}")
    public Customer findCustomerById(@PathVariable(name = "id") Long id);

}
