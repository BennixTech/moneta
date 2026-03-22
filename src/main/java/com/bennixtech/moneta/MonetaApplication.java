package com.bennixtech.moneta;

import org.javamoney.moneta.Money;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import javax.money.MonetaryAmount;
import java.math.BigDecimal;

@SpringBootApplication
public class MonetaApplication {

    static void main(String[] args) {
        SpringApplication.run(MonetaApplication.class, args);
    }

    @Bean
    CommandLineRunner runner(ProductRepository productRepository) {

        ProductPricing pricing1 = new ProductPricing();
        pricing1.setName("Individual License");
        pricing1.setType(PricingType.SUBSCRIPTION);
        pricing1.setPrice(Money.of(new BigDecimal("49.0"), "KES"));

        ProductPricing pricing2 = new ProductPricing();
        pricing2.setName("5-Year Individual License");
        pricing2.setType(PricingType.ONE_TIME_PURCHASE);
        pricing2.setPrice(Money.of(new BigDecimal("199.0"), "KES"));

        return _ -> {
            Product product = new Product();
            product.setId(1L);
            product.setName("Persistence Optimizer");
            product.addPricingPlan(pricing1);
            product.addPricingPlan(pricing2);

            MonetaryAmount amount = pricing1.getPrice().add(pricing2.getPrice());
            System.out.println("Total price: " + amount);
            System.out.println("Currency: " + amount.getCurrency().getCurrencyCode());
            System.out.println("Amount: " + amount.getNumber().doubleValue());


            productRepository.save(product);
        };
    }

}
