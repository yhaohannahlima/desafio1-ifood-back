package br.com.foodtrack.tracking.Dao;

import org.springframework.data.repository.CrudRepository;

import br.com.foodtrack.tracking.model.Entregador;

public interface EntregadorDao extends CrudRepository<Entregador, Integer> {
      public Entregador findByEmailOrSenha(String email, String senha);
}
