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
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.dhtbank.Model.Product;
import com.dhtbank.Repository.ProductRepository;

@RestController
@RequestMapping(path="/product",produces = "application/json")
@CrossOrigin("*")
public class ProductController {
	ProductRepository productRepository;
	@Autowired
	EntityLinks entityLinks;
	public ProductController(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}
	@GetMapping("/{id}")
	public Product productById(@PathVariable("id") Long id)
	{
		Optional<Product> product = productRepository.findById(id);
		if(product.isPresent())
		{
			return product.get();
		}
		return null;
	}
	@GetMapping("/products")
	public Iterable<Product> getAllProduct(){
		return productRepository.findAll();
	}
	@PostMapping(consumes = "application/json")
	@ResponseStatus(HttpStatus.CREATED)
	public Product saveProduct(@RequestBody Product product)
	{
		return productRepository.save(product);
	}

}
