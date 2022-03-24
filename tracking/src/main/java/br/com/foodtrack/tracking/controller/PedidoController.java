package br.com.foodtrack.tracking.controller;


import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.foodtrack.tracking.Dao.PedidoDao;
import br.com.foodtrack.tracking.model.Pedido;

@RestController
@CrossOrigin("*")
public class PedidoController {
	
//	@Autowired
	private PedidoDao dao;
	
	@GetMapping("/pedidos/abertos")
	public ResponseEntity<?> listarTodosAbertos(){
		List<Pedido> pedidos = (List<Pedido>) dao.findAll();
		if (pedidos == null) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.status(200).body(pedidos);
	}

}