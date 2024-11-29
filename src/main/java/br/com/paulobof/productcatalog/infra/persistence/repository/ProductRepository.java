package br.com.paulobof.productcatalog.infra.persistence.repository;


import br.com.paulobof.productcatalog.infra.persistence.entities.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProductRepository extends JpaRepository<ProductEntity, Long> {
    Optional<ProductEntity> getByProductCode(Long productCode);


}
