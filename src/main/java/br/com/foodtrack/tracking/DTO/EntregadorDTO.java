package br.com.foodtrack.tracking.DTO;

import java.util.ArrayList;
import java.util.List;

import br.com.foodtrack.tracking.model.Entregador;
import br.com.foodtrack.tracking.model.Pedido;


public class EntregadorDTO {
	
	private Integer codigoEntregador;
	private String nome;
	private List<PedidoDTO> pedidos;
	
	
	
	
	

	public EntregadorDTO(Integer codigoEntregador, String nome, 
			List<PedidoDTO> lista) {
		super();
		this.codigoEntregador = codigoEntregador;
		this.nome = nome;
		this.pedidos = lista;
	}


	public Integer getCodigoEntregador() {
		return codigoEntregador;
	}


	public void setCodigoEntregador(Integer codigoEntregador) {
		this.codigoEntregador = codigoEntregador;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}



	public List<PedidoDTO> getPedidos() {
		return pedidos;
	}



	public void setPedidos(List<PedidoDTO> pedidos) {
		this.pedidos = pedidos;
	}


	


	public static EntregadorDTO fromEntregador(Entregador entregador) {
		
		 List<PedidoDTO> lista = new ArrayList<PedidoDTO>();
		 
		 for(Pedido pedido : entregador.getListaPedidos()) {
			 
			 lista.add(PedidoDTO.fromPedido(pedido));
		 }
		
		return new EntregadorDTO(entregador.getCodigoEntregador(),entregador.getNome(),
			lista);
	}
	

}
