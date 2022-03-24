package br.com.foodtrack.tracking.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.foodtrack.tracking.DTO.EntregadorDTO;
import br.com.foodtrack.tracking.services.IEntregadorService;

@RestController
public class EntregadorController {
	
	@Autowired
	private IEntregadorService service;
	
	@GetMapping("/entregadores")
	public ResponseEntity<List<EntregadorDTO>> buscarTodos(){
		
		return ResponseEntity.ok(service.buscaTodos());
	}

}
