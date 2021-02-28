package com.dhtbank.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dhtbank.Model.Customer;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Long> {

}
