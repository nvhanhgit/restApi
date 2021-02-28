package com.dhtbank.Controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.server.EntityLinks;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.dhtbank.Model.Bill;
import com.dhtbank.Repository.BillRepository;

@RestController
@RequestMapping(path="/Bill", produces = "application/json")
@CrossOrigin("*")
public class BillController {
 private final BillRepository billRepository;
 @Autowired
 EntityLinks entityLinks;
public BillController(BillRepository billRepository) {

	this.billRepository = billRepository;
}
 @GetMapping("/bills")
 public Iterable<Bill> getAllBill()
 {
	return billRepository.findAll(); 
 }
 @GetMapping("/{id}")
 public Bill getBillById(@PathVariable("id") Long id) {
	 Optional<Bill> bill = billRepository.findById(id);
	 if(bill.isPresent()) return bill.get();
	 return null;
 }
 @PostMapping(consumes = "application/json")
 @ResponseStatus(HttpStatus.CREATED)
 public Bill saveBill(@RequestBody Bill bill)
 {
	 return billRepository.save(bill);
 }
}
