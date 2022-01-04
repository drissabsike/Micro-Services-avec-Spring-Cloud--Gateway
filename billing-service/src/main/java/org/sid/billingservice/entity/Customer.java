package org.sid.billingservice.entity;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Customer {

    private Long id;
    private String name;
    private String email;

}
