package br.com.loja.lojalucas.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.loja.lojalucas.domain.Calcado;
import br.com.loja.lojalucas.dto.CalcadoDTO;
import br.com.loja.lojalucas.repository.CalcadoRepository;

@Service
public class CalcadoService {
	private CalcadoRepository calcadoRepository;
	
	@Autowired
	public CalcadoService(CalcadoRepository calcadoRepository) {
		this.calcadoRepository = calcadoRepository;
	}

	public void save(CalcadoDTO calcadoDTO) {
		int tipo = calcadoDTO.getTipo();
		String modelo = calcadoDTO.getModelo();
		int tamanho = calcadoDTO.getTamanho();

		Calcado calcado = new Calcado(tipo, modelo, tamanho);
		this.calcadoRepository.saveAndFlush(calcado);
	}

	public Calcado findById(Integer id) {
		Optional<Calcado> calcado = calcadoRepository.findById(id);
		if (calcado.isPresent()) {
			return calcado.get();
		}
		throw new ServiceException("Calcado não encontrado");
	}

	public List<CalcadoDTO> findAll() {
		List<CalcadoDTO> calcadoParaRetorno = new ArrayList<CalcadoDTO>();
		List<Calcado> calcados = calcadoRepository.findAll();

		for (Calcado calcado : calcados) {
			CalcadoDTO calcadoDTO = criarCalcadoDTO(calcado);
			calcadoParaRetorno.add(calcadoDTO);
		}

		return calcadoParaRetorno;
	}

	private CalcadoDTO criarCalcadoDTO(Calcado calcado) {
		CalcadoDTO calcadoDTO = new CalcadoDTO();
		calcadoDTO.setId(calcado.getId());
		calcadoDTO.setTipo(calcado.getTipo());
		calcadoDTO.setModelo(calcado.getModelo());
		calcadoDTO.setTamanho(calcado.getTamanho());
		return calcadoDTO;
	}

	public void delete(Integer id) {
		this.calcadoRepository.deleteById(id);
	}
	
	public void deleteAll() {
		this.calcadoRepository.deleteAll();
	}

	public CalcadoDTO findByModelo(String modelo) {
		Optional<Calcado> calcado = calcadoRepository.findByModelo(modelo);
		if (calcado.isPresent()) {
			CalcadoDTO calcadoDTO = criarCalcadoDTO(calcado.get());
			return calcadoDTO;
		}
		throw new ServiceException("Calcado não encontrado");
	}

	public void update(CalcadoDTO calcadoDTO) {
		Optional<Calcado> calcado = calcadoRepository.findById(calcadoDTO.getId());
		int id = calcadoDTO.getId();
		String modelo = calcadoDTO.getModelo();
		int tamanho = calcadoDTO.getTamanho();
		int tipo = calcadoDTO.getTipo();
		
		Calcado calcadoParaSalvar = new Calcado(id, tamanho, modelo, tipo);
		this.calcadoRepository.saveAndFlush(calcadoParaSalvar);
	}
	
	private void validarInsertCalcado(Calcado calcado) {

		Long numberOfCalcadoWithModelo = calcadoRepository.validateExistCalcadoByModelo(calcado.getModelo());
		if (numberOfCalcadoWithModelo > 0) {
			throw new ServiceException("Condomino já cadastrado");
		}
	}
}
