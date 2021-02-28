package com.dhtbank.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dhtbank.Model.Bill;

@Repository
public interface BillRepository extends CrudRepository<Bill, Long>{
 
}
