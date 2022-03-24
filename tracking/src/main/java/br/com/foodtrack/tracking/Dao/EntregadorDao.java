package br.com.foodtrack.tracking.Dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import br.com.foodtrack.tracking.model.Entregador;

public interface EntregadorDao extends CrudRepository<Entregador, Integer> {

	@Query(" SELECT "
			+"new br.com.foodtrack.tracking.model.Entregador("
			+" codigoEntregador, "
			+" nome, "
			+"cpf, "
			+"senha, "
			+"email, "
			+" telefone) "
			+" FROM Entregador") 
	public List<Entregador> buscarTodos();
	
}
