package com.springboot.TodoApp.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloWorld {
	@RequestMapping("/hello")
	@ResponseBody
	public String hello() {
		return "how is your learning going";
	}

	@RequestMapping("/hello-html")
	@ResponseBody
	public String helloHtml() {
		String string =  """
			<!DOCTYPE html>
				<html>
				<body>
				<h1>My First Heading</h1>
				<p>My first paragraph.</p>
				</body>
				</html>
						 """;
		return string;
	}
//	say-hello.jsp
	@RequestMapping("/hello-jsp")
	public String hellojsp() {
		return "sayHello";
	}
}
