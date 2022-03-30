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

import br.com.foodtrack.tracking.DTO.PedidoTodosDTO;
import br.com.foodtrack.tracking.DTO.idEntregadorDTO;
import br.com.foodtrack.tracking.Dao.EntregadorDao;
import br.com.foodtrack.tracking.Dao.PedidoDao;
import br.com.foodtrack.tracking.model.Pedido;
import br.com.foodtrack.tracking.services.IPedidoService;

@RestController
@CrossOrigin("*")
public class PedidoController {

	@Autowired
	private PedidoDao daoPedido;

	@Autowired
	private EntregadorDao daoEntregador;

	@Autowired
	private IPedidoService servicePedido;

	@GetMapping("/pedidos")
	public ResponseEntity<?> listarTodos() {
		List<PedidoTodosDTO> pedidos = (List<PedidoTodosDTO>) daoPedido.buscarTodosSimplificado();
//		List<Pedido> pedidos = (List<Pedido>) daoPedido.findAll();
		return ResponseEntity.status(200).body(pedidos);
	}

	@GetMapping("/pedidos/abertos")
	public ResponseEntity<?> listarAbertos() {
		List<Pedido> pedidos = servicePedido.listarAbertoPeddidos();
		return ResponseEntity.status(200).body(pedidos);
	}

	@PutMapping("pedidos/aceitar/{idPedido}")

	public ResponseEntity<?> aceitarPedido(@PathVariable Integer idPedido, @RequestBody idEntregadorDTO id) {
		try {
			servicePedido.validarStatusPedido("aceitar", idPedido, id.getIdEntregador());
			return ResponseEntity.status(200).build();
		} catch (Exception e) {
			return ResponseEntity.status(400).body(e.getMessage());
		}
	}

	@PutMapping("pedidos/finalizar/{idPedido}")

	public ResponseEntity<?> finalizarPedido(@PathVariable Integer idPedido, @RequestBody idEntregadorDTO id) {
		try {
			servicePedido.validarStatusPedido("finalizar", idPedido, id.getIdEntregador());
			return ResponseEntity.status(200).build();
		} catch (Exception e) {
			return ResponseEntity.status(400).body(e.getMessage());
		}
	}

	@PutMapping("pedidos/cancelar/{idPedido}")
	public ResponseEntity<?> cancelarPedido(@PathVariable Integer idPedido, @RequestBody idEntregadorDTO id) {
		try {
			servicePedido.validarStatusPedido("cancelar", idPedido, id.getIdEntregador());
			return ResponseEntity.status(200).build();
		} catch (Exception e) {
			return ResponseEntity.status(400).body(e.getMessage());
		}
	}

}