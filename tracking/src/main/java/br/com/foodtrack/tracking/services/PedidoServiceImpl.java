package br.com.foodtrack.tracking.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.foodtrack.tracking.Dao.EntregadorDao;
import br.com.foodtrack.tracking.Dao.PedidoDao;
import br.com.foodtrack.tracking.model.Pedido;

@Component
public class PedidoServiceImpl implements IPedidoService {

	@Autowired
	private PedidoDao daoPedido;

	@Autowired
	private EntregadorDao daoEntregador;

	@Override
	public List<Pedido> listarTodosPedidos() {
		return (List<Pedido>) daoPedido.findAll();
	}

	@Override
	public List<Pedido> listarAbertoPeddidos() {
		return (List<Pedido>) daoPedido.buscarPedidosPorStatus("aberto");
	}

	@Override
	public boolean validarStatusPedido(String statusDesejado, Integer idPedido, Integer idEntregador) {
		// TODO Auto-generated method stub
		return false;
	}

}
