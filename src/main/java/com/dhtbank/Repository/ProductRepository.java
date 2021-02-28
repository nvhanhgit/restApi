package com.dhtbank.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dhtbank.Model.Product;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {

}
