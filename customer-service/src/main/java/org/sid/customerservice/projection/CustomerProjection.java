package org.sid.customerservice.projection;

import org.sid.customerservice.entity.Customer;
import org.springframework.data.rest.core.config.Projection;

//pour spécifié si vous voullez envoyé juste id et name...
@Projection(name = "p1", types = { Customer.class })
public interface CustomerProjection {
    //public Long getId();
    public String getName();
}
