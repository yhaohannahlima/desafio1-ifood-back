package br.com.foodtrack.tracking.Dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import br.com.foodtrack.tracking.model.Pedido;

public interface PedidoDao extends CrudRepository<Pedido, Integer>{
	
//	@Query("SELECT new br.com.foodtracking.model.Pedido( "
//			+ " codigoPedido,"
//			+ " dataPedido,"
//			+ " statusPedido,"	
//			
//			
//			)
//	

}
