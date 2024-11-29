package br.com.paulobof.productcatalog.application.exception;

public class ProductNotFoundException extends RuntimeException {
    public ProductNotFoundException(Long productCode) {
        super("Product with code " + productCode + " was not found");
    }
}
