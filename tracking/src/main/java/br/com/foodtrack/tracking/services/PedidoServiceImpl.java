package br.com.foodtrack.tracking.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.foodtrack.tracking.DTO.PedidoDTO;
import br.com.foodtrack.tracking.DTO.PedidoTodosDTO;
import br.com.foodtrack.tracking.Dao.EntregadorDao;
import br.com.foodtrack.tracking.Dao.PedidoDao;
import br.com.foodtrack.tracking.model.Entregador;
import br.com.foodtrack.tracking.model.Pedido;

@Component
public class PedidoServiceImpl implements IPedidoService {

	@Autowired
	private PedidoDao daoPedido;

	@Autowired
	private EntregadorDao daoEntregador;

	@Override
	public List<PedidoTodosDTO> listarTodosPedidos() {
		return daoPedido.buscarTodosSimplificado();
	}

	@Override
	public List<Pedido> listarAbertoPeddidos() {
		return daoPedido.buscarPedidosPorStatus("aberto");
	}

	@Override
	public boolean validarStatusPedido(String acaoStatus, Integer idPedido, Integer idEntregador) throws Exception {

		Pedido buscarPedido = daoPedido.findById(idPedido).orElse(null);
		Entregador buscarEntregador = daoEntregador.findById(idEntregador).orElse(null);
		
		int idEntregadorPedido = buscarPedido.getEntregador().getCodigoEntregador();
		

		if (checarSeExsite(buscarPedido) && checarSeExsite(buscarEntregador)) {
			switch (acaoStatus) {
			case "aceitar":
				if (buscarPedido.getStatusPedido().equals("aberto")) {
					buscarPedido.setStatusPedido("transito");
					buscarPedido.setEntregador(buscarEntregador);
					daoPedido.save(buscarPedido);
					return true;
				} else {
					throw new Exception("409 - Este pedido já foi alocado: " + buscarPedido.getStatusPedido());
				}

			case "finalizar":
				if (idEntregadorPedido != idEntregador) {
					throw new Exception("409 - idEntregador diferente do que está no pedido.");
				}

				if (buscarPedido.getStatusPedido().equals("transito")) {
					buscarPedido.setStatusPedido("finalizado");
					daoPedido.save(buscarPedido);
					return true;
				} else {
					throw new Exception(
							"409 - Não possível finalizar, status do pedido: " + buscarPedido.getStatusPedido());
				}

			case "cancelar":
				if (idEntregadorPedido != idEntregador) {
					throw new Exception("409 - idEntregador diferente do que está no pedido.");
				}

				if (buscarPedido.getStatusPedido().equals("transito")) {
					buscarPedido.setStatusPedido("cancelado");
					daoPedido.save(buscarPedido);
					return true;
				} else {
					throw new Exception(
							"409 - Não possível finalizar, status do pedido: " + buscarPedido.getStatusPedido());
				}

			default:
				throw new Exception("400 - Opção inválida!");
			}

		} else {
			throw new Exception("404 - idPedido ou idEntregador não localizado!");
		}
	}

	private boolean checarSeExsite(Object obj) {
		return obj != null;
	}

	
}
