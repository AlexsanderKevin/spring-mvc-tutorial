package br.com.xavecoding.regescweb.dto;

import java.math.BigDecimal;

import br.com.xavecoding.regescweb.Models.Professor;
import br.com.xavecoding.regescweb.Models.StatusProfessor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RequisicaoNovoProfessor {
	private String Nome;
	private BigDecimal Salario;
	private StatusProfessor StatusProfessor;
	
	public Professor ToProfessor() {
		Professor prof = new Professor();
		prof.setNome(this.Nome);
		prof.setSalario(this.Salario);
		prof.setStatusProfessor(this.StatusProfessor);
		
		return prof;
	}
	
	public String ToString() {
		
		return "Professor { " +
					"nome:  " +  this.getNome() +", "+
					"salario: " + this.getSalario() +", "+
					"status: " + this.getStatusProfessor() +" }";
	}
}
