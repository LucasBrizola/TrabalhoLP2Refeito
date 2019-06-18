package br.com.loja.lojalucas.domain;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@DiscriminatorValue("RoupaInverno")
@Entity
public class RoupaInverno extends Roupa {
	
	
	public RoupaInverno() {
		super();
		// construtor for hibernate
	}

	public RoupaInverno(int id, int tipo, @NotNull @NotEmpty String tamanho, @NotNull @NotEmpty String modelo) {
		super(id, tipo, tamanho, modelo);
	}

	public RoupaInverno(int tipo, @NotNull @NotEmpty String tamanho, @NotNull @NotEmpty String modelo) {

		super(tipo, tamanho, modelo);
	}

}
