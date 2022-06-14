package br.com.xavecoding.regescweb.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

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
	public String create(RequisicaoNovoProfessor requisicao) {
		Professor professor = requisicao.ToProfessor();
		// Persiste os dados no banco
		this.professorRepository.save(professor);

		return "redirect:/professores";
	}
}
