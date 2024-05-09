package com.springboot.TodoApp.Controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class loginController {
	private Logger logger = LoggerFactory.getLogger(getClass());
	///login => com.in28minutes.springboot.myfirstwebapp.login.LoginController => login.jsp
	
		//http://localhost:8080/login?name=Ranga
		//Model
	@RequestMapping("/login")
	public String loginPage(@RequestParam String name,ModelMap modelMap) {
		modelMap.put("name", name);
		logger.debug("request param is {}",name);
//		System.out.println("Request param is " + name); //NOT RECOMMENDED FOR PROD CODE
		return "login";
	}
}
