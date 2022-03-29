package br.com.foodtrack.tracking.DTO;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import br.com.foodtrack.tracking.model.Cliente;
import br.com.foodtrack.tracking.model.Pedido;
import br.com.foodtrack.tracking.model.Entregador;
import br.com.foodtrack.tracking.model.Rastreamento;

public class PedidoDTO {

	private Integer codigoPedido;
	private Timestamp dataPedido;
	private String statusPedido;
	private String descricaoPedido;
	private Entregador entregador;
	private Integer entregadorId;
	private String entregadorNome;
	private Cliente cliente;
	private String clienteNome;

	private List<RastreamentoDTO> rastreamento;

	public PedidoDTO(Integer codigoPedido, Timestamp dataPedido, String statusPedido, String descricaoPedido,
			Entregador entregador) {
		super();
		this.codigoPedido = codigoPedido;
		this.dataPedido = dataPedido;
		this.statusPedido = statusPedido;
		this.descricaoPedido = descricaoPedido;
		this.entregador = new Entregador();
		this.entregadorId = entregador.getCodigoEntregador();
		this.entregadorNome = entregador.getNome();
//		this.cliente = new Cliente();
	}

	public PedidoDTO(Integer codigoPedido, Timestamp dataPedido, String statusPedido, String descricaoPedido,
			List<RastreamentoDTO> rastreamento) {
		super();
		this.codigoPedido = codigoPedido;
		this.dataPedido = dataPedido;
		this.statusPedido = statusPedido;
		this.descricaoPedido = descricaoPedido;
		this.rastreamento = rastreamento;
	}

	public Integer getCodigoPedido() {
		return codigoPedido;
	}

	public void setCodigoPedido(Integer codigoPedido) {
		this.codigoPedido = codigoPedido;
	}

	public Timestamp getDataPedido() {
		return dataPedido;
	}

	public void setDataPedido(Timestamp dataPedido) {
		this.dataPedido = dataPedido;
	}

	public String getStatusPedido() {
		return statusPedido;
	}

	public void setStatusPedido(String statusPedido) {
		this.statusPedido = statusPedido;
	}

	public String getDescricaoPedido() {
		return descricaoPedido;
	}

	public void setDescricaoPedido(String descricaoPedido) {
		this.descricaoPedido = descricaoPedido;
	}

	public List<RastreamentoDTO> getRastreamento() {
		return rastreamento;
	}

	public void setRastreamento(List<RastreamentoDTO> rastreamento) {
		this.rastreamento = rastreamento;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Integer getEntregadorId() {
		return entregadorId;
	}

	public void setEntregadorId(Integer entregadorId) {
		this.entregadorId = entregadorId;
	}

	public String getEntregadorNome() {
		return entregadorNome;
	}

	public void setEntregadorNome(String entregadorNome) {
		this.entregadorNome = entregadorNome;
	}

	public static PedidoDTO fromPedido(Pedido pedido) {

		List<RastreamentoDTO> lista = new ArrayList<RastreamentoDTO>();

		for (Rastreamento rastreamento : pedido.getListaRastreio()) {

			lista.add(RastreamentoDTO.fromRastreamento(rastreamento));
		}
		return new PedidoDTO(pedido.getCodigoPedido(), pedido.getDataPedido(), pedido.getStatusPedido(),
				pedido.getDescricaoPedido(), lista);
	}

//	public static PedidoDTO fromPedidoB(Pedido pedido) {
//
//		return new PedidoDTO(pedido.getCodigoPedido(), pedido.getDataPedido(), pedido.getStatusPedido(),
//				pedido.getDescricaoPedido(), getEntregadorId(), getEntregadorNome());
//	}

}
