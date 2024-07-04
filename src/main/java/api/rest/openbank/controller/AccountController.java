package api.rest.openbank.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class AccountController {
	@GetMapping("")
	public String testMethod() {
		return "openBank test api : Response ok";
	}
}
