package com.example.demo;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
public class Vaga {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable = false)
	private Integer id;
	
	@Column(nullable = false, length = 250)
	private String titulo;
	
	@Column(nullable = false, length = 500)
	private String descricao;
	
	@Column(nullable = false)//ver
	private Cursos curso;

	@Column(nullable = false)
	private double salario;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(nullable = false)
	private LocalDateTime dataPublicacao;

	@ManyToOne 
	@JoinColumn(name = "empresa_id") 
	private Empresa empresa;
	
	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

	public Vaga() {
	}

	public Vaga(Integer id, String titulo, String descricao, Cursos curso, Double salario,
			LocalDateTime dataPublicacao) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.descricao = descricao;
		this.curso = curso;
		this.salario = salario;
		this.dataPublicacao = dataPublicacao;
	}

	@Override
	public String toString() {
		return "Vaga [id=" + id + ", titulo=" + titulo + ", descricao=" + descricao + ", curso=" + curso + ", salario="
				+ salario + ", dataPublicacao=" + dataPublicacao + "]";
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Cursos getCurso() {
		return curso;
	}

	public void setCurso(Cursos curso) {
		this.curso = curso;
	}

	public Double getSalario() {
		return salario;
	}

	public void setSalario(Double salario) {
		this.salario = salario;
	}

	public LocalDateTime getDataPublicacao() {
		return dataPublicacao;
	}

	public void setDataPublicacao(LocalDateTime dataPublicacao) {
		this.dataPublicacao = dataPublicacao;
	}

	public Integer getId() {
		return id;
	}
	
	
}
