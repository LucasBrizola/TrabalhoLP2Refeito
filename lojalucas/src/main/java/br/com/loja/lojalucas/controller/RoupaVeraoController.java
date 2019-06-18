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

import br.com.loja.lojalucas.dto.RoupaVeraoDTO;
import br.com.loja.lojalucas.service.RoupaVeraoService;


@RestController
@RequestMapping(value = "lojalucas")
public class RoupaVeraoController {
	
	private RoupaVeraoService roupaVeraoService;

	@Autowired
	public RoupaVeraoController(RoupaVeraoService roupaVeraoService) {
		this.roupaVeraoService = roupaVeraoService;
	}

	@GetMapping(value = "/roupaverao")
	public ResponseEntity<List<RoupaVeraoDTO>> obterRoupaVerao() {
		List<RoupaVeraoDTO> roupasVerao = roupaVeraoService.findAll();
		return new ResponseEntity<List<RoupaVeraoDTO>>(roupasVerao, HttpStatus.OK);
	}

	@GetMapping(value = "/roupaverao/{modelo}")
	public ResponseEntity<RoupaVeraoDTO> obterRoupaVeraoPorModelo(@PathVariable("modelo") String modelo) {
		RoupaVeraoDTO roupaVerao = roupaVeraoService.findByModelo(modelo);
		return new ResponseEntity<RoupaVeraoDTO>(roupaVerao, HttpStatus.OK);
	}

	@PostMapping(value = "/roupaverao")
	public ResponseEntity<?> salvar(@RequestBody @Valid RoupaVeraoDTO roupaVeraoDTO) {
		this.roupaVeraoService.save(roupaVeraoDTO);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@DeleteMapping(value = "/roupavrao/{id}")
	public ResponseEntity<?> deletar(@PathVariable("id") Integer id) {
		this.roupaVeraoService.delete(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
