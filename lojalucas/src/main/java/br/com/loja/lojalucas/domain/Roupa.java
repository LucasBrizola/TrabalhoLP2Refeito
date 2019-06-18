package br.com.loja.lojalucas.domain;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "de qual tipo")
@Table(name = "roupa")
abstract class Roupa extends BaseDominio {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "roupaid")
	private Integer id;

	@NotEmpty
	@NotNull
	private int tipo; // verao, inverno

	@NotNull
	@NotEmpty
	private String tamanho; // p, m , g

	@NotNull
	@NotEmpty
	private String modelo; // Vestido, blusa, calca

	protected Roupa() {
		// constructor for hibernate
	}

	public Roupa(Integer id, int tipo, String tamanho, String modelo) {
		super();
		this.id = id;
		this.tipo = tipo;
		this.tamanho = tamanho;
		this.modelo = modelo;
	}

	public Roupa(int tipo, String tamanho, String modelo) {
		super();
		this.tipo = tipo;
		this.tamanho = tamanho;
		this.modelo = modelo;
	}

	public Integer getId() {
		return id;
	}

	public int getTipo() {
		return tipo;
	}

	public String getTamanho() {
		return tamanho;
	}

	public String getModelo() {
		return modelo;
	}

}
