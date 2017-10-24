package br.com.systemjmrs.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {	
	@RequestMapping("/login")
	public String loginForm () {
		return "formulario-login";
	}
	
	@RequestMapping("/") 
	public String efetuaLogin (){
		return"menu";
	}
	
}
