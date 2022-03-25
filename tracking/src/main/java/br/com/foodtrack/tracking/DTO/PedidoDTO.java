package br.com.foodtrack.tracking.DTO;

import java.time.LocalDate;
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
	private LocalDate dataPedido;
	private String statusPedido;
	private Cliente cliente;
	private Integer codigoCliente;
	private String clienteNome;
	private Entregador entregador;
	private Integer codigoEntregador;
//	private List<Rastreamento> listaRastreamentoPedidos;

	public PedidoDTO() {

	}

	public PedidoDTO(Integer codigoPedido, LocalDate dataPedido, String statusPedido) {
		super();
		this.codigoPedido = codigoPedido;
		this.dataPedido = dataPedido;
		this.statusPedido = statusPedido;		
	}
	
	public PedidoDTO(Integer codigoPedido, LocalDate dataPedido, String statusPedido, Cliente cliente,
			Integer codigoCliente, String clienteNome, Entregador entregador, Integer codigoEntregador) {
		super();
		this.codigoPedido = codigoPedido;
		this.dataPedido = dataPedido;
		this.statusPedido = statusPedido;
		this.cliente = new Cliente();
		this.clienteNome = cliente.getNome();
		this.entregador = new Entregador();
		this.codigoEntregador = entregador.getCodigoEntregador();
	}

	public Integer getCodigoPedido() {
		return codigoPedido;
	}

	public void setCodigoPedido(Integer codigoPedido) {
		this.codigoPedido = codigoPedido;
	}

	public LocalDate getDataPedido() {
		return dataPedido;
	}

	public void setDataPedido(LocalDate dataPedido) {
		this.dataPedido = dataPedido;
	}

	public String getStatusPedido() {
		return statusPedido;
	}

	public void setStatusPedido(String statusPedido) {
		this.statusPedido = statusPedido;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Integer getCodigoCliente() {
		return codigoCliente;
	}

	public void setCodigoCliente(Integer codigoCliente) {
		this.codigoCliente = codigoCliente;
	}

	public String getClienteNome() {
		return clienteNome;
	}

	public void setClienteNome(String clienteNome) {
		this.clienteNome = clienteNome;
	}

	public Entregador getEntregador() {
		return entregador;
	}

	public void setEntregador(Entregador entregador) {
		this.entregador = entregador;
	}

	public Integer getCodigoEntregador() {
		return codigoEntregador;
	}

	public void setCodigoEntregador(Integer codigoEntregador) {
		this.codigoEntregador = codigoEntregador;
	}

}
