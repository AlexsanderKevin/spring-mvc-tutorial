package br.com.xavecoding.regescweb.dto;

import java.math.BigDecimal;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import br.com.xavecoding.regescweb.Models.Professor;
import br.com.xavecoding.regescweb.Models.StatusProfessor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RequisicaoNovoProfessor {
	@NotBlank
	@NotNull
	private String Nome;
	@NotNull
	@DecimalMin(value="950.00", inclusive=false)
	private BigDecimal Salario;
	private StatusProfessor StatusProfessor;
	
	public RequisicaoNovoProfessor(String nome, BigDecimal salario, StatusProfessor status) {
		this.setNome(nome);
		this.setSalario(salario);
		this.setStatusProfessor(status);
	}
	
	public RequisicaoNovoProfessor() {};
	
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
