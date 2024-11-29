package br.com.paulobof.productcatalog.application.usecases.product;

import br.com.paulobof.productcatalog.application.gateway.IProductRepository;
import br.com.paulobof.productcatalog.domain.entities.Product;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class UpdateProduct {

    private final IProductRepository productRepository;

    public Product updateProduct(Long productCode, Product product){
        return productRepository.updateProduct(productCode, product);
    }
}
