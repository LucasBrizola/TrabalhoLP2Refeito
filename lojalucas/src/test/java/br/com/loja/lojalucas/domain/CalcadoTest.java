package br.com.loja.lojalucas.domain;

import org.junit.Assert;
import org.junit.Test;

public class CalcadoTest {
	
	@Test
	public void deveCriarUmCalcadoValido() {
		Calcado dolce = new Calcado(3, "rasteirinha", 32);
		
		
		Assert.assertEquals(3, dolce.getTipo());
		Assert.assertEquals("rasteirinha", dolce.getModelo());
		Assert.assertEquals(32, dolce.getTamanho());
	}
}
