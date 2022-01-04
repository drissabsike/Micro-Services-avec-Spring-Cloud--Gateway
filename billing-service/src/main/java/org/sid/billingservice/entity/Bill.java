package org.sid.billingservice.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import javax.persistence.*;
import java.util.*;

@Entity
@Data
@NoArgsConstructor
@ToString
public class Bill {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date billingDate;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Long customerID;

    @Transient //pas entité
    private Customer customer;

    @OneToMany(mappedBy = "bill")
    private Collection<ProductItem> productItems;


    public Bill(Long id, Date billingDate, Long customerID, Collection<ProductItem> productItems) {
        this.id = id;
        this.billingDate = billingDate;
        this.customerID = customerID;
        this.productItems = productItems;
    }
}
