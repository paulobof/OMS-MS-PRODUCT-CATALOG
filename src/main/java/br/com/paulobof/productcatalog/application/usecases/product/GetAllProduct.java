package br.com.paulobof.productcatalog.application.usecases.product;

import br.com.paulobof.productcatalog.application.gateway.IProductRepository;
import br.com.paulobof.productcatalog.domain.entities.Product;
import lombok.RequiredArgsConstructor;

import java.util.List;


@RequiredArgsConstructor
public class GetAllProduct {

    private final IProductRepository productRepository;

    public List<Product> getAllProduct() {
        return productRepository.getAllProduct();
    }

}
