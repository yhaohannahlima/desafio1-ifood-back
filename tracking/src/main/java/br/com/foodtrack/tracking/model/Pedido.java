package br.com.foodtrack.tracking.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "pedido")
public class Pedido {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer codigoPedido;
	
	@Column(name = "dataPedido", nullable = false)
	private LocalDate dataPedido;
	
	@Column(name = "status", length = 20, nullable = false)
	private String statusPedido;
	
	@ManyToOne
	@JoinColumn(name = "idCliente")
	private Cliente cliente;
	
	@ManyToOne
	@JoinColumn(name = "idEntregador")
	@JsonIgnoreProperties("listaPedidos")
	private Entregador entregador;
	
	
	@OneToMany(mappedBy = "pedido")
	@JsonIgnoreProperties("pedido")
	private List<Rastreamento> listaRastreamentoPedidos;

	

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

	public Entregador getEntregador() {
		return entregador;
	}

	public void setEntregador(Entregador entregador) {
		this.entregador = entregador;
	}
	
	public List<Rastreamento> getListaRastreamentoPedidos() {
		return listaRastreamentoPedidos;
	}

	public void setListaRastreamentoPedidos(List<Rastreamento> listaRastramentoPedidos) {
		this.listaRastreamentoPedidos = listaRastramentoPedidos;
	}
	
}
