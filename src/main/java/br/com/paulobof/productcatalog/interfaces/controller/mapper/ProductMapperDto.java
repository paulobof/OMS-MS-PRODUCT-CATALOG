package br.com.paulobof.productcatalog.interfaces.controller.mapper;

import br.com.paulobof.productcatalog.domain.entities.Product;
import br.com.paulobof.productcatalog.interfaces.dto.ProductDto;

public class ProductMapperDto {

    public static ProductDto toProductDto(Product product) {
        return new ProductDto(
                product.getProductCode(),
                product.getName(),
                product.getDescription(),
                product.getPrice()
                );
    }
}

