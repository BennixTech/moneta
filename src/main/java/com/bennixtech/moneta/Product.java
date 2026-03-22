package com.bennixtech.moneta;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "product")
public class Product {
 
    @Id
    private Long id;
 
    private String name;
 
    @OneToMany(
        mappedBy = "product",
        cascade = CascadeType.ALL,
        orphanRemoval = true
    )
    private List<ProductPricing> pricingPlans = new ArrayList<>();
 
    public void addPricingPlan(ProductPricing pricingPlan) {
        pricingPlans.add(pricingPlan);
        pricingPlan.setProduct(this);
    }
}