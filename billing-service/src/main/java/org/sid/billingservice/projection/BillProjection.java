package org.sid.billingservice.projection;

import org.sid.billingservice.entity.*;
import org.springframework.data.rest.core.config.Projection;
import java.util.*;

@Projection(name = "fullBill", types = { Bill.class })
public interface BillProjection {
    public Long getId();
    public Date getBillingDate();
    public Long getCustomerID();
    public Collection<ProductItem> getProductItems();
}
