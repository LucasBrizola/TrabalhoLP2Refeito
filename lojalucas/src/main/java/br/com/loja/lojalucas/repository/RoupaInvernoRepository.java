package br.com.loja.lojalucas.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.loja.lojalucas.domain.RoupaInverno;

public interface RoupaInvernoRepository extends JpaRepository<RoupaInverno, Integer> {

	@Query("SELECT i from Roupa i WHERE i.modelo LIKE %:modelo% ORDER BY i.modelo")
	public Optional<RoupaInverno> findByModelo(@Param("modelo") String modelo);
}
