package br.com.foodtrack.tracking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.foodtrack.tracking.model.Rastreamento;
import br.com.foodtrack.tracking.services.IRastreamentoService;

@RestController
@CrossOrigin("*")
public class RastreamentoController {

	@Autowired
	IRastreamentoService service;
	
	@PostMapping("/rastreamento")
	public ResponseEntity<Rastreamento> inserirRota(@RequestBody Rastreamento rota){
		
		Rastreamento resultado = service.adicionarRota(rota);
		
		if(resultado != null) {
			
			System.out.println(resultado.getTempo());
			return ResponseEntity.ok(resultado);
		}
		
		return ResponseEntity.badRequest().build();
		
	}
	
}
