package br.com.foodtrack.tracking.services;

import br.com.foodtrack.tracking.DTO.EntregadorLoginDTO;
import br.com.foodtrack.tracking.security.Token;

public interface IEntregadorLoginService {
	public Token gerarAcessoEntregador(EntregadorLoginDTO dadosLogin) throws Exception;
}
