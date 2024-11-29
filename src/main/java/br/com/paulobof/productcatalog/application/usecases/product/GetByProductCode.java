package br.com.paulobof.productcatalog.application.usecases.product;

import br.com.paulobof.productcatalog.application.gateway.IProductRepository;
import br.com.paulobof.productcatalog.domain.entities.Product;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class GetByProductCode {

    private final IProductRepository customerRepository;

    public Product getByProductCode(Long customerCode){
        return customerRepository.getByProductCode(customerCode);
    }
}
