package br.com.paulobof.productcatalog.infra.persistence.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Entity(name = "product")
@Table(name = "products")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class ProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productCode;

    private  String name;

    private  String description;

    private BigDecimal price;

    public ProductEntity(String name, String description, BigDecimal  price) {
        this.name = name;
        this.description = description;
        this.price = price;
    }
}
