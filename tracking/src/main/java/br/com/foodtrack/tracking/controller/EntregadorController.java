
   
package br.com.foodtrack.tracking.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import br.com.foodtrack.tracking.DTO.EntregadorDTO;
import br.com.foodtrack.tracking.Dao.EntregadorDao;
import br.com.foodtrack.tracking.model.Entregador;

import br.com.foodtrack.tracking.services.IEntregadorService;

@RestController
public class EntregadorController {
	
	@Autowired
	private IEntregadorService service;
	
	@Autowired
	EntregadorDao dao;
	
	
	@GetMapping("/entregadorestodos")
	public List<Entregador> buscatodo(){
		
		List<Entregador> resultado =  (List<Entregador>) dao.findAll();
		
		return resultado;
	}
	
	@GetMapping("/entregadores")
	public ResponseEntity<List<Entregador>> buscarTodos(){
		return ResponseEntity.ok(service.buscaTodos());
	}
	
	
	@GetMapping("/entregadores/{id}")
	public ResponseEntity<EntregadorDTO> bucarUm(@PathVariable Integer id ){	
		return ResponseEntity.ok(service.buscarUm(id));
	}
	


}


