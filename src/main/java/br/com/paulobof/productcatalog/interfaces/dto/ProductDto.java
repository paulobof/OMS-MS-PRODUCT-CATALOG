package br.com.paulobof.productcatalog.interfaces.dto;


import lombok.Builder;

import java.math.BigDecimal;

@Builder
public record ProductDto(

        Long productCode,
        String name,
        String description,
        BigDecimal price

) { }
