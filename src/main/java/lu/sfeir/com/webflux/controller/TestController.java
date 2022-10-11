package lu.sfeir.com.webflux.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lu.sfeir.com.webflux.model.SimpleOperation;

@RestController
@RequestMapping
public class TestController {
	@Autowired
	private SimpleOperation simpleOperation;
	
	@GetMapping(value = {"","/"})
	public String hello() {
		return "Hello";
		
	}
	@GetMapping(value = {"/add"})
	public String add(@RequestParam(value="a") Integer a,@RequestParam("b") Integer b) {
		
		return "res="+simpleOperation.add(a, b);
		
	}
	
	@GetMapping(value = {"/multiply"})
	public String multiply(@RequestParam(value="a") Long a,@RequestParam("b") Long b) {
		
		return "res="+simpleOperation.multiply(a, b);
		
	}
	
	@GetMapping("edit")
	public String edit() {
		return "edited";
	}

}
