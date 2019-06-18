package br.com.loja.lojalucas.domain;

import org.junit.Assert;
import org.junit.Test;

public class RoupaInvernoTest {
	@Test
	public void deveCriarUmaRoupaValida() {
		Roupa sarwell = new RoupaInverno(2, "GG","Calca");
		
				
		Assert.assertEquals(2, sarwell.getTipo());
		Assert.assertEquals("GG", sarwell.getTamanho());
		Assert.assertEquals("Calca", sarwell.getModelo());

	}
}
