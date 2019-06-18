package br.com.loja.lojalucas.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.loja.lojalucas.dto.CalcadoDTO;
import br.com.loja.lojalucas.service.CalcadoService;


@RestController
@RequestMapping(value="lojalucas")
public class CalcadoController {
	
	private CalcadoService calcadoService;
	
	@Autowired
	public CalcadoController(CalcadoService calcadoService) {
		this.calcadoService = calcadoService;
	}
	
	@GetMapping(value="/calcado")
	public ResponseEntity<List<CalcadoDTO>> obterCalcado() {
		List<CalcadoDTO> calcados = calcadoService.findAll();
		return new ResponseEntity<List<CalcadoDTO>>(calcados, HttpStatus.OK) ;
	}
	
	@GetMapping(value="/calcado/{modelo}")
	public ResponseEntity<CalcadoDTO> obterCalcadoPorModelo(@PathVariable("modelo") String modelo) {
		CalcadoDTO calcado = calcadoService.findByModelo(modelo);
		return new ResponseEntity<CalcadoDTO>(calcado, HttpStatus.OK) ;
	}
	
	@PostMapping(value="/calcado")
	public ResponseEntity<?> salvar(@RequestBody @Valid CalcadoDTO calcadoDTO) {
		this.calcadoService.save(calcadoDTO);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	
	@DeleteMapping(value="/calcado/{id}")
	public ResponseEntity<?> deletar(@PathVariable("id") Integer id) {
		this.calcadoService.delete(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
