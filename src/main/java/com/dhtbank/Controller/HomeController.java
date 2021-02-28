package com.dhtbank.Controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/employee", produces ="application/json")
@CrossOrigin(origins = "*")
public class HomeController {

}
