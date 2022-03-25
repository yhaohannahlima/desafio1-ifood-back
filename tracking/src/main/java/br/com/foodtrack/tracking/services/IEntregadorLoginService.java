package br.com.foodtrack.tracking.services;

import java.util.List;

import br.com.foodtrack.tracking.DTO.EntregadorLoginDTO;
import br.com.foodtrack.tracking.model.Entregador;
import br.com.foodtrack.tracking.security.Token;

public interface IEntregadorLoginService {
	public Token gerarAcessoEntregador(EntregadorLoginDTO dadosLogin);
	public Entregador criarEntregador(Entregador novo);
	public Entregador alterarDados(Entregador dados);
	
	public List<Entregador> recuperarTodos();
	public Entregador recuperarDetalhes(Integer id);
}
