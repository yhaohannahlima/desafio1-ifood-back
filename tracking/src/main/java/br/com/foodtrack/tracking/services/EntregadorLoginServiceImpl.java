package br.com.foodtrack.tracking.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.foodtrack.tracking.DTO.EntregadorLoginDTO;
import br.com.foodtrack.tracking.Dao.EntregadorDao;
import br.com.foodtrack.tracking.model.Entregador;
import br.com.foodtrack.tracking.security.Token;
import br.com.foodtrack.tracking.security.TokenUtil;
import br.com.foodtrack.tracking.security.TrackingCrypto;

public class EntregadorLoginServiceImpl implements IEntregadorLoginService{
	
	@Autowired
	private EntregadorDao dao;

	@Override
	public Token gerarAcessoEntregador(EntregadorLoginDTO dadosLogin) {
		Entregador usuario = dao.findByEmail(dadosLogin.getEmail());
		
		try {

			if (usuario != null) {
				String senhaLogin = TrackingCrypto.encriptar(dadosLogin.getSenha());

				System.out.println("Senha login = " + senhaLogin);
				System.out.println("Senha user  = " + usuario.getSenha());

				if (senhaLogin.equals(usuario.getSenha())) {
					return new Token(TokenUtil.createToken(usuario));
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}

	@Override
	public Entregador criarEntregador(Entregador novo) {
		try {
			if (novo.getSenha() != null) {
				novo.setSenha(TrackingCrypto.encriptar(novo.getSenha()));
				dao.save(novo);
				return novo;
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;	
	}

	@Override
	public Entregador alterarDados(Entregador dados) {
		try {
			if (dados.getSenha() != null) {
				dados.setSenha(TrackingCrypto.encriptar(dados.getSenha()));
				dao.save(dados);
				return dados;
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Entregador> recuperarTodos() {
		return (List<Entregador>) dao.findAll();
	}

	@Override
	public Entregador recuperarDetalhes(Integer id) {
		
		return null;
	}
     

}
