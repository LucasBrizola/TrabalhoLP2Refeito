package br.com.loja.lojalucas.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class CalcadoDTO {

	private Integer id;

	@NotNull
	@NotEmpty
	private int tipo;

	@NotEmpty
	@NotNull
	private String modelo;

	@NotEmpty
	@NotNull
	private int tamanho;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public int getTipo() {
		return tipo;
	}

	public void setTipo(int tipo) {
		this.tipo = tipo;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public int getTamanho() {
		return tamanho;
	}

	public void setTamanho(int tamanho) {
		this.tamanho = tamanho;
	}
}
