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

import br.com.loja.lojalucas.dto.RoupaInvernoDTO;
import br.com.loja.lojalucas.service.RoupaInvernoService;


@RestController
@RequestMapping(value="lojalucas")
public class RoupaInvernoController {
	private RoupaInvernoService roupaInvernoService;

	@Autowired
	public RoupaInvernoController(RoupaInvernoService roupaInvernoService) {
		this.roupaInvernoService = roupaInvernoService;
	}

	@GetMapping(value = "/roupainv")
	public ResponseEntity<List<RoupaInvernoDTO>> obterRoupaInverno() {
		List<RoupaInvernoDTO> roupasInverno = roupaInvernoService.findAll();
		return new ResponseEntity<List<RoupaInvernoDTO>>(roupasInverno, HttpStatus.OK);
	}

	@GetMapping(value = "/roupainv/{modelo}")
	public ResponseEntity<RoupaInvernoDTO> obterRoupaInvernoPorModelo(@PathVariable("modelo") String modelo) {
		RoupaInvernoDTO roupaInverno = roupaInvernoService.findByModelo(modelo);
		return new ResponseEntity<RoupaInvernoDTO>(roupaInverno, HttpStatus.OK);
	}

	@PostMapping(value = "/roupainv")
	public ResponseEntity<?> salvar(@RequestBody @Valid RoupaInvernoDTO roupaInvernoDTO) {
		this.roupaInvernoService.save(roupaInvernoDTO);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@DeleteMapping(value = "/roupainv/{id}")
	public ResponseEntity<?> deletar(@PathVariable("id") Integer id) {
		this.roupaInvernoService.delete(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
