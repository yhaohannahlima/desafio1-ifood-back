package br.com.foodtrack.tracking.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.foodtrack.tracking.DTO.EntregadorLoginDTO;
import br.com.foodtrack.tracking.Dao.EntregadorDao;
import br.com.foodtrack.tracking.model.Entregador;
import br.com.foodtrack.tracking.security.Token;
import br.com.foodtrack.tracking.security.TokenUtil;

@Component
public class EntregadorLoginServiceImpl implements IEntregadorLoginService{
	
	@Autowired
	private EntregadorDao dao;

	@Override
	public Token gerarAcessoEntregador(EntregadorLoginDTO dadosLogin) {
		System.out.println("Estou aqui");
		Entregador usuario = dao.findByEmail(dadosLogin.getEmail());
		
		try {
            if (usuario != null) {
				String senhaLogin = dadosLogin.getSenha();
				if (senhaLogin.equals(usuario.getSenha())) {
					return new Token(TokenUtil.createToken(usuario));
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}
}
	