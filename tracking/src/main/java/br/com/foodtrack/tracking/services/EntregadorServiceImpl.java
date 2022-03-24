package br.com.foodtrack.tracking.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.foodtrack.tracking.DTO.EntregadorDTO;
import br.com.foodtrack.tracking.Dao.EntregadorDao;

@Component
public class EntregadorServiceImpl implements IEntregadorService{
	
	@Autowired
	private EntregadorDao dao;
	
	

	@Override
	public List<EntregadorDTO> buscaTodos() {
<<<<<<< HEAD
		
		return dao.buscarTodos();
=======
		return null;
//		return dao.buscarTodos();
>>>>>>> 93819de339a7e325786ee693d38cd2e77e7f2df1
	}
	

}
