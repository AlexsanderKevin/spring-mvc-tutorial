package br.com.xavecoding.regescweb.Controllers;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.xavecoding.regescweb.Models.Professor;
import br.com.xavecoding.regescweb.Models.StatusProfessor;

@Controller
public class ProfessorControlller {

	@GetMapping("/professores")
	public ModelAndView index() {
		Professor batman = new Professor("Batman", new BigDecimal(2000.0), StatusProfessor.ATIVO);
		batman.setId(1L);
		Professor regis = new Professor("Regis Jr", new BigDecimal(7000.0), StatusProfessor.INATIVO);
		regis.setId(1L);
		Professor cid = new Professor("Mauricio Cid", new BigDecimal(1000.0), StatusProfessor.APOSENTADO);
		cid.setId(1L);

		List<Professor> professores = Arrays.asList(batman, regis, cid);

		ModelAndView mv = new ModelAndView("professores/index");
		mv.addObject("professores", professores);

		return mv;
	}
}
