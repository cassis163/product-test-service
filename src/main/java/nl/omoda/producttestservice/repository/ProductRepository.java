package nl.omoda.producttestservice.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import nl.omoda.producttestservice.entity.Product;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {
}
