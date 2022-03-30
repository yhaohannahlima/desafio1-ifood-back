package br.com.foodtrack.tracking.services;

import java.util.List;

import br.com.foodtrack.tracking.model.Pedido;

public interface IPedidoService {

	public List<Pedido> listarTodosPedidos();
	public List<Pedido> listarAbertoPeddidos();
	public boolean validarStatusPedido(String acaoStatus ,Integer idPedido, Integer idEntregador) throws Exception;
	
	
}
