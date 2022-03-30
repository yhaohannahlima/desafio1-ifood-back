package br.com.foodtrack.tracking.services;

import java.util.List;

import br.com.foodtrack.tracking.DTO.EntregadorDTO;
import br.com.foodtrack.tracking.model.Entregador;



public interface IEntregadorService {
	public List<Entregador> buscaTodos();
	public EntregadorDTO buscarUm(Integer id);
}
