package br.com.paulobof.productcatalog.infra.config;

import br.com.paulobof.productcatalog.application.gateway.IProductRepository;
import br.com.paulobof.productcatalog.application.usecases.product.*;
import br.com.paulobof.productcatalog.infra.persistence.repository.mapper.ProductMapper;
import br.com.paulobof.productcatalog.infra.gateways.ProductRepositoryImpl;
import br.com.paulobof.productcatalog.infra.persistence.repository.ProductRepository;
import br.com.paulobof.productcatalog.interfaces.controller.mapper.ProductMapperDto;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackages = "br.com.paulobof.productcatalog.infra.persistence.repository")
public class ProductConfig {

    @Bean
    CreateProduct createOrder(IProductRepository productRepository) {
        return new CreateProduct(productRepository);
    }

    @Bean
    GetByProductCode getOrderById(IProductRepository productRepository) {
        return new GetByProductCode(productRepository);
    }

    @Bean
    GetAllProduct getAllOrder(IProductRepository productRepository) {
        return new GetAllProduct(productRepository);
    }

    @Bean
    UpdateProduct updateOrder(IProductRepository productRepository) {
        return new UpdateProduct(productRepository);
    }
    @Bean
    DeleteProduct deleteOrder(IProductRepository productRepository) {
        return new DeleteProduct(productRepository);
    }

    @Bean
    ProductRepositoryImpl customOrderRepositoryImpl (ProductRepository productRepository, ProductMapper productEntityMapper, ProductMapperDto productMapperDto) {
        return new ProductRepositoryImpl(productRepository, productEntityMapper, productMapperDto);
    }

    @Bean
    ProductMapper productMapper() {
        return new ProductMapper();
    }
    @Bean
    public ProductMapperDto productMapperDto() {
        return new ProductMapperDto();
    }

}

