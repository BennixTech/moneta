package com.bennixtech.moneta;

import io.hypersistence.utils.hibernate.type.money.MonetaryAmountType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CompositeType;

import javax.money.MonetaryAmount;

@Getter
@Setter
@Entity
@Table(name = "product_pricing")
public class ProductPricing {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private Product product;

    private String name;

    @Enumerated(EnumType.STRING)
    private PricingType type;

    @AttributeOverride(
            name = "amount",
            column = @Column(name = "price_amount")
    )
    @AttributeOverride(
            name = "currency",
            column = @Column(name = "price_currency")
    )
    @SuppressWarnings("JpaAttributeTypeInspection")
    @CompositeType(MonetaryAmountType.class)
    private MonetaryAmount price;
}