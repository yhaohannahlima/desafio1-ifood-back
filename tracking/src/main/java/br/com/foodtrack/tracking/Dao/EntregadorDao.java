package br.com.foodtrack.tracking.Dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import br.com.foodtrack.tracking.DTO.EntregadorDTO;
import br.com.foodtrack.tracking.model.Entregador;

public interface EntregadorDao extends CrudRepository<Entregador, Integer> {
//
//	@Query(" SELECT "
//			+"new br.com.foodtrack.tracking.DTO.EntregadorDTO("
//			+" entregador.codigoEntregador, "
//			+" entregador.nome, "
//			+" entregador.cpf, "
//			+" entregador.senha, "
//			+" entregador.email "
//			+" entregador.telefone) "
//			+" FROM Entregador as entregador")
//	public List<EntregadorDTO> buscarTodos();
}
