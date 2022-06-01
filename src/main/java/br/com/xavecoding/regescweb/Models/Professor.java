package br.com.xavecoding.regescweb.Models;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Professor {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // torna o Id autoincremental no banco de dados
	private Long id;

	@Column(nullable = false)
	private String nome;

	private BigDecimal salario;

	@Enumerated(EnumType.STRING) // registra o valor do enum como String no banco
	private StatusProfessor statusProfessor;
	
	public Professor() { }
}
