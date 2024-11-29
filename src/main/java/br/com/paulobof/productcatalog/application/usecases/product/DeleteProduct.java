package br.com.paulobof.productcatalog.application.usecases.product;

import br.com.paulobof.productcatalog.application.gateway.IProductRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class DeleteProduct {

    private final IProductRepository productRepository;

    public void deleteProduct(Long productCode){
        productRepository.deleteProduct(productCode);
    }
}
