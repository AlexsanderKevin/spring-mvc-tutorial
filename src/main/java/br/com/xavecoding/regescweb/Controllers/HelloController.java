package br.com.xavecoding.regescweb.Controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {
	
	@GetMapping("/hello")
	public ModelAndView hello() {
		ModelAndView mv = new ModelAndView("hello"); // nome do arquivo html a ser renderizado
		mv.addObject("nome", "Kevin Alexsander");
		return mv;
	}

	@GetMapping("/hello-model")
	public String Hello(Model model) {
		model.addAttribute("nome", "Kevin");
		return "hello"; // o Spring vai renderizar o arquivo template/hello.html
	}
	
	@GetMapping("hello-servlet")
	public String Hello(HttpServletRequest request) {
		request.setAttribute("nome", "Alexsander");
		return "hello";
	}
}
