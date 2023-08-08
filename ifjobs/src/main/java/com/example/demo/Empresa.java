package com.example.demo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Empresa {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable = false)
	private Integer id;
	
	@Column(nullable = false, length = 250)
	private String nome;
	
	@Column(nullable = false, length = 500)
	private String descricao;
	
	@Column(nullable = false, length = 250)
	private String cidade;
	
	@Column(nullable = false, length = 250)
	private String endereco;
	
	@Column(nullable = false)
	private LocalDate dataFundacao;

	@OneToMany(mappedBy = "empresa", cascade = CascadeType.PERSIST)
	private List<Vaga> itens = new ArrayList<>();
	
	public List<Vaga> getItens() {
		return itens;
	}

	public void setItens(List<Vaga> itens) {
		this.itens = itens;
	}

	public Empresa() {
	}
	
	public Empresa(Integer id, String nome, String descricao, String cidade, String endereco, LocalDate dataFundacao) {
		super();
		this.id = id;
		this.nome = nome;
		this.descricao = descricao;
		this.cidade = cidade;
		this.endereco = endereco;
		this.dataFundacao = dataFundacao;
	}

	@Override
	public String toString() {
		return "Empresa [id=" + id + ", nome=" + nome + ", descricao=" + descricao + ", cidade=" + cidade
				+ ", endereco=" + endereco + ", dataFundacao=" + dataFundacao + "]";
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public LocalDate getDataFundacao() {
		return dataFundacao;
	}

	public void setDataFundacao(LocalDate dataFundacao) {
		this.dataFundacao = dataFundacao;
	}

	public Integer getId() {
		return id;
	}
	
	
}
