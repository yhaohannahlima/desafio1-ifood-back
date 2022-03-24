package br.com.foodtrack.tracking.Dao;

import org.springframework.data.repository.CrudRepository;

import br.com.foodtrack.tracking.model.Pedido;

public interface PedidoDao extends CrudRepository<Pedido, Integer>{

}
