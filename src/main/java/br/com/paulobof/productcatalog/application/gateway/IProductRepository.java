package br.com.paulobof.productcatalog.application.gateway;

import br.com.paulobof.productcatalog.domain.entities.Product;

import java.util.List;

public interface IProductRepository {

    Product createProduct(Product productEntity);

    List<Product> getAllProduct();

    Product getByProductCode(Long productCode);

    Product updateProduct(Long productCode, Product productEntity);

    void deleteProduct(Long productCode);

    Boolean existsProduct(Long productCode);
}
