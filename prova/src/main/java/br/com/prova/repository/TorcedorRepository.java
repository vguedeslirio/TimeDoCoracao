package br.com.prova.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.prova.model.Torcedor;

@Repository
public interface TorcedorRepository extends JpaRepository<Torcedor, Long> {
	@Query("select t from Torcedor t where t.email = :novoEmail")
	Torcedor obterPorEmail(@Param("novoEmail") String novoEmail);	
}
