package br.com.foodtrack.tracking.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.foodtrack.tracking.Dao.EntregadorDao;
import br.com.foodtrack.tracking.Dao.PedidoDao;
import br.com.foodtrack.tracking.model.Entregador;
import br.com.foodtrack.tracking.model.Pedido;
import net.bytebuddy.implementation.bytecode.Throw;

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
	public boolean validarStatusPedido(String acaoStatus, Integer idPedido, Integer idEntregador) throws Exception {

		Pedido buscarPedido = daoPedido.findById(idPedido).orElse(null);
		Entregador buscarEntregador = daoEntregador.findById(idEntregador).orElse(null);

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

				// falta validar se entregador do pedido está correto.
			case "finalizar":
				if (buscarPedido.getStatusPedido().equals("transito")) {
					buscarPedido.setStatusPedido("finalizado");
					daoPedido.save(buscarPedido);
					return true;
				} else {
					throw new Exception(
							"409 - Não possível finalizar, status do pedido: " + buscarPedido.getStatusPedido());
				}
				// falta validar se entregador do pedido está correto.
			case "cancelar":
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
//			if (checarStatus(buscarPedido, "aberto")) {
//				return null;
//			}

		} else {
			throw new Exception("404 - idPedido ou idEntregador não localizado!");
		}
//		return false;
	}

	private boolean checarSeExsite(Object obj) {
		return obj != null;
	}

	private boolean checarStatus(Pedido pedido, String status) {
		return pedido.getStatusPedido().equals(status);
	}
}
