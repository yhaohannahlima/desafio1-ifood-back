package br.com.foodtrack.tracking.model;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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

	@Column(name = "datapedido", nullable = false, columnDefinition = "TIMESTAMP")
	private Timestamp dataPedido;

	@Column(name = "status", length = 20, nullable = false)
	private String statusPedido;

	@Column(name = "descricao", length = 100, nullable = false)
	private String descricaoPedido;

	@ManyToOne
	@JoinColumn(name = "idcliente")
	private Cliente cliente;

	@ManyToOne
	@JoinColumn(name = "identregador")
	@JsonIgnoreProperties("listaPedidos")
	private Entregador entregador;

	@OneToMany(mappedBy = "pedido")
	@JsonIgnoreProperties("pedido")
	private List<Rastreamento> listaRastreio;

	

	public Pedido() {
		
	}
	
	public Pedido(Integer codigoPedido, Timestamp dataPedido, String statusPedido, String descricaoPedido,
			Cliente cliente, Entregador entregador) {
		super();
		this.codigoPedido = codigoPedido;
		this.dataPedido = dataPedido;
		this.statusPedido = statusPedido;
		this.descricaoPedido = descricaoPedido;
		this.cliente = cliente;
		this.entregador = entregador;
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

	public List<Rastreamento> getListaRastreio() {
		return listaRastreio;
	}

	public void setListaRastreio(List<Rastreamento> listaRastreio) {
		this.listaRastreio = listaRastreio;
	}

}
