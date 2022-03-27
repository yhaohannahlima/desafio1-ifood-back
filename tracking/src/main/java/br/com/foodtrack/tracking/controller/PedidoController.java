package br.com.foodtrack.tracking.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.foodtrack.tracking.DTO.idEntregadorDTO;
import br.com.foodtrack.tracking.Dao.EntregadorDao;
import br.com.foodtrack.tracking.Dao.PedidoDao;
import br.com.foodtrack.tracking.model.Entregador;
import br.com.foodtrack.tracking.model.Pedido;

@RestController
@CrossOrigin("*")
public class PedidoController {

	@Autowired
	private PedidoDao daoPedido;

	@Autowired
	private EntregadorDao daoEntregador;

	@GetMapping("/pedidos")
	public ResponseEntity<?> listarTodos() {
		List<Pedido> pedidos = (List<Pedido>) daoPedido.findAll();
		return ResponseEntity.status(200).body(pedidos);
	}

	@GetMapping("/pedidos/abertos")
	public ResponseEntity<?> listarAbertos() {
		List<Pedido> pedidos = (List<Pedido>) daoPedido.buscarPedidosPorStatus("aberto");
		return ResponseEntity.status(200).body(pedidos);
	}

	
	@PutMapping("pedidos/aceitar/{idPedido}")
	public ResponseEntity<?> entregadorAceitar(@PathVariable Integer idPedido, @RequestBody idEntregadorDTO id) {

		//  TODO : Na V2 passar para service este tratamento!
		try {
			Pedido buscarPedido = daoPedido.findById(idPedido).orElse(null);
			Entregador buscarEntregador = daoEntregador.findById(id.getIdEntregador()).orElse(null);

			if (buscarPedido != null && buscarEntregador != null) {
				if (buscarPedido.getStatusPedido().equals("aberto")) {
					buscarPedido.setStatusPedido("transito");
					buscarPedido.setEntregador(buscarEntregador);
					daoPedido.save(buscarPedido);
					return ResponseEntity.ok().build();
				} else {
					return ResponseEntity.status(409).body("Este pedido não está mais em aberto!");
				}

			} else {
				return ResponseEntity.status(404).body("{Id pedido e/ou id entregador não localizado.}");
			}
		} catch (Exception e) {
			return ResponseEntity.status(400).body("Campo obrigatório: idEntregador: Integer.");

		}
	}
	
	@PutMapping("pedidos/finalizar/{idPedido}")
	public ResponseEntity<?> entregadorFinalizada(@PathVariable Integer idPedido, @RequestBody idEntregadorDTO id) {

		//  TODO : Na V2 passar para service este tratamento!
		try {
			Pedido buscarPedido = daoPedido.findById(idPedido).orElse(null);
			Entregador buscarEntregador = daoEntregador.findById(id.getIdEntregador()).orElse(null);

			if (buscarPedido != null && buscarEntregador != null) {
				if (buscarPedido.getStatusPedido().equals("aberto")) {
					return ResponseEntity.status(409).body("Este Pedido ainda está em aberto!");
				}
				else if (buscarPedido.getStatusPedido().equals("entregue")){
					return ResponseEntity.status(409).body("Este Pedido já foi entregue!");
				}
				else if (buscarPedido.getEntregador().getCodigoEntregador() != id.getIdEntregador()) {
					return ResponseEntity.status(409).body("Entregador da finalização difere do que aceitou pedido!");
 
				} else {
					buscarPedido.setStatusPedido("entregue");					
					daoPedido.save(buscarPedido);
					return ResponseEntity.ok().build();
				}

			} else {
				return ResponseEntity.status(404).body("{Id pedido e/ou id entregador não localizado.}");
			}
		} catch (Exception e) {
			return ResponseEntity.status(400).body("Campo obrigatório: idEntregador: Integer.");

		}
	}
	

}