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
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.dhtbank.Model.Customer;
import com.dhtbank.Repository.CustomerRepository;

@RestController
@RequestMapping(path="/customer",produces = "application/json")
@CrossOrigin("*")
public class CustomerController {
	CustomerRepository customerRepository;
	@Autowired
	EntityLinks entityLinks;
	public CustomerController(CustomerRepository customerRepository) {
		this.customerRepository = customerRepository;
	}
	@GetMapping(path="/{id}")
	public Customer customerById(@PathVariable("id") Long id)
	{
		Optional<Customer> customer=customerRepository.findById(id);
		if(customer.isPresent())
		{
			return customer.get();
		}
		return null;
		
	}
	@GetMapping("/customers")
	public Iterable<Customer> getAllCustomer(){
		return customerRepository.findAll();
	}
    @PostMapping(consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public Customer saveCustomer(@RequestBody Customer customer)
    {
    	return customerRepository.save(customer);
    }
}
