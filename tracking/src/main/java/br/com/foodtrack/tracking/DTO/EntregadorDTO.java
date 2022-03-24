package br.com.foodtrack.tracking.DTO;

import br.com.foodtrack.tracking.model.Entregador;

public class EntregadorDTO {
	
	private Integer codigoEntregador;
	private String nome;
	private String cpf;
	private String senha;
	private String email;
	private String telefone;
	
	
	public EntregadorDTO(Integer codigoEntregador, String nome, String cpf, String senha, String email,
			String telefone) {
		super();
		
		this.codigoEntregador = codigoEntregador;
		this.nome = nome;
		this.cpf = cpf;
		this.senha = senha;
		this.email = email;
		this.telefone = telefone;
	}
	
	
	public EntregadorDTO(Entregador entregador) {
		
		super();
		
		this.codigoEntregador = entregador.getCodigoEntregador();
		this.nome = entregador.getNome();
		this.cpf = entregador.getCpf();
		this.senha = entregador.getSenha();
		this.email = entregador.getEmail();
		this.telefone = entregador.getTelefone();
		
	}


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
	
	
	public static EntregadorDTO fromEntregador(Entregador entregador) {
		
		return new EntregadorDTO(entregador.getCodigoEntregador(),
								 entregador.getNome(),
								 entregador.getCpf(),
								 entregador.getSenha(),
								 entregador.getEmail(),
								 entregador.getTelefone());
	}
	

}
