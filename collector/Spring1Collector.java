package br.org.generation.spring1.collector;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RequestMapping("/spring1")
@RestController
public class Spring1Collector {
 
	@GetMapping
	public String spring1() {
		return "mentalidade de crescismento e persistência";
	}
	
}
