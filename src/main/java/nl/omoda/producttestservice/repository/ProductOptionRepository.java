package nl.omoda.producttestservice.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import nl.omoda.producttestservice.entity.ProductOption;

@Repository
public interface ProductOptionRepository extends CrudRepository<ProductOption, Long> {
}
