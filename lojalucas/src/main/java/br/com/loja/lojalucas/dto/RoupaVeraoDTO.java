package br.com.loja.lojalucas.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class RoupaVeraoDTO {
	@NotEmpty
	@NotNull
	private Integer id;

	@NotEmpty
	@NotNull
	private int tipo;

	@NotEmpty
	@NotNull
	private String tamanho;

	@NotEmpty
	@NotNull
	private String modelo;

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

	public String getTamanho() {
		return tamanho;
	}

	public void setTamanho(String tamanho) {
		this.tamanho = tamanho;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
}
