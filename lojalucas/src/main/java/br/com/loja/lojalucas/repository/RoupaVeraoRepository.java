package br.com.loja.lojalucas.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.loja.lojalucas.domain.RoupaVerao;


public interface RoupaVeraoRepository extends JpaRepository<RoupaVerao, Integer> {

	@Query("SELECT i from Roupa i WHERE i.modelo LIKE %:modelo% ORDER BY i.modelo")
	public Optional<RoupaVerao> findByModelo(@Param("modelo") String modelo);
}