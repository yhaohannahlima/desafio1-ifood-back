package br.com.foodtrack.tracking.DTO;

import java.sql.Timestamp;

import br.com.foodtrack.tracking.model.Rastreamento;

public class RastreamentoDTO {

	private Integer codigoRastreamento;
	private Double latitude;
	private Double longitude;
	private Timestamp tempo;
	private Integer idPedido;

	public RastreamentoDTO() {

	}

	public RastreamentoDTO(Integer codigoRastreamento, Double latitude, Double longitude, Timestamp tempo,
			Integer idPedido) {
		super();
		this.codigoRastreamento = codigoRastreamento;
		this.latitude = latitude;
		this.longitude = longitude;
		this.tempo = tempo;
		this.idPedido = idPedido;
	}

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

	public Timestamp getTempo() {
		return tempo;
	}

	public void setTempo(Timestamp tempo) {
		this.tempo = tempo;
	}

	public Integer getIdPedido() {
		return idPedido;
	}

	public void setIdPedido(Integer idPedido) {
		this.idPedido = idPedido;
	}

	public static RastreamentoDTO fromRastreamento(Rastreamento rastreamento) {
		
		
		return new RastreamentoDTO(rastreamento.getCodigoRastreamento(), rastreamento.getLatitude(),
				rastreamento.getLongitude(), rastreamento.getTempo(), rastreamento.getPedido().getCodigoPedido());
	}

	@Override
	public String toString() {
		return "RastreamentoDTO [codigoRastreamento=" + codigoRastreamento + ", latitude=" + latitude + ", longitude="
				+ longitude + ", tempo=" + tempo + ", idPedido=" + idPedido + "]";
	}

}
