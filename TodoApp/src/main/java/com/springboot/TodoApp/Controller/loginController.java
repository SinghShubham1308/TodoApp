package com.springboot.TodoApp.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.springboot.TodoApp.service.Authentication;

@Controller
public class loginController {

	private Authentication authentication = new Authentication();

	public loginController(Authentication authentication) {
		super();
		this.authentication = authentication;
	}

//	private Logger logger = LoggerFactory.getLogger(getClass());
	/// login => com.in28minutes.springboot.myfirstwebapp.login.LoginController =>
	/// login.jsp

	// http://localhost:8080/login?name=Ranga
	// Model
//	@RequestMapping("/login")
//	public String loginPage(@RequestParam String name,ModelMap modelMap) {
//		modelMap.put("name", name);
//		logger.debug("request param is {}",name);
////		System.out.println("Request param is " + name); //NOT RECOMMENDED FOR PROD CODE
//		return "login";
//	}
	@GetMapping("/login")
	public String gotoLoginPage() {
		return "login";
	}

	@PostMapping("/login")
	public String gotoWelcomPage(@RequestParam String username, @RequestParam String password, ModelMap modelMap) {
		modelMap.put("password", password);
		modelMap.put("username", username);

		if (authentication.validateUser(username, password)) {
			return "welcome";
		}
		modelMap.put("error", "Invalid credentials");
		return "login";
	}

}
