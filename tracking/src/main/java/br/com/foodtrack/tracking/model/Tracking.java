package br.com.foodtrack.tracking.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "tracking_history")
public class Tracking {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer codigoRastreamento;
	
	@Column(name = "latitude")
	private Double latitude;
	
	@Column(name = "longitude")
	private Double longitude;
	
	@Column(name = "tempo")
	private LocalDateTime tempo;
	
	@Column(name = "statusEntrega", length = 30, nullable = false)
	private String statusEntrega;
	
	@ManyToOne
	@JoinColumn(name = "idPedido")
	@JsonIgnoreProperties("listaRastreamentoPedidos")
	private Pedido pedido;
	
	@ManyToOne
	@JoinColumn(name = "idEntregador")
	@JsonIgnoreProperties("listaRastreamentos")
	private Entregador entregador;

	
	
	
	
	public Integer getCodigoRastreamento() {
		return codigoRastreamento;
	}

	public void setCodigoRastreamento(Integer codigoRastreamento) {
		this.codigoRastreamento = codigoRastreamento;
	}

	public Double getLatitude() {
		return latitude;
	}

	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}

	public Double getLongitude() {
		return longitude;
	}

	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}

	public LocalDateTime getTempo() {
		return tempo;
	}

	public void setTempo(LocalDateTime tempo) {
		this.tempo = tempo;
	}

	public String getStatusEntrega() {
		return statusEntrega;
	}

	public void setStatusEntrega(String statusEntrega) {
		this.statusEntrega = statusEntrega;
	}

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	public Entregador getEntregador() {
		return entregador;
	}

	public void setEntregador(Entregador entregador) {
		this.entregador = entregador;
	}
	
	
	
}
