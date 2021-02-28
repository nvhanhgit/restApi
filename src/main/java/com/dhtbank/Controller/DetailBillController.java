package com.dhtbank.Controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.server.EntityLinks;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dhtbank.Model.DetailBill;
import com.dhtbank.Repository.DetailBillRepository;

@RestController
@RequestMapping(path="/detail-bill",produces = "application/json")
@CrossOrigin("*")
public class DetailBillController {
	private final DetailBillRepository detailBillRepository;
	@Autowired
    EntityLinks entityLinks;
	public DetailBillController(DetailBillRepository detailBillRepository) {
		this.detailBillRepository = detailBillRepository;
	}
    @GetMapping("/detail-bills")
    public Iterable<DetailBill> getAllDetailBill() {
    	return detailBillRepository.findAll();
    }
    @GetMapping("/{id}")
    public DetailBill getDetailBillById(@PathVariable("id") Long id) {
    	Optional<DetailBill> detailBill = detailBillRepository.findById(id);
    	if(detailBill.isPresent())
    		return detailBill.get();
    	return null;    	
    }

}
