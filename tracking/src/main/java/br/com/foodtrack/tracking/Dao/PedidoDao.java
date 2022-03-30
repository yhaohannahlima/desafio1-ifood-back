package br.com.foodtrack.tracking.Dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import br.com.foodtrack.tracking.model.Pedido;

public interface PedidoDao extends CrudRepository<Pedido, Integer>{

	@Query("SELECT p FROM Pedido p WHERE p.statusPedido = :status")
	public List<Pedido> buscarPedidosPorStatus(String status);
	

}
