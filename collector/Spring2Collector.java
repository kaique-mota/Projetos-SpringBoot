package br.org.generation.spring2.collector;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RequestMapping("/spring2")
@RestController
public class Spring2Collector {

	@GetMapping
	public String spring2() {
		return "aprender spring";
	}
}
