package br.com.prova.repository;
import static org.assertj.core.api.Assertions.assertThat;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.prova.model.Campanha;
import br.com.prova.model.TimeCoracao;

@RunWith(SpringRunner.class)
@DataJpaTest
public class CampanhaRepositoryTests {

	@Autowired
	private TestEntityManager entityManager;

	@Autowired
	private CampanhaRepository repository;
	
	@Before
    public void dataLoader() throws ParseException {
		this.entityManager.persist(new Campanha(null, "CorinthiansTest", new TimeCoracao("Corinthians"), new SimpleDateFormat("yyyy-MM-dd").parse("2014-02-14"),
				new SimpleDateFormat("yyyy-MM-dd").parse("2019-10-01")));
		
		this.entityManager.persist(new Campanha(null, "CorinthiansTest2", new TimeCoracao("Meirinhas"), new SimpleDateFormat("yyyy-MM-dd").parse("2014-02-14"),
				new SimpleDateFormat("yyyy-MM-dd").parse("2019-10-01")));
    }
	
	@Test
	public void buscarPorVigenciasAtivasTest() throws Exception {
		
		List<Campanha> campanhasAtivas = this.repository.buscarPorVigenciasAtivas(new SimpleDateFormat("yyyy-MM-dd").parse("2019-09-01"));
		
		assertThat(campanhasAtivas.size()).isEqualTo(2);
	}

}