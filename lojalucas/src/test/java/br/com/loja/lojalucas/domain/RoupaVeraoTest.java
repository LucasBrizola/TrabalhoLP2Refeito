package br.com.loja.lojalucas.domain;

import org.junit.Assert;
import org.junit.Test;

public class RoupaVeraoTest {
	
	@Test
	public void deveCriarUmaRoupaVeraoValida() {
		Roupa biquini = new RoupaVerao(1, "M", "biquini");

		Assert.assertEquals(1, biquini.getTipo());
		Assert.assertEquals("M", biquini.getTamanho());
		Assert.assertEquals("biquini", biquini.getModelo());

	}
}
