package br.com.foodtrack.tracking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.foodtrack.tracking.model.Entregador;
import br.com.foodtrack.tracking.services.IEntregadorService;

@RestController
public class EntregadorController {
	

	@Autowired
	private IEntregadorService service;
	
	@GetMapping("/entregadores")
	public ResponseEntity<?> cadastrarNovoEntregador(@RequestBody Entregador novo){
		   Entregador res = service.criarEntregador(novo);
		   
		   if  (res != null) {
			   return ResponseEntity.ok(res);
		   }
		   return ResponseEntity.badRequest().body( "Dados Invalidos");
}
}


