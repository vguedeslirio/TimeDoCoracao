package br.com.prova.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.prova.model.TimeCoracao;

@Repository
public interface TimeCoracaoRepository extends JpaRepository<TimeCoracao, Long> {
	
	@Query("select t from TimeCoracao t where t.nome = :nomeTime")
	TimeCoracao obterPorNome(@Param("nomeTime") String nomeTime);	

}
