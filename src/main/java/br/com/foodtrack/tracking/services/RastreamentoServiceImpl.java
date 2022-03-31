package br.com.foodtrack.tracking.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.foodtrack.tracking.DTO.RastreamentoDTO;
import br.com.foodtrack.tracking.Dao.PedidoDao;
import br.com.foodtrack.tracking.Dao.RastreamentoDao;
import br.com.foodtrack.tracking.model.Pedido;
import br.com.foodtrack.tracking.model.Rastreamento;

@Component
public class RastreamentoServiceImpl implements IRastreamentoService {

	@Autowired
	private RastreamentoDao rastreamentoDao;

	@Autowired
	private PedidoDao pedidoDao;

	@Override
	public RastreamentoDTO adicionarRota(RastreamentoDTO rota) throws Exception {

		if ((rota.getLatitude() != null) && (rota.getLongitude() != null) && (rota.getTempo() != null)
				&& (rota.getIdPedido() != null)) {

			Pedido pedido = pedidoDao.findById(rota.getIdPedido()).orElse(null);

			if (pedido != null && pedido.getStatusPedido().equals("transito")) {

				Rastreamento rastreamento = new Rastreamento();
				rastreamento.setLatitude(rota.getLatitude());
				rastreamento.setLongitude(rota.getLongitude());
				rastreamento.setTempo(rota.getTempo());
				rastreamento.setPedido(pedido);
				rastreamentoDao.save(rastreamento);

				return RastreamentoDTO.fromRastreamento(rastreamento);

			}


			throw new Exception("409 - CONFLICT");
		}
		throw new Exception("400 - BAD REQUEST");
	}
}
