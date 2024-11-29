package br.com.paulobof.productcatalog.application.usecases.product;

import br.com.paulobof.productcatalog.application.gateway.IProductRepository;
import br.com.paulobof.productcatalog.domain.entities.Product;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CreateProduct {

    private final IProductRepository productRepository;

    public Product createProduct(Product product) {
        return productRepository.createProduct(product);
    }

}
