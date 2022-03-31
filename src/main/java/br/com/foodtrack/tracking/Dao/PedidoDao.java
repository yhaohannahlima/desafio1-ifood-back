package br.com.foodtrack.tracking.Dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import br.com.foodtrack.tracking.DTO.PedidoTodosDTO;
import br.com.foodtrack.tracking.model.Pedido;

public interface PedidoDao extends CrudRepository<Pedido, Integer>{

	@Query(
			"SELECT new br.com.foodtrack.tracking.DTO.PedidoTodosDTO("
			+ " p.codigoPedido, p.dataPedido, p.statusPedido, p.descricaoPedido,"
			+ " p.cliente.codigoCliente, p.cliente.nome,"
			+ " p.entregador.codigoEntregador, p.entregador.nome)"
			+ " FROM Pedido p"
	)
	public List<PedidoTodosDTO> buscarTodosSimplificado();
	
	@Query("SELECT p FROM Pedido p WHERE p.statusPedido = :status")
	public List<Pedido> buscarPedidosPorStatus(String status);
	

}
