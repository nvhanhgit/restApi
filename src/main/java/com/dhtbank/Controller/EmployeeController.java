package com.dhtbank.Controller;

import java.util.Optional;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.server.EntityLinks;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.dhtbank.Model.Employee;
import com.dhtbank.Model.Product;
import com.dhtbank.Repository.EmployeeRepository;
import com.dhtbank.Repository.ProductRepository;



@RestController
@RequestMapping(path="/employee", produces = "application/json")
@CrossOrigin("*")
public class EmployeeController {
	private final EmployeeRepository employeeRepository;
	private final ProductRepository productReopsitory;
    @Autowired
    EntityLinks entityLinks;
	public EmployeeController(EmployeeRepository employeeRepository,ProductRepository productRepository) {
		this.employeeRepository = employeeRepository;
		this.productReopsitory  = productRepository;
	} 
    @PostMapping(path="/login", consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public Employee loginEmployee(@RequestBody Employee employee)
    {
    	return employeeRepository.findEmployeeByUserNameAndPassword(employee.getUserName(), employee.getPassWord());
    }
}
