package org.sid.billingservice.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@ToString
public class ProductItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Long productID;
    private double price;
    private double quantity;

    @Transient
    private Product product;

    @ManyToOne
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Bill bill;

    public ProductItem(Long id, Long productID, double price, double quantity, Bill bill) {
        this.id = id;
        this.productID = productID;
        this.price = price;
        this.quantity = quantity;
        this.bill = bill;
    }



}
