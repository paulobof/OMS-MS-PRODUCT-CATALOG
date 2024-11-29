package br.com.paulobof.productcatalog.application.usecases.product;

import br.com.paulobof.productcatalog.application.gateway.IProductRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ExistsProduct {

    private final IProductRepository productRepository;

    public boolean existsProduct(Long productCode){
        return productRepository.existsProduct(productCode);
    }

}
