package br.com.paulobof.productcatalog.domain.entities;

import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class Product {
    
    private Long productCode;
    private String name;
    private String description;
    private BigDecimal price;

    public Product(Long productCode, String name, String description, BigDecimal  price) {
        this.productCode = productCode;
        this.name = name;
        this.description = description;
        this.price = price;

    }

    public Product(String name, String description, BigDecimal  price) {
        this.name = name;
        this.description = description;
        this.price = price;
    }
}
