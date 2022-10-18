package com.taller2.dto.resultado;

public class ResultadoDTO {
	private int idResultado;
	private String descPrueba;
	private String fechaPrueba;
	private int cantPreguntasPrueba;
	private int cantPreguntasBien;
	
	
	public ResultadoDTO(int idResultado, String descPrueba, String fechaPrueba, int cantPreguntasPrueba,
			int cantPreguntasBien) {
		this.idResultado = idResultado;
		this.descPrueba = descPrueba;
		this.fechaPrueba = fechaPrueba;
		this.cantPreguntasPrueba = cantPreguntasPrueba;
		this.cantPreguntasBien = cantPreguntasBien;
	}
	
	
	public int getIdResultado() {
		return idResultado;
	}
	public void setIdResultado(int idResultado) {
		this.idResultado = idResultado;
	}
	public String getDescPrueba() {
		return descPrueba;
	}
	public void setDescPrueba(String descPrueba) {
		this.descPrueba = descPrueba;
	}
	public String getFechaPrueba() {
		return fechaPrueba;
	}
	public void setFechaPrueba(String fechaPrueba) {
		this.fechaPrueba = fechaPrueba;
	}
	public int getCantPreguntasPrueba() {
		return cantPreguntasPrueba;
	}
	public void setCantPreguntasPrueba(int cantPreguntasPrueba) {
		this.cantPreguntasPrueba = cantPreguntasPrueba;
	}
	public int getCantPreguntasBien() {
		return cantPreguntasBien;
	}
	public void setCantPreguntasBien(int cantPreguntasBien) {
		this.cantPreguntasBien = cantPreguntasBien;
	}
	
	
}
