package br.com.foodtrack.tracking.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "entregador")
public class Entregador {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer codigoEntregador;
	
	@Column(name = "nome", length = 50, nullable = false)
	private String nome;
	
	@Column(name = "cpf", length = 11, unique = true)
	private String cpf;
	
	@Column(name = "senha", columnDefinition = "TEXT", nullable = false)
	private String senha;
	
	@Column(name = "email", length = 30, nullable = false)
	private String email;
	
	@Column(name = "telefone", length = 11)
	private String telefone;
	
	@OneToMany(mappedBy = "entregador")
	@JsonIgnoreProperties("entregador")
	private List<Pedido> listaPedidos;
	
	
	@OneToMany(mappedBy = "entregador")
	@JsonIgnoreProperties("entregador")
	private List<Tracking> listaRastreamentos;
	
	
	

	public Integer getCodigoEntregador() {
		return codigoEntregador;
	}

	public void setCodigoEntregador(Integer codigoEntregador) {
		this.codigoEntregador = codigoEntregador;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public List<Pedido> getListaPedidos() {
		return listaPedidos;
	}

	public void setListaPedidos(List<Pedido> listaPedidos) {
		this.listaPedidos = listaPedidos;
	}

	public List<Tracking> getListaRastreamentos() {
		return listaRastreamentos;
	}

	public void setListaRastreamentos(List<Tracking> listaRastreamentos) {
		this.listaRastreamentos = listaRastreamentos;
	}
	
	

}
