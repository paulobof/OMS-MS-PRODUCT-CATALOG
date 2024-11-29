package br.com.paulobof.productcatalog.infra.persistence.repository.mapper;

import br.com.paulobof.productcatalog.domain.entities.Product;
import br.com.paulobof.productcatalog.infra.persistence.entities.ProductEntity;

public class ProductMapper {

    public ProductEntity toEntity(Product product) {
        return new ProductEntity(
                product.getDescription(),
                product.getName(),
                product.getPrice()
        );
    }

    public Product toProduct(ProductEntity productEntity) {
        return new Product(
                productEntity.getProductCode(),
                productEntity.getName(),
                productEntity.getDescription(),
                productEntity.getPrice()
        );
    }

}
