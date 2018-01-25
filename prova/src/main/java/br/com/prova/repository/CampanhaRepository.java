package br.com.prova.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.prova.model.Campanha;

@Repository
public interface CampanhaRepository extends JpaRepository<Campanha, Long> {
	@Query("select c from Campanha c where c.dataFimVigencia = :novaData")
	List<Campanha> obterCampanhasDataFimIgual(@Param("novaData") Date novaDataFimVigencia);
	
	@Query("select c from Campanha c where c.dataFimVigencia >= :dataAtual")
	List<Campanha> buscarPorVigenciasAtivas(@Param("dataAtual") Date date);
	
	
	@Query("select c from Campanha c where c.timeCoracao.idTimeCoracao = :idTimeCoracao")
	List<Campanha> buscarTodasPorTime(@Param("idTimeCoracao") Long idTimeCoracao);
	
	@Query("select c from Campanha c order by dataFimVigencia")
	List<Campanha> buscarTodasOrdenadasDataFim();
}
