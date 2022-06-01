package br.com.xavecoding.regescweb.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProfessorControlller {

	@GetMapping("/professores")
	public String index() {
		return "professores/index";
	}
}
