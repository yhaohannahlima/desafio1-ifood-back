package br.com.foodtrack.tracking.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.foodtrack.tracking.Dao.RastreamentoDao;
import br.com.foodtrack.tracking.model.Rastreamento;

@Component
public class RastreamentoServiceImpl implements IRastreamentoService{

	@Autowired
	private RastreamentoDao dao;
	
	@Override
	public Rastreamento adicionarRota(Rastreamento rota) {
		
		Rastreamento rastreamento = dao.save(rota);
		
		return rastreamento;
	}

}
