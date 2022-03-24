package br.com.foodtrack.tracking.controller;

import java.time.LocalDate;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.foodtrack.tracking.model.Pedido;

@RestController
@CrossOrigin("*")
public class PedidoController {
	
//	@Autowired
//	private pedidoDAO dao
	
	@GetMapping("/pedidos/abertos")
	public ResponseEntity<?> listarTodosAbertos(){
//	   Fake incial para front usar
		
		String[] pedidoFake = {"{codigoPedido:1}","{codigoPedido:2}"};
	  
		return ResponseEntity.status(200).body(pedidoFake);
		
	}

}