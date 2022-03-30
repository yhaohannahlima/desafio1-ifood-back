package br.com.foodtrack.tracking.DTO;

import java.sql.Timestamp;
import java.util.Date;

import br.com.foodtrack.tracking.model.Cliente;
import br.com.foodtrack.tracking.model.Entregador;

public class PedidoTodosDTO {

	private Integer codigoPedido;
	private Date dataPedido;
	private String statusPedido;
	private String descricaoPedido;
	private Integer codigoCliente;
	private String nomeCliente;
	private Integer codigoEntregador;
	private String nomeEntregador;

	public PedidoTodosDTO(Integer codigoPedido, Date dataPedido, String statusPedido, String descricaoPedido) {
		this.codigoPedido = codigoPedido;
		this.dataPedido = dataPedido;
		this.statusPedido = statusPedido;
		this.descricaoPedido = descricaoPedido;

	}

	public PedidoTodosDTO(Integer codigoPedido, Date dataPedido, String statusPedido, String descricaoPedido,
			Integer codigoCliente, String nomeCliente) {
		this.codigoPedido = codigoPedido;
		this.dataPedido = dataPedido;
		this.statusPedido = statusPedido;
		this.descricaoPedido = descricaoPedido;
		this.codigoCliente = codigoCliente;
		this.nomeCliente = nomeCliente;
	}

	public PedidoTodosDTO(Integer codigoPedido, Date dataPedido, String statusPedido, String descricaoPedido,
			Integer codigoCliente, String nomeCliente, Integer codigoEntregador, String nomeEntregador) {

		this.codigoPedido = codigoPedido;
		this.dataPedido = dataPedido;
		this.statusPedido = statusPedido;
		this.descricaoPedido = descricaoPedido;
		this.codigoCliente = codigoCliente;
		this.nomeCliente = nomeCliente;
		this.codigoEntregador = codigoEntregador;
		this.nomeEntregador = nomeEntregador;
	}

	public int getCodigoPedido() {
		return codigoPedido;
	}

	public void setCodigoPedido(Integer codigoPedido) {
		this.codigoPedido = codigoPedido;
	}

	public Date getDataPedido() {
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

	public Integer getCodigoCliente() {
		return codigoCliente;
	}

	public void setCodigoCliente(Integer codigoCliente) {
		this.codigoCliente = codigoCliente;
	}

	public String getNomeCliente() {
		return nomeCliente;
	}

	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}

	public void setDataPedido(Date dataPedido) {
		this.dataPedido = dataPedido;
	}

	public Integer getCodigoEntregador() {
		return codigoEntregador;
	}

	public void setCodigoEntregador(Integer codigoEntregador) {
		this.codigoEntregador = codigoEntregador;
	}

	public String getNomeEntregador() {
		return nomeEntregador;
	}

	public void setNomeEntregador(String nomeEntregador) {
		this.nomeEntregador = nomeEntregador;
	}
	
}
