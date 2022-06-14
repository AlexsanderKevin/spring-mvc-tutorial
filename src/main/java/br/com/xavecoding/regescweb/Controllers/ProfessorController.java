package br.com.xavecoding.regescweb.Controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.xavecoding.regescweb.Models.Professor;
import br.com.xavecoding.regescweb.Models.StatusProfessor;
import br.com.xavecoding.regescweb.dto.RequisicaoNovoProfessor;
import br.com.xavecoding.regescweb.repository.ProfessorRepository;

@Controller
public class ProfessorController {
	@Autowired // Faz a injeção de dependencia automaticamente;
	private ProfessorRepository professorRepository;

	@GetMapping("/professores")
	public ModelAndView index() {
		List<Professor> professores = this.professorRepository.findAll();

		ModelAndView mv = new ModelAndView("professores/index");
		mv.addObject("professores", professores);

		return mv;
	}
	
	@GetMapping("/professores/new")
	public ModelAndView nnew() {
		ModelAndView mv = new ModelAndView("/professores/new");
		mv.addObject("StatusProfessor", StatusProfessor.values());

		return mv;
	}
	
	@PostMapping("/professores")
									 // @Valid = Garante que o valor passado para a DTO sejam validos, de acordo com as
									// regras do proprio DTO                                      // Objeto de resultado para validação
	public ModelAndView create(@Valid RequisicaoNovoProfessor requisicao, BindingResult result) {
		
		if(result.hasErrors()) {
			System.out.println("\n ERRO \n");
			
			ModelAndView mv = new ModelAndView("/professores/new");
			mv.addObject("StatusProfessor", StatusProfessor.values());
			
			return mv;
		} else {
			Professor professor = requisicao.ToProfessor();
			// Persiste os dados no banco
			this.professorRepository.save(professor);
			
			ModelAndView mv = new ModelAndView("redirect:/professores");

			return mv;
		}

	}
}
