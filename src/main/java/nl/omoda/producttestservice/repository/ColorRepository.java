package nl.omoda.producttestservice.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import nl.omoda.producttestservice.entity.Color;

@Repository
public interface ColorRepository extends CrudRepository<Color, Long> {
}
