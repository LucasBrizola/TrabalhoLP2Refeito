package br.com.loja.lojalucas.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.loja.lojalucas.domain.RoupaInverno;
import br.com.loja.lojalucas.dto.RoupaInvernoDTO;
import br.com.loja.lojalucas.repository.RoupaInvernoRepository;


@Service
public class RoupaInvernoService {
	private RoupaInvernoRepository roupaInvernoRepository;

	@Autowired
	public RoupaInvernoService(RoupaInvernoRepository roupaInvernoRepository) {
		this.roupaInvernoRepository = roupaInvernoRepository;
	}

	public void save(RoupaInvernoDTO roupaInvernoDTO) {
		int tipo = roupaInvernoDTO.getTipo();
		String modelo = roupaInvernoDTO.getModelo();
		String tamanho = roupaInvernoDTO.getTamanho();

		RoupaInverno roupaInverno = new RoupaInverno(tipo, modelo, tamanho);
		this.roupaInvernoRepository.saveAndFlush(roupaInverno);
	}

	public RoupaInverno findById(Integer id) {
		Optional<RoupaInverno> roupaInverno = roupaInvernoRepository.findById(id);
		if (roupaInverno.isPresent()) {
			return roupaInverno.get();
		}
		throw new ServiceException("Roupa de inverno não encontrada");
	}

	public List<RoupaInvernoDTO> findAll() {
		List<RoupaInvernoDTO> roupaInvernoParaRetorno = new ArrayList<RoupaInvernoDTO>();
		List<RoupaInverno> roupasInverno = roupaInvernoRepository.findAll();

		for (RoupaInverno roupaInverno : roupasInverno) {
			RoupaInvernoDTO roupaInvernoDTO = criarRoupaInvernoDTO(roupaInverno);
			roupaInvernoParaRetorno.add(roupaInvernoDTO);
		}

		return roupaInvernoParaRetorno;
	}

	private RoupaInvernoDTO criarRoupaInvernoDTO(RoupaInverno roupaInverno) {
		RoupaInvernoDTO roupaInvernoDTO = new RoupaInvernoDTO();
		roupaInvernoDTO.setId(roupaInverno.getId());
		roupaInvernoDTO.setTipo(roupaInverno.getTipo());
		roupaInvernoDTO.setModelo(roupaInverno.getModelo());
		roupaInvernoDTO.setTamanho(roupaInverno.getTamanho());
		return roupaInvernoDTO;
	}

	public void delete(Integer id) {
		this.roupaInvernoRepository.deleteById(id);
	}

	public RoupaInvernoDTO findByModelo(String modelo) {
		Optional<RoupaInverno> roupaInverno = roupaInvernoRepository.findByModelo(modelo);
		if (roupaInverno.isPresent()) {
			RoupaInvernoDTO roupaInvernoDTO = criarRoupaInvernoDTO(roupaInverno.get());
			return roupaInvernoDTO;
		}
		throw new ServiceException("Roupa de Inverno não encontrado");
	}

}
