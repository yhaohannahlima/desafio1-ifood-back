package br.com.foodtrack.tracking.services;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


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

		Pedido bdPedido = daoPedido.findById(idPedido).orElse(null);
		Entregador bdEntregador = daoEntregador.findById(idEntregador).orElse(null);

		if (checarSeExsite(bdPedido) && checarSeExsite(bdEntregador)) {

			switch (acaoStatus) {
			case "aceitar":
				return acaoAceitar(bdPedido, bdEntregador);

			case "finalizar":
				return acaoFinalizarOuCancelar(bdPedido, idEntregador, "finalizado");

			case "cancelar":
				return acaoFinalizarOuCancelar(bdPedido, idEntregador, "cancelado");

			default:
				throw new Exception("Erro requisição - Opção inválida!");
			}
		}
		throw new Exception("Não encontrado - idPedido ou idEntregador não localizado!");
	}
	

	private boolean checarSeExsite(Object obj) {
		return obj != null;
	}
	

	private boolean acaoAceitar(Pedido pedido, Entregador entregador) throws Exception {

		if (pedido.getStatusPedido().equals("aberto")) {
			pedido.setStatusPedido("transito");
			pedido.setEntregador(entregador);
			daoPedido.save(pedido);
			return true;
		}

		throw new Exception("Conflito - Este pedido já foi alocado, status: " + pedido.getStatusPedido());
	}

	
	private boolean acaoFinalizarOuCancelar(Pedido pedido, Integer idEntregador, String acao) throws Exception {

		Integer idEntregadorPedido = null;

		if (checarSeExsite(pedido.getEntregador())) {
			idEntregadorPedido = pedido.getEntregador().getCodigoEntregador();
		} else {
			throw new Exception("Ops - Pedido sem idEntregador, está com problemas no BD!");
		}

		if (idEntregadorPedido != idEntregador) {
			throw new Exception("Conflito - idEntregador diferente do que está no pedido.");
		}

		if (pedido.getStatusPedido().equals("transito")) {
			pedido.setStatusPedido(acao);
			daoPedido.save(pedido);
			return true;
		}
		
		throw new Exception("Conflito - Não foi possível exceutar, status do pedido: " + pedido.getStatusPedido());

	}

}