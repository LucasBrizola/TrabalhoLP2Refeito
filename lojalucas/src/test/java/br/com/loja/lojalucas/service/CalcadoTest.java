package br.com.loja.lojalucas.service;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import br.com.loja.lojalucas.domain.Calcado;
import br.com.loja.lojalucas.dto.CalcadoDTO;
import br.com.loja.lojalucas.repository.CalcadoRepository;

public class CalcadoTest {
	
	@Autowired
	private CalcadoService calcadoService;
	
	@Autowired
	private CalcadoRepository calcadoRepository;
	private Calcado nike;
	
	@Before
	public void setup() {
		nike = new Calcado(3,"tenis nike", 38);
		calcadoRepository.saveAndFlush(nike);
	}
	
	@After
	public void finalizar() {
		calcadoService.deleteAll();
	}
	
	@Test
	public void deveSalvarUmCalcado() {
		CalcadoDTO calcadoParaSalvar = new CalcadoDTO();
		calcadoParaSalvar.setTipo(3);
		calcadoParaSalvar.setModelo("chinelo adidas");
		calcadoParaSalvar.setTamanho(43);
		
		calcadoService.save(calcadoParaSalvar);
		CalcadoDTO chineloNike = calcadoService.findByModelo("chinelo nike");
		chineloNike.setTamanho(42);
		calcadoService.update(chineloNike);
		chineloNike = calcadoService.findByModelo("chinelo nike");
		Assert.assertEquals(42, chineloNike.getTamanho());

	}
}
