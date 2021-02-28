package com.dhtbank.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dhtbank.Model.DetailBill;

@Repository
public interface DetailBillRepository extends CrudRepository<DetailBill, Long>{

}
