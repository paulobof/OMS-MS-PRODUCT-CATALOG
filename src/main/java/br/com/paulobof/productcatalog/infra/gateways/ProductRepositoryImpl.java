package br.com.paulobof.productcatalog.infra.gateways;

import br.com.paulobof.productcatalog.application.gateway.IProductRepository;
import br.com.paulobof.productcatalog.domain.entities.Product;
import br.com.paulobof.productcatalog.infra.persistence.repository.mapper.ProductMapper;
import br.com.paulobof.productcatalog.infra.persistence.entities.ProductEntity;
import br.com.paulobof.productcatalog.infra.persistence.repository.ProductRepository;
import br.com.paulobof.productcatalog.interfaces.controller.mapper.ProductMapperDto;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class ProductRepositoryImpl implements IProductRepository {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;
    private final ProductMapperDto productMapperDto;

    public Product createProduct(Product product) {
        ProductEntity productEntity = productMapper.toEntity(product);
        return productMapper.toProduct(productRepository.save(productEntity));
    }

    public Product getByProductCode(Long productCode) {
        ProductEntity productEntity = productRepository.findById(productCode)
                .orElseThrow( () -> new EntityNotFoundException("Product not found"));
        return productMapper.toProduct(productEntity);
    }

    public List<Product> getAllProduct() {
        List<ProductEntity> products  = productRepository.findAll();
        return products.stream()
                .map(productMapper::toProduct)
                .collect(Collectors.toList());
    }

    public Product updateProduct(Long productCode, Product product) {
        ProductEntity productEntity = productMapper.toEntity(product);
        productEntity.setProductCode(productCode);
        ProductEntity updatedEntity = productRepository.save(productEntity);
        return productMapper.toProduct(updatedEntity);
    }

    public void deleteProduct(Long productCode) {
        productRepository.deleteById(productCode);
    }

    public  Boolean existsProduct(Long productCode) {
        return productRepository.existsById(productCode);
    }
    
}
