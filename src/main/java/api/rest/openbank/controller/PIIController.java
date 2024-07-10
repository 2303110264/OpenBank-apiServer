package api.rest.openbank.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import api.rest.openbank.pii.service.PIIService;
import api.rest.openbank.pii.vo.PIIVO;

@RestController
@RequestMapping("/")
public class PIIController {
	
	@Autowired
	PIIService ps;
	
	@GetMapping("test")
	public String testMethod() {
		return "openBank test api : Response ok";
	}
	
	@PostMapping("addUser")
	public String addUser(PIIVO pii) {
		ps.insertPII(pii);
		return "";
	}
}
