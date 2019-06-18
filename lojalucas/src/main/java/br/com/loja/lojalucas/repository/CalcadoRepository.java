package br.com.loja.lojalucas.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.loja.lojalucas.domain.Calcado;

public interface CalcadoRepository extends JpaRepository<Calcado, Integer> {
	
	@Query("SELECT COUNT(1) AS existe FROM Calcado c WHERE c.modelo = :modelo")
	public Long validateExistCalcadoByModelo(@Param("modelo") String modelo);
	
	@Query("SELECT i from Roupa i WHERE i.modelo LIKE %:modelo% ORDER BY i.modelo")
	public Optional<Calcado> findByModelo(@Param("modelo") String modelo);
}