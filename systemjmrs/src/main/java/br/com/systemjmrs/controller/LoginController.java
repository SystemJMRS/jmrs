package br.com.systemjmrs.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {	
	@RequestMapping("/login")
	public String loginForm () {
		return "login";
	}
	
	@RequestMapping("/") 
	public String home (){
		return"pagina-inicial";
	}
	
	//Teste*****
	@RequestMapping("/primeiro-acesso") 
	public String primeiroAcesso (){
		return"primeiro-acesso";
	}
	
}
