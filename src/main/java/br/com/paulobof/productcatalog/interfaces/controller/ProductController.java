package br.com.paulobof.productcatalog.interfaces.controller;

import br.com.paulobof.productcatalog.application.usecases.product.*;
import br.com.paulobof.productcatalog.application.usecases.product.DeleteProduct;
import br.com.paulobof.productcatalog.domain.entities.Product;
import br.com.paulobof.productcatalog.interfaces.controller.mapper.ProductMapperDto;
import br.com.paulobof.productcatalog.interfaces.dto.ProductDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/product")
@RequiredArgsConstructor
public class ProductController {

    private final CreateProduct createProductUseCase;
    private final GetByProductCode getByProductCodeUseCase;
    private final GetAllProduct getAllProductUseCase;
    private final UpdateProduct updateProductUseCase;
    private final DeleteProduct deleteProductUseCase;
    /*
    private final ExistsProduct existsProductUseCase;*/

    @PostMapping
    public ResponseEntity<ProductDto> createProduct (
            @RequestBody ProductDto productDto) {

        Product product = createProductUseCase.createProduct(
                new Product(productDto.name(), productDto.description(), productDto.price()));

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new ProductDto(product.getProductCode(), productDto.name(), product.getDescription(), product.getPrice()));
    }

    @GetMapping("/{productCode}")
    public ResponseEntity<ProductDto> getByProductCode (
            @PathVariable Long productCode) {

        Product product = getByProductCodeUseCase.getByProductCode(productCode);
        ProductDto  productDto = ProductMapperDto.toProductDto(product);

        return ResponseEntity.status(HttpStatus.OK).body(productDto);
    }

    @GetMapping
    public ResponseEntity<List<ProductDto>> getAllProduct() {

        List<Product> products = getAllProductUseCase.getAllProduct();
        List<ProductDto> productDtos = products.stream()
                .map(ProductMapperDto::toProductDto)
                .collect(Collectors.toList());

        return ResponseEntity.status(HttpStatus.OK).body(productDtos);
    }

    @PutMapping("/{productCode}")
    public ResponseEntity<ProductDto> updateProduct(
            @PathVariable Long productCode,
            @RequestBody Product product) {

        Product updatedProduct = updateProductUseCase.updateProduct(productCode, product);
        ProductDto updatedProductDto = ProductMapperDto.toProductDto(updatedProduct);

        return ResponseEntity.status(HttpStatus.OK).body(updatedProductDto);
    }

    @DeleteMapping("/{productCode}")
    public ResponseEntity<String> deleteProduct(
            @PathVariable Long productCode) {

        deleteProductUseCase.deleteProduct(productCode);

        return ResponseEntity.status(HttpStatus.OK).body("");
    }
}
